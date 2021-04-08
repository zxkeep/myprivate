package com.keepzx.config.db;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ReportLogAspect {

    private Logger logger = LoggerFactory.getLogger(ReportLogAspect.class);

    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        long startTime = System.currentTimeMillis();
        Signature signature =  pjp.getSignature();
        String methodName =  signature.getDeclaringTypeName();
        Object[] args = pjp.getArgs();
        logger.info("start query,method:{} args:{}",methodName,getParamString(args));
        Object retVal = pjp.proceed();
        long endTime = System.currentTimeMillis();
        logger.info("{} finish! using time :{}s",methodName,(endTime-startTime)/1000);
        return retVal;
    }

    private String getParamString(Object[] args){
        if(args==null || args.length==0){
            return "empty param";
        }
        StringBuilder str = new StringBuilder();
        for (Object arg : args) {
            str.append(arg).append(",");
        }
        return str.toString();
    }


}
