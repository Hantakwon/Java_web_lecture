package com.wplab.listenertest;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class MyServletContextListener implements ServletContextListener {

    public MyServletContextListener() {
        // TODO Auto-generated constructor stub
    }

    public void contextInitialized(ServletContextEvent sce)  { // 생성될 때
         System.out.println(">>> ServletContext object initialized...");
         
         DBConnectionInfo connInfo = new DBConnectionInfo();
         
         ServletContext context = sce.getServletContext();
         
         connInfo.setDriverClassName(context.getInitParameter("jdbc.drvierClassName"));
         connInfo.setUrl(context.getInitParameter("jdbc.url"));
         connInfo.setUsername(context.getInitParameter("jdbc.username"));
         connInfo.setPassword(context.getInitParameter("jdbc.password"));
         
         context.setAttribute("jdbc_info", connInfo);
    }

    public void contextDestroyed(ServletContextEvent sce)  { // 제거될 때
    	System.out.println(">>> ServletContext object Destroyed...");
    }
	
}
