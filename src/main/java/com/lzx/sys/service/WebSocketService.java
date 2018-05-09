package com.lzx.sys.service;

import com.lzx.sys.websocket.WebSocketServer;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * Created by lizhongxiang on
 *
 * @author : lzx
 * 时间 : 2018/5/9.
 */
@Service
public class WebSocketService {

    @Async
    public void sendInfo(String msg){
        WebSocketServer.sendInfo(msg);
    }

}
