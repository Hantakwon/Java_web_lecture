<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Calculation Result</h1>
	<hr>
	<p>${calculationData.num1} ${calculationData.opStr} ${calculationData.num2} = ${calculationData.result}</p>
	<!--<div><button onclick="window.history.back()">계산기 화면</button></div>-->
	<div><button onclick="window.location.href='Calculator.html'">계산기 화면</button></div>
	
</body>
</html>