<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ServletContext context = this.getServletContext();

	Enumeration<String> paramnames = context.getInitParameterNames();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>ContextApiTestServlet Test</h1><hr>
	<div style = 'font-size:1,2rem;'>
		1. Context 초기화 파리미터 목록 : <br>
		<% while(paramnames.hasMoreElements()) { 
			String name = paramnames.nextElement();
		%>
			&nbsp;&nbsp;&nbsp;&nbsp;<%=name %> : <%= context.getInitParameter(name) %> <br>
		<%} %>
		2. 웹 어플리케이션 실행 환경 : <br> 
		&nbsp;&nbsp;&nbsp;&nbsp;컨텍스트 경로 : <%= context.getContextPath()%> <br>
		&nbsp;&nbsp;&nbsp;&nbsp;testhome.html 배포 경로 : <%= context.getRealPath("testhome.html")%> <br>
		3. WAS 서버 환경 : <br>
		&nbsp;&nbsp;&nbsp;&nbsp;서버 정보 = <%= context.getServerInfo() %> <br>
		&nbsp;&nbsp;&nbsp;&nbsp;서블릿 지원 버전 = <%= context.getMajorVersion() %>.<%=context.getMinorVersion() %>
	</div>	
	<p><button onclick='window.history.back()'>돌아가기</button></p>
</body>
</html>