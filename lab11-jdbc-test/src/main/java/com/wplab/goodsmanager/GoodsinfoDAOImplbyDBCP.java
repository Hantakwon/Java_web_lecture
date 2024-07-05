package com.wplab.goodsmanager;

import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class GoodsinfoDAOImplbyDBCP extends GoodsinfoDAOImpl{

	private String dbcpResourceName;
	private DataSource ds;
	
	public GoodsinfoDAOImplbyDBCP() {
		// TODO Auto-generated constructor stub
	}
	
	public GoodsinfoDAOImplbyDBCP(String dbcpResourceName) {
		super();
		setDbcpResourceName(dbcpResourceName);
	}
	
	public void setDbcpResourceName(String dbcpResourceName) {
		this.dbcpResourceName = dbcpResourceName;
		
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:com/env");
			ds = (DataSource) envContext.lookup(dbcpResourceName);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	protected void connectDB() throws SQLException {
		if(ds != null) {
			this.conn = ds.getConnection();
		}
	}
	
}
