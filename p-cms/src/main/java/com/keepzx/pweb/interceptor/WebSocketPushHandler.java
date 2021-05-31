package com.keepzx.pweb.interceptor;

import org.springframework.web.socket.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WebSocketPushHandler implements WebSocketHandler {

    private static final List<WebSocketSession> users = new ArrayList<>();
    //用户进入系统监听
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println("成功进入了系统。。。");
        users.add(session);
        Integer phaId=(Integer)session.getHandshakeAttributes().get("websocketPhaId");
        //OrderService orderService=(OrderService)SpringContextUtils.getBeanByClass(OrderService.class);
        String msg = getOrderInfo(phaId);
        //String msg = JsonHelper.beanToString(baseResultVO);
        TextMessage textMessage = new TextMessage(msg);
        session.sendMessage(textMessage);
    }

    //
    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        /*将消息进行转化，因为是消息是json数据，可能里面包含了发送给某个人的信息，所以需要用json相关的工具类处理之后再封装成TextMessage，
        我这儿并没有做处理，消息的封装格式一般有{from:xxxx,to:xxxxx,msg:xxxxx}，来自哪里，发送给谁，什么消息等等*/
        TextMessage msg = (TextMessage)message.getPayload();
        //给所有用户群发消息
        sendMessagesToUsers(msg);
        //给指定用户群发消息
       // sendMessageToUser(session.getHandshakeAttributes().get("websocketUser"),msg);


    }

    //后台错误信息处理方法
    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {

    }


    //用户退出后的处理，不如退出之后，要将用户信息从websocket的session中remove掉，这样用户就处于离线状态了，也不会占用系统资源
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        if(session.isOpen()){
            session.close();
        }
        users.remove(session);
        System.out.println("安全退出了系统");

    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }

    /**
     * 给所有的用户发送消息
     */
    public void sendMessagesToUsers(TextMessage message){
        for(WebSocketSession user : users){
            try {
                //isOpen()在线就发送
                if(user.isOpen()){
                    user.sendMessage(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 发送消息给指定的用户
     */
    public void sendMessageToUser(Integer phaId,TextMessage message){
        for(WebSocketSession user : users){
            if(user.getHandshakeAttributes().get("websocketPhaId").equals(phaId)){
                try {
                    //isOpen()在线就发送
                    if(user.isOpen()){
                        user.sendMessage(message);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public String getOrderInfo(Integer phaId) throws IOException {
        /*OrderBean orderbean=new OrderBean();
        orderbean.setPhaId(phaId);
        orderbean.setOrdStatus(Indicator.ORD_STATUS_CONFIRM.getCode());
        Integer confirmOrderNum = orderService.selectNewOrderByPhaId(orderbean);
        orderbean.setOrdStatus(Indicator.ORD_STATUS_NEW.getCode());
        Integer newOrderNum = orderService.selectNewOrderByPhaId(orderbean);
        orderbean.setOrdStatus(Indicator.ORD_STATUS_REVIEW.getCode());
        Integer reviewOrderNum = orderService.selectNewOrderByPhaId(orderbean);
        orderbean.setOrdStatus(Indicator.ORD_STATUS_TAKING.getCode());
        Integer takingOrderNum = orderService.selectNewOrderByPhaId(orderbean);
        orderbean.setOrdStatus(Indicator.ORD_STATUS_DOSAGE.getCode());
        Integer dosageOrderNum = orderService.selectNewOrderByPhaId(orderbean);
        orderbean.setOrdStatus(Indicator.ORD_STATUS_WAIT.getCode());
        Integer waitOrderNum = orderService.selectNewOrderByPhaId(orderbean);
        orderbean.setOrdStatus(Indicator.ORD_STATUS_SEND.getCode());
        Integer sendOrderNum = orderService.selectNewOrderByPhaId(orderbean);
        orderbean.setOrdStatus(Indicator.ORD_STATUS_PICK.getCode());
        Integer pickOrderNum = orderService.selectNewOrderByPhaId(orderbean);
        orderbean.setOrdStatus(Indicator.ORD_STATUS_COMPLETE.getCode());
        Integer completeOrderNum = orderService.selectNewOrderByPhaId(orderbean);
        orderbean.setOrdStatus(Indicator.ORD_STATUS_CANCEL.getCode());
        Integer cancelOrderNum = orderService.selectNewOrderByPhaId(orderbean);
        OrderNumVO orderNumVO=new OrderNumVO();
        orderNumVO.setConfirmOrderNum(confirmOrderNum);
        orderNumVO.setNewOrderNum(newOrderNum);
        orderNumVO.setReviewOrderNum(reviewOrderNum);
        orderNumVO.setCancelOrderNum(cancelOrderNum);
        orderNumVO.setCompleteOrderNum(completeOrderNum);
        orderNumVO.setDosageOrderNum(dosageOrderNum);
        orderNumVO.setPickOrderNum(pickOrderNum);
        orderNumVO.setTakingOrderNum(takingOrderNum);
        orderNumVO.setSendOrderNum(sendOrderNum);
        orderNumVO.setWaitOrderNum(waitOrderNum);

        BaseResultVO baseResultVO=new BaseResultVO(orderNumVO);
        String msg = JsonHelper.beanToString(baseResultVO);
        return  msg;*/
return null;
    }
}
