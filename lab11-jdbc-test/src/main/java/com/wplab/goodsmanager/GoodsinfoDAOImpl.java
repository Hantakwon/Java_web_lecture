package com.wplab.goodsmanager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class GoodsinfoDAOImpl implements GoodsinfoDAO {
	
	private DBConnectionInfo dbInfo = null;
	protected Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	private final String INSERT_GOODS = 
		"insert into goodsinfo(code, title, writer, price) values(?, ?, ?, ?)";
	private final String UPDATE_GOODS = 
			"update goodsinfo set title=?, writer=?, price=? where code=?";
	private final String DELETE_GOODS = "delete from goodsinfo where code=?";
	private final String GET_GOODS = "select * from goodsinfo where code=?";
	private final String LIST_GOODS = "select * from goodsinfo order by code asc";
	
	public GoodsinfoDAOImpl() {
	}
	
	public GoodsinfoDAOImpl(DBConnectionInfo dbInfo) {
		this.dbInfo = dbInfo;
	}
	
	public void setDbInfo(DBConnectionInfo dbInfo) {
		this.dbInfo = dbInfo;
	}
	
	protected void connectDB() throws SQLException {
		try {
			Class.forName(dbInfo.getJdbcDriverName());
			conn = DriverManager.getConnection(
					dbInfo.getUrl(), dbInfo.getUsername(), dbInfo.getPassword());
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	
	protected void disconnectDB() {
		try {
			if (rs != null) {
				rs.close();
				rs = null;
			}
			if (stmt != null) {
				stmt.close();
				stmt = null;
			}
			if (conn != null) {
				conn.close();
				conn = null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public int insertGoods(GoodsDO goods) {
		int result = 0;
			
		connectDB();
		
		try {
			stmt = conn.prepareStatement(INSERT_GOODS);
			stmt.setString(1, goods.getCode());
			stmt.setString(2, goods.getTitle());
			stmt.setString(3, goods.getWriter());
			stmt.setInt(4, goods.getPrice());
			
			result = stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnectDB();
		}
		
		return result;
	}

	@Override
	public int updateGoods(GoodsDO goods) {
		int result = 0;
		
		connectDB();
		
		try {
			stmt = conn.prepareStatement(UPDATE_GOODS);
			stmt.setString(1, goods.getTitle());
			stmt.setString(2, goods.getWriter());
			stmt.setInt(3, goods.getPrice());
			stmt.setString(4, goods.getCode());
			
			result = stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnectDB();
		}
		
		return result;
	}

	@Override
	public int deleteGoods(GoodsDO goods) {
		int result = 0;
		
		connectDB();
		
		try {
			stmt = conn.prepareStatement(DELETE_GOODS);
			stmt.setString(1, goods.getCode());
			
			result = stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
		}

		return result;
	}

	@Override
	public GoodsDO getGoods(GoodsDO goods) {
		GoodsDO result = null;
		
		connectDB();
		
		try {
			stmt = conn.prepareStatement(GET_GOODS);
			
			stmt.setString(1, goods.getCode());
			
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				result = new GoodsDO();
				result.setCode(rs.getString("CODE"));
				result.setTitle(rs.getString("TITLE"));
				result.setPrice(rs.getInt("PRICE"));
				result.setWriter(rs.getString("WRITER"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnectDB();
		}

		return result;
	}

	@Override
	public List<GoodsDO> listGoods() {
		List<GoodsDO> list = null;
		
		connectDB();
		
		try {
			stmt = conn.prepareStatement(LIST_GOODS);
			
			rs = stmt.executeQuery();
			
			if(rs.isBeforeFirst()) { // 데이터가 있다면
				list = new ArrayList<>();
				while(rs.next()) {
					GoodsDO goods = new GoodsDO();
					
					goods.setCode(rs.getString("CODE"));
					goods.setTitle(rs.getString("TITLE"));
					goods.setPrice(rs.getInt("PRICE"));
					goods.setWriter(rs.getString("WRITER"));
					
					list.add(goods);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnectDB();
		}
		
		return list;
	}

}
