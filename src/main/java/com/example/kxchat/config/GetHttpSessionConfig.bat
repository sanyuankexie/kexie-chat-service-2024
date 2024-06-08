package com.example.kxchat.config;


import jakarta.servlet.http.HttpSession;
import jakarta.websocket.HandshakeResponse;
import jakarta.websocket.server.HandshakeRequest;
import jakarta.websocket.server.ServerEndpointConfig;

public class GetHttpSessionConfig extends ServerEndpointConfig.Configurator {

    @Override
    public void modifyHandshake(ServerEndpointConfig sec, HandshakeRequest request, HandshakeResponse response) {
        // 获取HttpSession对象
        HttpSession httpSession = (HttpSession) request.getHttpSession();
        System.out.println(httpSession.getAttribute("user"));
        if (httpSession != null) {
            // 如果httpSession不为null，则将其保存起来
            sec.getUserProperties().put(HttpSession.class.getName(), httpSession);
        } else {
            // 处理httpSession为null的情况，例如记录日志或采取其他措施
            // 这里只是一个简单的日志记录
            System.out.println("HttpSession is null for this WebSocket connection.");
        }
    }
}