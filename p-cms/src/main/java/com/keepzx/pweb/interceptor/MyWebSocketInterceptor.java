package com.keepzx.pweb.interceptor;

import com.alipay.api.domain.Account;
import com.keepzx.pweb.common.constant.SessionConstant;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 此类用来获取登录用户信息并交由websocket管理
 * @author ts
 *
 */
public class MyWebSocketInterceptor implements HandshakeInterceptor {

    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
                                   Map<String, Object> attributes) throws Exception {
        //将ServerHttpRequest转换成request请求相关的类，用来获取request域中的用户信息
        if (request instanceof ServletServerHttpRequest) {
            ServletServerHttpRequest servletRequest  = (ServletServerHttpRequest) request;
            HttpServletRequest httpRequest = servletRequest.getServletRequest();
            //Constants.CURRENT_USER这个是我定义的常量，是request域的key，通过key就可以获取到用户信息了
            Account accountBean = (Account)httpRequest.getSession().getAttribute(SessionConstant.SESSION_ACCOUNT.name());


            //Constants.CURRENT_WEBSOCKET_USER也是常量，用来存储WebsocketSession的key值
            attributes.put("websocketPhaId",accountBean);
        }
        return true;
    }
    @Override
    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
                               Exception exception) {
    }
}
