package com.example.kxchat.ws;


import com.example.kxchat.utils.MessageUtils;

import jakarta.websocket.*;
import jakarta.websocket.server.PathParam;
import jakarta.websocket.server.ServerEndpoint;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;


@ServerEndpoint(value = "/chat/{name}/{touxiang}")
@Component
public class ChatEndPoint {

    private static final Map<String, Session> onlineUsers=new ConcurrentHashMap<>();
    @OnOpen
    public void onOpen(@PathParam("name") String name,@PathParam("touxiang") int touxiang, Session session) {
        session.getUserProperties().put("name", name);
        session.getUserProperties().put("touxiang", touxiang);
        onlineUsers.put(name, session);
        int count = onlineUsers.size();
        System.out.println("用户 " + name + " 已上线，当前在线用户数量: " + count+" 头像是"+touxiang);
    }



    //发送给所有用户
    private void broadcastAllUsers(String message)  {
        try {
            //遍历map集合
            Set<Map.Entry<String, Session>> entries = onlineUsers.entrySet();
            for (Map.Entry<String, Session> entry : entries) {
                Session session = entry.getValue();

                session.getBasicRemote().sendText(message);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }


    @OnMessage
    public void onMessage(String content,Session session) {

        // 从Session中获取参数
        String name = (String) session.getUserProperties().get("name");
        int touxiang = (int) session.getUserProperties().get("touxiang");
        String newMessage = MessageUtils.getMessage(name, content, touxiang);
        broadcastAllUsers(newMessage);

    }

    @OnClose
    public void onClose(Session session) {
        String name = (String) session.getUserProperties().get("name");
        if (name != null && !name.isEmpty()) {
            onlineUsers.remove(name);
            int count = onlineUsers.size();
            System.out.println("用户 " + name + " 已下线，当前在线用户数量: " + count);
        }
    }
}
