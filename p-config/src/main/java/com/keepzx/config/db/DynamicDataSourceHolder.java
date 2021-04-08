package com.keepzx.config.db;

import java.util.concurrent.CountDownLatch;

public class DynamicDataSourceHolder {
    private static final ThreadLocal<String> holder = new ThreadLocal<String>();

    public static void setDataSourceName(String name) { holder.set(name); }
    public static String getDataSourceName() { return holder.get(); }
    public static void removeDataSourceName() { holder.remove(); }

    public static final String MASTER_DATASOURCE_NAME   = "master";
    public static final String SLAVE_DATASOURCE_NAME    = "slave";



    public static <T> T execute(String datasource_name,Callback<T> callback) throws Exception {
        try {
            setDataSourceName(datasource_name);
            return callback.run();
        } finally {
            removeDataSourceName();
        }
    }

    /**
     * 异步执行
     * @param datasource_name 数据源名称
     * @param callback 回调操作
     * @param <T>
     * @return
     */
    public static <T> T asyncExecute(String datasource_name,Callback<T> callback) throws Exception {
        AsyncTask<T,Throwable> task = new AsyncTask<>(datasource_name,callback);
        task.start();
        task.await();
        if (task.getException() != null) {
            throw new Exception(task.getException());
        }
        return task.getReturnObject();
    }

    private static class AsyncTask<Y,E extends Throwable>{
        private final CountDownLatch latch = new CountDownLatch(1);
        private final Callback<Y> callback;
        private final String datasourceName;
        private volatile Y returnObject;
        private volatile E exception;

        public Y getReturnObject() { return returnObject; }
        public E getException() { return exception; }
        public AsyncTask(String datasourceName, Callback<Y> callback){
            this.callback = callback;
            this.datasourceName = datasourceName;
        }
        private void run() {
            try {
                setDataSourceName(this.datasourceName);
                this.returnObject = callback.run();
            } catch (Throwable ex) {
                this.exception = (E)ex;
            } finally {
                removeDataSourceName();
                latch.countDown();
            }
        }
        public void start(){
            Thread t =  new Thread(this::run);
            t.start();
        }
        public void await() throws InterruptedException {
            this.latch.await();
        }
    }


    @FunctionalInterface
    public static interface Callback<T> {
        public T run() throws Exception;
    }
}
