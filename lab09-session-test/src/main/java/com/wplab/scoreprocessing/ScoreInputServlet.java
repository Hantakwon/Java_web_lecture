package com.wplab.scoreprocessing;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet(name = "ScoreInputServlet",
			value = {"/ScoreInputServlet"})
public class ScoreInputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ScoreInputServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int count = 0;

		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("<title>성적 입력</title>");
		out.println("<style>");
		out.println(".td { padding-left: 5px; }");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
			out.println("<header>");
				out.println("<h2>성적 입력</h2><hr><br>");
			out.println("</header>");
			out.println("<article>");
				out.println("<form action='score_input.do' method='POST'>");
				out.println("<table>");
					out.println("<tr><td class='td'>성적 :</td><td class='td'><input type='number' name='score' /></td></tr>");
					out.printf("<tr align='center'><td colspan='2'>현재 성적 입력 학생 : %d 명</td></tr>", count);
					out.println("<tr align='center'><td colspan='2'>" + "<input type='submit' name='action' value='입력' />&nbsp;&nbsp;");
					out.println("<input type='submit' name='action' value='출력' /></td></tr>");
				out.println("</table>");
				out.println("</form>");
			out.println("</article>");
		out.println("</body>");
		out.println("</html>");	
		
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
