package com.keepzx.pcms.exceptionHandler;



import com.keepzx.pcms.common.BaseResultVO;
import com.keepzx.pcms.common.constant.ResponseConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class RRExceptionHandler {
    private Logger logger=LoggerFactory.getLogger(getClass());
    @ExceptionHandler(Exception.class)
    public ResponseEntity<BaseResultVO> handleException(Exception e){
        BaseResultVO baseResultVO=new BaseResultVO(ResponseConstant.SYSTERM_EXCEPT.getCode(),e.getMessage());
        logger.error(e.getMessage(),e);
        return  new ResponseEntity(baseResultVO,HttpStatus.OK);
    }

    @ExceptionHandler(MyException.class)
    public ResponseEntity<BaseResultVO> handleException(MyException e){
        BaseResultVO baseResultVO=new BaseResultVO(ResponseConstant.SYSTERM_EXCEPT.getCode(),e.getMessage());
        logger.error(e.getMessage(),e);
        return  new ResponseEntity(baseResultVO,HttpStatus.OK);
    }
}
