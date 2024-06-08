package com.example.kxchat.config;

import org.springframework.stereotype.Component;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

@WebListener
public class RequestListener implements ServletRequestListener {

    public void requestInitialized(ServletRequestEvent sre)  {
        //将所有request请求都携带上httpSession
        ((javax.servlet.http.HttpServletRequest) sre.getServletRequest()).getSession();

    }
    public RequestListener() {
        // TODO Auto-generated constructor stub
    }

    public void requestDestroyed(ServletRequestEvent arg0)  {
        // TODO Auto-generated method stub
    }
}