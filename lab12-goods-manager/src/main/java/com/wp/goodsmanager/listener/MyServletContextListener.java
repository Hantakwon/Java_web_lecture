package com.wp.goodsmanager.listener;

import com.wp.goodsmanager.service.DBConnectionInfo;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener()
public class MyServletContextListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		ServletContextListener.super.contextInitialized(sce);
		
		ServletContext context = sce.getServletContext();
		
		DBConnectionInfo connInfo = new DBConnectionInfo();
		connInfo.setJdbcDriverName(context.getInitParameter("jdbc_driver_name"));
		connInfo.setUrl(context.getInitParameter("db_url"));
		connInfo.setUsername(context.getInitParameter("db_username"));
		connInfo.setPassword(context.getInitParameter("db_password"));
		
		context.setAttribute("db_info", connInfo);
	}

}
