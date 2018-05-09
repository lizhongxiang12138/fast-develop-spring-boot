package com.lzx.sys.websocket;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * Created by lizhongxiang on
 *
 * @author : lzx
 * 时间 : 2018/5/8.
 */
@ServerEndpoint(value = "/websocket")
@Component
public class WebSocketServer {
    /**
     * 在线数量
     */
    private static int ONLINE_COUNT = 0;
    /**
     * 存放客户端对应的webSocket
     */
    private static CopyOnWriteArraySet<WebSocketServer> WEB_SOCKET_SET = new CopyOnWriteArraySet<>();
    /**
     * 会话
     */
    private Session session;

    /**
     * 建立连接成功调用的方法
     * @param session
     */
    @OnOpen
    public void onOpen(Session session){
        this.session = session;
        WEB_SOCKET_SET.add(this);
        addOnlineCount();
        System.out.println("有新连接加入!当前在线人数为"+getOnlineCount());
        try {
            sendMessage("连接成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 关闭连接
     */
    @OnClose
    public void onClose(){
        WEB_SOCKET_SET.remove(this);
        subOnlineCount();
        System.out.println("有一个连接关闭!当前在线人数:"+getOnlineCount());
    }

    /**
     * 发生错误时执行
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session,Throwable error){
        System.out.println("有一个连接发生错误!当前在线人数:"+getOnlineCount());
        error.printStackTrace();
    }

    /**
     * 收到服务端的消息
     * @param msg
     * @param session
     */
    @OnMessage
    public void onMessage(String msg,Session session){
        sendInfo(msg);
    }

    /**
     * 广播
     * @param message
     */
    public static void sendInfo(String message){
        if(StringUtils.isBlank(message)){return;}
        for (WebSocketServer wss:WEB_SOCKET_SET) {
            try {
                wss.sendMessage(message);
            } catch (IOException e) {
                e.printStackTrace();
                continue;
            }
        }
    }

    /**
     * 获取在线人数
     * @return
     */
    public static synchronized int getOnlineCount(){
        return ONLINE_COUNT;
    }

    /**
     * 在线人数+1
     */
    public static synchronized void addOnlineCount(){
        ONLINE_COUNT++;
    }

    public static synchronized void subOnlineCount(){
        ONLINE_COUNT--;
    }

    /**
     * 发送消息
     * @param message
     * @throws IOException
     */
    public void sendMessage(String message) throws IOException {
//        this.session.getBasicRemote().sendText(message);
        this.session.getAsyncRemote().sendText(message);
    }
}
