package com.wplab.scoreprocessing;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "ScoreInputServletByCookie",
			value = {"/score_input.do"})
public class ScoreInputServletBySession extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ScoreInputServletBySession() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int count = 0;

		List<Integer> scores;
		
		HttpSession session = request.getSession();
		if (session.isNew()) {
			scores = new ArrayList<Integer>();
			session.setAttribute("scores", scores);
		}
		else {
			scores = (List<Integer>) session.getAttribute("scores");
			count = scores.size();
		}
		
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
		// step #1. request parameters
		request.setCharacterEncoding("UTF-8");
		
		String score = request.getParameter("score");
		
		String action = request.getParameter("action");
	
		HttpSession session = request.getSession(false); // session이 없으면 만들지 말고 null 값 반환
		if (session == null) {
			response.sendRedirect(request.getHeader("Referer"));
			return;
		}
		
		List<Integer> scores = (List<Integer>) session.getAttribute("scores");
		
		
		// step #2. data processing
		if(action.equals("입력")) {
			scores.add(Integer.parseInt(score));
			
			response.sendRedirect(request.getHeader("Referer"));
		}
		else if(action.equals("출력")) {
			// check if input scores exist in cookie
			if (scores.size() == 0) {
				response.sendRedirect(request.getHeader("Referer"));
			}
			else {
				ScoreDO scoreDO = new ScoreDO();
				int[] scoreArray = scores.stream().mapToInt(Integer::intValue).toArray();
				
				scoreDO.setScores(scoreArray);
				ScoreProcessingService scoreProcessingService = new ScoreProcessingService();
				scoreProcessingService.processScores(scoreDO);

				request.setAttribute("score_do", scoreDO);
				
				session.invalidate();
				
				RequestDispatcher view = request.getRequestDispatcher("scoreOutput.jsp");
				view.forward(request, response);
			}
		}
		
		// step #3. output results
	}

}
