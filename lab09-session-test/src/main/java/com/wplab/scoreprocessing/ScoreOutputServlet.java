package com.wplab.scoreprocessing;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "ScoreOutputServlet",
			value = {"/output_score.do"})
public class ScoreOutputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ScoreOutputServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// step #1. get request parameters
		
		// step #2. data processing
		ScoreDO scoreDO = (ScoreDO)request.getAttribute("score_do");
		
		// step #3. output results
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>성적 처리 결과</title>");
		out.println("<style>");
		out.println("body { padding-left: 100px; }");
		out.println(".td { padding-left: 5px; }");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<header>");
		out.println("<h2>성적 처리 결과</h2><hr><br>");
		out.println("</header>");
		out.println("<article>");
		out.println("<table>");
		out.println("<tr><td class='td'>성 적</td></tr>");
		int[] scores = scoreDO.getScores();
		for(int i=0; i<scores.length; i++) {
			out.printf("<tr><td class='td'>%d :</td><td class='td'>%s</td></tr>\n", i+1, scores[i]);
		}
		out.println("<tr><td>&nbsp;</td></tr>");
		out.printf("<tr><td class='td'>총 합 :</td><td class='td'>%d</td></tr>\n", scoreDO.getTotal());
		out.printf("<tr><td class='td'>평 균 :</td><td class='td'>%.2f</td></tr>\n", scoreDO.getAverage());
		out.printf("<tr><td class='td'>표준편차 :</td><td class='td'>%f</td></tr>\n", scoreDO.getStddev());
		out.println("<tr><td>&nbsp;</td></tr>");
		out.printf("<tr align='center'><td colspan='2'><a href='%s'>첫 페이지로 가기</a></td></tr>",
				request.getContextPath() + "/score_input.do");
		out.println("</table>");
		out.println("</form>");
		out.println("</article>");
		out.println("</body>");
		out.println("</html>");		
	}

}

