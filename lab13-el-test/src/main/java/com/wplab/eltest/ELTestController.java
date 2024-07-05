package com.wplab.eltest;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "ELTestController",
			value = {"/eltest.do"})
public class ELTestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ELTestController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// step #2. data processing
		int result = 0;
		
		for (int i=1; i<=100; i++) {
			result += i;
		}
		
		PersonalInfo psInfo = new PersonalInfo();
		psInfo.setName("홍길동");
		psInfo.setGender('M');
		psInfo.setAge(30);
		psInfo.setMarried(false);
		
		// step #3. output results → view navigation
		request.setAttribute("num1", "251");
		request.setAttribute("num2", "34");
		
		request.setAttribute("result", result);
		request.setAttribute("psInfo", psInfo);
		
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/eltest.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
