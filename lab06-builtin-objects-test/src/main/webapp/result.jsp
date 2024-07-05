<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.wplab.builtinobjects.RequestInfo" %>
<%
	RequestInfo requestinfo = (RequestInfo) session.getAttribute("requestinfo");

	Enumeration paramNames = requestinfo.getNames();
	Enumeration headerNames = requestinfo.getHeaders();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>HttpServletRequest API Test</h1><br>
	<div style='font-size:1,2rem;'>
		1. 요청 URL : <%=requestinfo.getUrl()%> <br>
		2. 요청 Method : <%=requestinfo.getMethod() %> <br>
		3. 요청 쿼리 스트링 : <%=requestinfo.getQueryString() %> <br>
		4. 요청 파라미터 목록 : <br>
		<% while(paramNames.hasMoreElements()) {
			String names = (String)paramNames.nextElement(); %>
			요청이름 : <%=names %> <br>		
		<% } %>
		5. 요청 헤더 목록 : <br>
		<% while(headerNames.hasMoreElements()) {
			String names = (String)headerNames.nextElement(); %>
			헤더 : <%=names %> <br>		
		<% } %>
		6. 요청 클라이언트 정보 : <br>
		host : <%=requestinfo.getHost() %> <br>
		port : <%=requestinfo.getPort() %> <br>
	</div>
	<div>
		<button onclick="window.history.back()">이전 화면</button>
	</div>	
</body>
</html>