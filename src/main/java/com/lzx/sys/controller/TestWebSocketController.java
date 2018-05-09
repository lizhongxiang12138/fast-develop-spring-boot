package com.lzx.sys.controller;

import com.lzx.sys.dto.ReturnDTO;
import com.lzx.sys.service.WebSocketService;
import com.lzx.sys.websocket.WebSocketServer;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lizhongxiang on
 *
 * @author : lzx
 * 时间 : 2018/5/9.
 */
@RestController
public class TestWebSocketController {

    private WebSocketService webSocketService;

    public TestWebSocketController(WebSocketService webSocketService) {
        this.webSocketService = webSocketService;
    }

    /**
     * 发送消息测试
     * @param msg
     * @return
     */
    @GetMapping("/webSocketSendTest")
    public ReturnDTO<String> testSendInfo(@RequestParam("msg")String msg){
        try {
            webSocketService.sendInfo(msg);
            return new ReturnDTO<String>(ReturnDTO.SUCCESS,"发送成功",null,null);
        } catch (Exception e) {
            e.printStackTrace();
            return new ReturnDTO<String>(ReturnDTO.FAIL,e.getMessage(),null,null);
        }
    }



}
