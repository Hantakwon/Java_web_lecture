package com.wplab.scoreprocessing;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "ScoreProcessingServlet",
			value = {"/score_process.do"})
public class ScoreProcessingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ScoreProcessingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// step #1. get request parameters
		request.setCharacterEncoding("UTF-8");
		
		String[] scores = request.getParameterValues("score");
		int[] scoreValues = new int[scores.length];
		
		for(int i=0; i<scores.length; i++) {
			scoreValues[i] = Integer.parseInt(scores[i]);
		}
		
		ScoreDO scoreDO = new ScoreDO();
		scoreDO.setScores(scoreValues);
		
		// step #2. data processing
		ScoreProcessingService scoreProcessingService = new ScoreProcessingService();
		
		scoreProcessingService.processScores(scoreDO);
		
		// step #3. output processing results
		request.setAttribute("score_do", scoreDO);
		
		RequestDispatcher view = request.getRequestDispatcher("output_score.do");
		view.forward(request, response);
	}

}
