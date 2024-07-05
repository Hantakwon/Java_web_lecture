<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import = "com.wplab.memberjoin.MemberInfo" %>
<%
	request.setCharacterEncoding("UTF-8"); // 한글 처리
	
	MemberInfo memberinfo = (MemberInfo) session.getAttribute("memberinfo");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원 가입 정보 입력</h1>
	<hr>
	<div>
		<p>
			<label for="name">이름 : <%= memberinfo.getName() %></label>
		</p>
		<p>
			<label for="id">아이디 : <%= memberinfo.getId() %></label>
		</p>
		<p>
			<label for="passwd">비밀번호 : <%= memberinfo.getPasswd() %></label>
		</p>
		<p>
			<label for="gender">성별 : <%= memberinfo.getGender() %></label>
		</p>
		<p>
			<label>메일 수신 여부 : </label> 
			공지메일 <%= memberinfo.getInotice() %>
			광고메일 <%= memberinfo.getCnotice() %>
			배송메일 <%= memberinfo.getDnotice() %>
		</p>
		<p>
			<label for="job">직업 : <%= memberinfo.getJob() %></label>
		</p>
		<div><button onclick="window.location.href='MemberJoin.html'">이전 화면</button></div>
	</div>
</body>
<body>

</body>
</html>