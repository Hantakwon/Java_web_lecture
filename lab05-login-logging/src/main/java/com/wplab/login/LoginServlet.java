package com.wplab.login;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet( name="LoginServlet",
			urlPatterns = {"/login.do"}, 
			initParams = {
					@WebInitParam(name="log_file_prefix",
								  value="/Program Files/Log/login-log"),
					@WebInitParam(name="log_file_suffix",
								  value = ".log")
}/*,loadOnStartup = 0 (0을 넣으면 사용자 요청시에 동작되도록 하는 옵션임...ㅎ-ㅎ)*/)
									

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private PrintWriter logFile = null; // 파일 생성 (로그 파일은 서블릿 시작할 때 오픈. 서블릿이 종료될 때 클로즈)

	public LoginServlet() {
		super();
	}

	// 종료될 때 destroy()가 실행되면서 로그 파일이 닫아지게
	@Override
	public void destroy() {
		if (logFile != null) {
			logFile.close();
		}
		super.destroy();
	}

	 // init() 메소드가 실행될 때 로그 파일이 생성되도록.
	   @Override // 여기서 파일 생성
	   public void init() throws ServletException {
	      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	      // String logFileName = "/D:\\log/login-log" + sdf.format(new Date()) + ".log"; 
	      
	      ServletConfig config = getServletConfig();
	      String logFilePrefix = config.getInitParameter("log_file_prefix");
	      String logFileSuffix = config.getInitParameter("log_file_suffix");
	      // String logFilename = logFilePrefix + sdf.format(new Date()) + logFileSuffix;
	      
	      String logFileName = (new StringBuilder()).append(logFilePrefix).append(sdf.format(new Date())).append(logFileSuffix).toString();
	      try {
	         logFile = new PrintWriter(new FileWriter(logFileName, true));
	      }

	      catch (Exception e) {
	         e.printStackTrace();
	      }
	      super.init();
	   }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
		// step #1. get request parameters
		request.setCharacterEncoding("UTF-8");

		String userid = request.getParameter("userid");
		String passwd = request.getParameter("passwd");

		// step #2. data processing
		// do member authentication

		String greeting = null;
		if (userid.equals("gdhong") && passwd.equals("1234")) {
			greeting = String.format("반갑습니다.%s 님!", userid);

			if (logFile != null) {
				// log format: yyyy-mm-dd: hh:mm:ss-userid - 로그인 파일이 열려 있을 때 로그 출력
				logFile.printf("%s - %s\n", (new SimpleDateFormat("yyyy-MM-dd: HH:mm:ss")).format(new Date()), userid);
			}
		}

		else {
			greeting = "사용자 또는 패스워드가 맞지 않습니다...";
		}
		// step #3. output results
		response.setContentType("text/html; charset=UTF-8");

		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<head>");
		out.println("<title> 로그인 결과 </title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>로그인 결과<h1><br>");
		out.println("<div style='font-size:1,2rem;'>");
		out.println(greeting + "<br><br>");
		out.println("서비스 준비 중입니다!...<br><br></divs>");
		out.println("<br><p><button onclick='window.history.back()'>돌아가기</button></p>");
		out.println("</body>");
		out.println("</html>");

		out.close();
	}
}