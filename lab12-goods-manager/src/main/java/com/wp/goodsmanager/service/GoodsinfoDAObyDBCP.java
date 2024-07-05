package com.wp.goodsmanager.service;

import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class GoodsinfoDAObyDBCP extends GoodsinfoDAOImpl {

	private String dbcpResourceName = null;
	
	public GoodsinfoDAObyDBCP(String resourceName) {
		this.dbcpResourceName = resourceName;
	}
	
	protected void connectDB() {
		Context initContext;
		try {
			initContext = new InitialContext();
			Context envContext = (Context)initContext.lookup("java:comp/env");
			DataSource ds = (DataSource) envContext.lookup(dbcpResourceName);
			this.conn = ds.getConnection();
		} catch (NamingException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
