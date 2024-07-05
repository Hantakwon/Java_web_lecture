<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error_page.jsp" %>
<%@ page import="java.sql.*, com.wplab.goodsmanager.*" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 정보 검색</title>
</head>
<body>
<%
	DBConnectionInfo dbInfo =
		(DBConnectionInfo)application.getAttribute("jdbc_info");
	
	Class.forName(dbInfo.getJdbcDriverName());
	
	Connection conn = DriverManager.getConnection(dbInfo.getUrl(), dbInfo.getUsername(), dbInfo.getPassword());
	
	if(conn != null) {
		String sql = "select * from GOODSINFO order by CODE asc";
		Statement stmt = conn.createStatement();
		
		ResultSet rs = stmt.executeQuery(sql);
		
		if (rs.isBeforeFirst()){
			while (rs.next()) {
				%>
				<p>code = <%= rs.getString("CODE") %></p>
				<%
			}
		}
		
		if(rs != null) rs.close();
		if(stmt != null) stmt.close();
		if(conn != null) conn.close();
	}
%>
</body>
</html>
