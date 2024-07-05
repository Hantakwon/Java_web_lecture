<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.wplab.listenertest.DataObject" %>
<% 
	DataObject DO = (DataObject) request.getAttribute("DO");
	int firstNum = DO.getFirstNum();
	int secondNum = DO.getSecondNum();
	long sum = DO.getSum();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구간 합 구하기</title>
</head>
<body>
	<h1>구간 합 구하기</h1>
	<p>첫번째 수 : <%= firstNum %>, 두번째 수 : <%= secondNum %>, 합계 = <%= sum %></p>
</body>
</html>