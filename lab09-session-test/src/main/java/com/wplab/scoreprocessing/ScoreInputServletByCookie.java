package com.wplab.scoreprocessing;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/*@WebServlet(name = "ScoreInputServletByCookie",
			value = {"/score_input.do"}) */
public class ScoreInputServletByCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ScoreInputServletByCookie() {
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
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int count = 0;
		
		Cookie[] cookies = request.getCookies();
		Cookie countCookie = findCookie(cookies, "count");
		if (countCookie != null) {
			count = Integer.parseInt(countCookie.getValue());
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
	
		Cookie[] cookies = request.getCookies();
		Cookie scores = findCookie(cookies, "scores");
		if (scores == null) {
			scores = new Cookie("scores", "");
		}
		
		Cookie count = findCookie(cookies, "count");
		if (count == null) {
			count = new Cookie("count","0");
		}
		
		// step #2. data processing
		if(action.equals("입력")) {
			String scoresStr = scores.getValue();
			scoresStr = scoresStr + (scoresStr.isBlank() ? "" : "+") + score;
			scores.setValue(scoresStr);
			int countValue = Integer.parseInt(count.getValue());
			countValue++;
			count.setValue(String.valueOf(countValue));
			
			response.addCookie(count);
			response.addCookie(scores);
			
			response.sendRedirect(request.getHeader("Referer"));
		}
		else if(action.equals("출력")) {
			// check if input scores exist in cookie
			if (count == null || count.getValue().equals("0")) {
				response.sendRedirect(request.getHeader("Referer"));			
			}
			else {
				ScoreDO scoreDO = new ScoreDO();
				String[] scoresArray = scores.getValue().split("\\+");
				int[] scoresValue = new int[scoresArray.length];
				
				for(int i=0; i<scoresArray.length; i++) {
					scoresValue[i] = Integer.parseInt(scoresArray[i]);
				}
				
				scoreDO.setScores(scoresValue);
				ScoreProcessingService scoreProcessingService = new ScoreProcessingService();
				scoreProcessingService.processScores(scoreDO);

				request.setAttribute("score_do", scoreDO);

				scores.setMaxAge(0);
				count.setMaxAge(0);
				response.addCookie(scores);
				response.addCookie(count);
				
				RequestDispatcher view = request.getRequestDispatcher("output_score.do");
				view.forward(request, response);
			}
		}
		
		// step #3. output results
	}

}
