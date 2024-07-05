package com.wplab.helloworld;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/helloworld")
public class HelloWorldServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public HelloWorldServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// step #1. get request parameter 입력 가져오기
		
		// step #2. data processing 데이터 처리
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 hh:mm:ss");
		String dateStr = sdf.format(new Date());
		
		// step #3. output results 결과 출력
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Hello World Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Hello Servlet</h1>");
		out.println("<h3>처음 만들어 본 서블릿 프로그램</h3>");
		out.println("<p>현재 시간 : " + dateStr + "</p>");
		out.println("</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}