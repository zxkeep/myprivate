package com.keepzx.pcms.interceptor;

import com.alipay.api.domain.Account;
import com.keepzx.pcms.common.BaseResultVO;
import com.keepzx.pcms.common.constant.ResponseConstant;
import com.keepzx.pcms.common.constant.SessionConstant;
import com.keepzx.utils.InterceptorReturn;
import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

@Slf4j
public class SessionInterceptor implements HandlerInterceptor {


    private static final String TAG = SessionInterceptor.class.getName();
    private static final Set<String> KEY =  new ConcurrentSkipListSet<>();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        Account accountBean = (Account)request.getSession().getAttribute(SessionConstant.SESSION_ACCOUNT.name());
        if (accountBean == null) {
            BaseResultVO baseResultVO = new BaseResultVO(ResponseConstant.OPERATION_WITHOUT_LOGIN);
            InterceptorReturn.returnError(response,baseResultVO);
            return false;
        }
        int port = request.getServerPort();
        String url = request.getRequestURL().toString();
        //端口为8080且IP地址不是本地地址
        if(port==8080 && !url.contains("localhost") && !url.contains("192.168")&& !url.contains("127.0")){
            response.sendRedirect(request.getScheme()+"://"+request.getServerName()+request.getContextPath() + "/home");
            return false;
        }
        String requestURI = request.getRequestURI();
        if("/store/abacus/order/create".equals(requestURI)){
            boolean success = KEY.add(requestURI);
            if(!success){
                return false;
            }
        }
        Logger.getLogger(TAG).info("preHandle url:" + request.getRequestURI());
        Logger.getLogger(TAG).info("handle account id is :" + accountBean);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception ex) throws Exception {
        String requestURI = request.getRequestURI();
        KEY.remove(requestURI);
    }

}
