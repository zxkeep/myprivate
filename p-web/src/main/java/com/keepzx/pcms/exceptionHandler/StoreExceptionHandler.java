package com.keepzx.pcms.exceptionHandler;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class StoreExceptionHandler implements HandlerExceptionResolver {
    private static final String TAG = StoreExceptionHandler.class.getName();
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse response, Object o, Exception e) {
        Logger.getLogger(TAG).info("StoreExceptionHandler catch exception :"+e);
            ModelAndView mv = new ModelAndView();
            response.setStatus(HttpStatus.OK.value());
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
            response.setCharacterEncoding("UTF-8");
            try {
                response.getWriter().write(e.getMessage());
            } catch (IOException ee) {
                ee.printStackTrace();
            }
            return mv;
    }
}
