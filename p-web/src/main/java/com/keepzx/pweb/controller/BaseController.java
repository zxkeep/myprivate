package com.keepzx.pweb.controller;

import com.alipay.api.domain.Account;
import com.keepzx.pweb.common.constant.SessionConstant;
import com.keepzx.pweb.interceptor.WebSocketPushHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import javax.servlet.http.HttpServletRequest;

public class BaseController {


    @Autowired
    protected HttpServletRequest request;

    Integer getSessionAccountId() {
        Account account = (Account)request.getSession().getAttribute(SessionConstant.SESSION_ACCOUNT.name());
        return 1;
    }

    Integer getSessionPharmacyId() {
        return (Integer)request.getSession().getAttribute(SessionConstant.SESSION_PHA_ID.name());

    }

    @Bean
    public WebSocketPushHandler getWebSocketPushHandler() {
        return new WebSocketPushHandler();
    }
}
