<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error_page.jsp" %>
<%@ page import="java.sql.*, java.util.*,com.wplab.goodsmanager.*" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 정보 목록 검색</title>
</head>
<body>
<%
	/* DBConnectionInfo dbInfo =
		(DBConnectionInfo)application.getAttribute("db_info");

	GoodsinfoDAO dao = new GoodsinfoDAOImpl(dbInfo); */
	
	String dbcpResourceName = application.getInitParameter("dbcp_resource_name");
	GoodsinfoDAO dao = new GoodsinfoDAOImplbyDBCP();

	List<GoodsDO> list = dao.listGoods();

	if(list != null){
		for(GoodsDO goods : list) {
%>
			<p>Code=<%= goods.getCode() %>, Title=<%= goods.getTitle() %>, Writer=<%= goods.getWriter() %>, Price=<%= goods.getPrice() %> </p> 
<%
		}
	}
%>
</body>
</html>