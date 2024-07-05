<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error_page.jsp" %>
<%@ page import="java.sql.*, java.util.*,com.wplab.goodsmanager.*" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 정보 목록 검색</title>
</head>
<body>
	<h2>상품 정보 목록을 검색합니다...</h2>
<%
	String jdbcDriverName = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@DESKTOP-5C88SJ3:1521:xe";
	String username = "WEBP";
	String password = "1234";
	
	Connection conn = null;
	Statement stmt = null;
	
	Class.forName(jdbcDriverName);
	conn = DriverManager.getConnection(url, username, password);
	
	if (conn != null) {
		stmt = conn.createStatement();

		String sql = "select * from goodsinfo";
		ResultSet rs = stmt.executeQuery(sql);

		if (rs.isBeforeFirst()) {
			while (rs.next()) {
%>		
			<h2>코드: <%= rs.getString("CODE") %>,  제목: <%= rs.getString("TITLE") %>,  저자: <%= rs.getString("WRITER") %></h2>
<%		
			}
		}
		else {
%>
			<h2>검색된 상품 정보가 없습니다.</h2>
<%		
		}
	
		rs.close();
		stmt.close();
		conn.close();
	}
	else {
%>
		<h2>DB 연결에 실패하였습니다.</h2>				
<%		
	}
%>
</body>
</html>
