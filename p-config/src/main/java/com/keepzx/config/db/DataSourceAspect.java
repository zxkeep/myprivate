package com.keepzx.config.db;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

import static com.keepzx.config.db.DynamicDataSourceHolder.MASTER_DATASOURCE_NAME;

public class DataSourceAspect {
    private static final Logger LOG = LoggerFactory.getLogger(DataSourceAspect.class);

    public void before(JoinPoint point) {
        Object target = point.getTarget();
        String method = point.getSignature().getName();

        Class<?>[] classz = target.getClass().getInterfaces();
        if (classz == null || classz.length == 0) {
            DynamicDataSourceHolder.setDataSourceName(MASTER_DATASOURCE_NAME);
            return;
        }

        Class<?>[] parameterTypes = ((MethodSignature) point.getSignature()).getMethod().getParameterTypes();
        Method m = null;
        try {
            m = classz[0].getMethod(method, parameterTypes);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }

        if (m == null) {
            DynamicDataSourceHolder.setDataSourceName(MASTER_DATASOURCE_NAME);
            return;
        }

        if (m.isAnnotationPresent(DataSource.class)) {
            DataSource data = m.getAnnotation(DataSource.class);
            DynamicDataSourceHolder.setDataSourceName(data.value());
            return;
        } else {
            DynamicDataSourceHolder.setDataSourceName(MASTER_DATASOURCE_NAME);
            return;
        }
    }

    public void afterReturning() throws Throwable {
        DynamicDataSourceHolder.removeDataSourceName();
    }
}
