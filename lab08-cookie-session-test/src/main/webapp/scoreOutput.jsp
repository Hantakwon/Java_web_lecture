<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.wplab.scoreprocessing.ScoreDO" %>
<%
	request.setCharacterEncoding("UTF-8"); // 한글 처리

	ScoreDO scoreDO = (ScoreDO) request.getAttribute("score_do");
	int[] scores = scoreDO.getScores();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>성적 처리 결과</title>
</head>
<body style='font-size : 1.2rem;'>
	 <h1>성적 처리 결과</h1><hr>
	 <div style='font-size: 1.2rem;'>
	 1. 입력 성적</br>
	 <% for (int i=0; i<scores.length; i++) { %>
	 	#<%=i+1 %> : <%=scores[i] %> <br>
	 <%} %>
	 <br>
	 <p>2. 총합 : <%=scoreDO.getTotal() %></p>
	 <p>3. 평균 : <%=scoreDO.getAverage() %></p>
	 <p>4. 표준편차 : <%=scoreDO.getStddev() %></p>
	 <p><button onlick='window.history.back();'>돌아가기</button>
	 </div>
</body>
</html>