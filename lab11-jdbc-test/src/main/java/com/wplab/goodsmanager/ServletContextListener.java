package com.wplab.goodsmanager;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;

/**
 * Application Lifecycle Listener implementation class ServletContextListener
 *
 */
public class ServletContextListener implements jakarta.servlet.ServletContextListener {

    /**
     * Default constructor. 
     */
    public ServletContextListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
		// ServletContextListener.super.contextInitialized(sce);
		
		ServletContext context = sce.getServletContext();
		
		DBConnectionInfo connInfo = new DBConnectionInfo();
		connInfo.setJdbcDriverName(context.getInitParameter("jdbc_driver_name"));
		connInfo.setUrl(context.getInitParameter("db_url"));
		connInfo.setUsername(context.getInitParameter("db_username"));
		connInfo.setPassword(context.getInitParameter("db_password"));
		
		context.setAttribute("db_info", connInfo);
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }
	
}
