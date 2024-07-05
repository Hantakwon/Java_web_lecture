<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String[] menuList = { "비빔밥", "설렁탕", "자장면" };
	request.setAttribute("menuList", menuList);
	int[] menuPrice = {100,200,300};
	request.setAttribute("menuPrice", menuPrice);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL Tags Test</title>
</head>
<body>
	<h1>JSTL Tags Test</h1><hr>
	<c:set var="num1" value="100" />
	<c:set var="num2" value="155" />
	
	<p>${num1}+${num2} = ${num1 + num2}</p> 
	
	<p><c:out value ="'<b></b>'태그는 글씨체를 두껍게 출력합니다." /></p>
	
	<p>${num1}과 ${num2}중에 큰 값은 : 
		<c:if test="${num1- num2 > 0}">${num1}입니다.</c:if>
		<c:if test="${num1- num2 < 0}">${num2}입니다.</c:if>
		<c:if test="${num1- num2 == 0}">값이 같습니다.</c:if>
	</p> 
	
	<p>${num1}과 ${num2}중에 큰 값은 : 
		<c:choose>
			<c:when test="${num1- num2 > 0}">${num1}입니다.</c:when>
			<c:when test="${num1- num2 < 0}">${num2}입니다.</c:when>
			<c:otherwise>값이 같습니다.</c:otherwise>
		</c:choose>
	</p>
	
	<h3>메아리</h3>
	<c:forEach var="size" begin="1" end="6" step="2">
		<font size="${size}">야호<br></font>
	</c:forEach>
	
	<h3>오늘의 점심 메뉴</h3>
	<ul>
		<c:forEach var="menu" items="${menuList}" varStatus="status">
  			<li>${status.count}. ${menu} : ${menuPrice[status.index]}만 원</li>
		</c:forEach>
	</ul>
</body>
</html>