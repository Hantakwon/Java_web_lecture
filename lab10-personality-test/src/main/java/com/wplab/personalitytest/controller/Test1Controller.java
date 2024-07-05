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

@WebServlet(name = "Test1Controller", value = {"/test1"})
public class Test1Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Test1Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String username = request.getParameter("username");
		HashMap<String, Integer> reply = new HashMap<String, Integer>();
		
		HttpSession session = request.getSession();
		
		if (session.isNew()) {
			session.setAttribute("username", username);
			session.setAttribute("reply_store", reply);
		}
		
		RequestDispatcher view = request.getRequestDispatcher("/test1.jsp");
		view.forward(request, response);
	}
}