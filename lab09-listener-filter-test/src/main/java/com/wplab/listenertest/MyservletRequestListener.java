package com.wplab.listenertest;

import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;


public class MyservletRequestListener implements HttpSessionListener {

    public MyservletRequestListener() {
        // TODO Auto-generated constructor stub
    }

    public void sessionCreated(HttpSessionEvent se)  { 
         System.out.println(">>> start to process new request...");
    }

    public void sessionDestroyed(HttpSessionEvent se)  { 
    	System.out.println(">>> request processing is ended...");
    }
	
}
