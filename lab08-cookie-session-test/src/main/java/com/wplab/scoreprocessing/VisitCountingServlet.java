package com.wplab.scoreprocessing;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "VisitCountingServlet", value = { "/visit.do" })
public class VisitCountingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public VisitCountingServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	private Cookie findCookie(Cookie[] cookies, String cookieName) {
		Cookie result = null;
		
		if(cookies != null && cookies.length > 0) {
			for (Cookie cookie : cookies){
				if (cookie.getName().equals(cookieName)) {
					result = cookie;
					break;
				}
			}
		}
		return result;
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Cookie[] cookies = request.getCookies();
		
		Cookie visitCountCookie = findCookie(cookies,"visit_count");
		if(visitCountCookie == null) {
			visitCountCookie = new Cookie("visit_count", "1");
		}
		else {
			int visitCount = Integer.parseInt(visitCountCookie.getValue());
			++visitCount;
			visitCountCookie.setValue(String.valueOf(visitCount));	
		}
		
		if(Integer.parseInt(visitCountCookie.getValue()) > 5) {			
			visitCountCookie.setMaxAge(0);
		}
		
		else {
			visitCountCookie.setMaxAge(86400);
		}
		
		response.addCookie(visitCountCookie);
		
		// step #1. get request parameter

		// step #2. data processing

		// step #3. output result
		response.setContentType("text/html;charset=UTF-8");

		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<head>");
		out.println("<title>쿠키 데이터 테스트</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>쿠키 데이터 테스트</h1><hr>");
		out.printf("<p>당신의 방문 횟수는 %d 입니다!<p>", Integer.parseInt(visitCountCookie.getValue()));
		out.println("</body>");
		out.println("</html>");

		out.close();
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
