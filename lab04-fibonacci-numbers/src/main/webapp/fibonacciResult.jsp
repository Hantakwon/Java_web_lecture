<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.wplab.fibonacci.FibonacciInfo"%>
<%
request.setCharacterEncoding("UTF-8"); // 한글 처리

FibonacciInfo fibonacciinfo = (FibonacciInfo) session.getAttribute("fibonacciinfo");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>피보나치 수열 생성 결과<h1>
	<br>
	<p>
		피보나치 수열 원소 개수 : <%=fibonacciinfo.getCount()%>
	</p>
 	<%
    for (int i = 0; i < fibonacciinfo.getCount(); i++) {
    %>
        <p><%=i%> : <%=fibonacciinfo.getFa()[i]%></p>
    <%
    }
    %>
	<div>
		<button onclick="window.history.back()">이전 화면</button>
	</div>		
</body>
</html>