package com.scxinglin.utils;

public class OptimisticLockingException extends RuntimeException{
    private static final String format = "受影响的行数不为%s: %s";

    public static final OptimisticLockingException throwException(int dest,int rowCount) {
        String msg = String.format(format, dest, rowCount);
        return new OptimisticLockingException(msg);
    }

    private OptimisticLockingException(String msg){
        super(msg);
    }
}
