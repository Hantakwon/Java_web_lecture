<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://com.wplab.taglib.mymathlib" prefix="my" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL Test</title>
</head>
<body>
	<h1>EL Test</h1><hr>
	<p>1에서 100까지의 구간 합 = ${result}</p>	
	<p>${psInfo.name}님의 나이는 ${psInfo["age"]}입니다.</p>
	<p>${psInfo.name}님의 나이는 ${my:comparechar(psInfo["gender"], 'M') ? "남성" : "여성"}입니다.</p>
	<p>${num1} + ${num2} = ${num1 + num2}</p>
	<p>${num1} / ${num2} = ${num1 / num2}</p>
	<p>${num1}과 ${num2} 중 큰 값 : ${num1 - num2 >= 0 ? num1 : num2}</p>
	
	<p>100의 제곱근 : ${my:squareroot(100)}</p>
	<p>1에서 100까지의 구간 합 =  ${my:intervalsum(1,100)}</p>
</body>
</html>