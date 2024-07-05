package com.wplab.listenertest;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "IntervalSumController", 
			value = {"/interval_sum.do"})
public class IntervalSumController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IntervalSumController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// step #1. get request parameters
		String firstStr = request.getParameter("first");
		String secondStr = request.getParameter("second");
		
		int firstNum = 1;
		if (firstStr != null && !firstStr.isBlank()) {
			firstNum = Integer.parseInt(firstStr);
		}
		int secondNum = 100;
		if (secondStr != null && !secondStr.isBlank()) {
			secondNum = Integer.parseInt(secondStr);
		}
		// step #2. data processing using service moudule
		CalculationService service = new CalculationService();
		long sum = service.intervalSum(firstNum, secondNum);
		
		DataObject DO = new DataObject();
		
		DO.setFirstNum(firstNum);
		DO.setSecondNum(secondNum);
		DO.setSum(sum);
		
		request.setAttribute("DO", DO);
		
		// step #3. view navigation - output results
		RequestDispatcher view = request.getRequestDispatcher("interval_sum.jsp");
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
