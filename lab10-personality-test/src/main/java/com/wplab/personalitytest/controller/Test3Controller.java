package com.wplab.personalitytest.controller;

import java.io.IOException;
import java.util.HashMap;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "Test3Controller", value = {"/test3"})
public class Test3Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Test3Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession(false);

		if (session == null) {
			response.sendRedirect(request.getContextPath() + "/start.html");
			return;
		}
		
		String username = (String)session.getAttribute("username");
		HashMap<String, Integer> replyStore = (HashMap<String, Integer>) session.getAttribute("reply_store");
		
		replyStore.put("question3", Integer.parseInt((String)request.getAttribute("question3")));
		replyStore.put("question4", Integer.parseInt((String)request.getAttribute("question4")));
		
		session.setAttribute("reply_store", replyStore);
		
		RequestDispatcher view = request.getRequestDispatcher("/test3.jsp");
		view.forward(request, response);
	}
}