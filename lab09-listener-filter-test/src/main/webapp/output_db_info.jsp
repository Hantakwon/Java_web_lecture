<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.wplab.listenertest.DBConnectionInfo" %>
<%  
	System.out.println(">>> execute output_db_info JSP...");

	DBConnectionInfo connInfo = (DBConnectionInfo) application.getAttribute("jdbc_info"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JDBC 데이터베이스 연결 정보</title>
</head>
<body>
	<h1>JDBC 데이터베이스 연결 정보</h1>
	<p>1. JDBC 드라이버 클래스 이름 : <%=connInfo.getDriverClassName() %> </p>
	<p>2. JDBC 접속 URL : <%=connInfo.getUrl() %></p>
	<p>3. JDBC Username : <%=connInfo.getUsername() %></p>
	<p>4. JDBC Passwrod : <%=connInfo.getPassword() %></p>
</body>
</html>	