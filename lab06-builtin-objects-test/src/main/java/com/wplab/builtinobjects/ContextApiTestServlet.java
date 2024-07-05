package com.wplab.builtinobjects;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet (name = "ContextApiTestServlet",
			urlPatterns = {"/context_test.do"} 
)
public class ContextApiTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ContextApiTestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		/*
		ServletConfig config = getServletConfig();
		ServletContext context = config.getServletContext();
		*/
		
		ServletContext context = this.getServletContext();
		
		response.setContentType("text/html; charset=UTF-8");

		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<head>");
		out.println("<title> ServletContext API Test </title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>ServletContext API Test</h1><hr>");
		out.println("<div style='font-size:1,2rem;'>");
		out.println("1. Context 초기화 파라미터 목록 : <br>");
		Enumeration<String> initParamnames = context.getInitParameterNames();
		while(initParamnames.hasMoreElements()) {
			String name = initParamnames.nextElement();
			out.printf("&nbsp;&nbsp;&nbsp;&nbsp;%s = %s<br>", name, context.getInitParameter(name));
		}
		out.println("2. 웹 어플리케이션 실행 환경 : <br>");
		out.println("&nbsp;&nbsp;컨텍스트 경로 : " + context.getContextPath() + "<br>");
		out.println("&nbsp;&nbsp;'test-home.html' 배포 경로 : " + context.getRealPath("testhome.html") + "<br>");
		//out.println("&nbsp;&nbsp;'test-home.html' 배포 경로 : " + context.getResourceAsStream("testhome.html") + "<br>");
		out.println("3. WAS 서버 환경 : <br>");
		out.println("&nbsp;&nbsp;서버 정보 = " + context.getServerInfo() + "<br>");
		out.println("&nbsp;&nbsp;서블릿 지원 버전 = " + context.getMajorVersion() + "." + context.getMinorVersion() + "<br>");
		out.println("</div>");
		out.println("<br><p><button onclick='window.history.back()'>돌아가기</button></p>");
		out.println("</body>");
		out.println("</html>");

		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
