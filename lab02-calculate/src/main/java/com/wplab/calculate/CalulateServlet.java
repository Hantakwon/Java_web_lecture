package com.wplab.calculate;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/calculate.do")
public class CalulateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CalulateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String num1Str = request.getParameter("num1");
		String num2Str = request.getParameter("num2");
		String opStr = request.getParameter("oprator");

		Double num1 = 0.0;
		Double num2 = 0.0;

		if (num1Str != null && !num1Str.isBlank()) {
			num1 = Double.parseDouble(num1Str);
		}
		if (num2Str != null && !num2Str.isBlank()) {
			num2 = Double.parseDouble(num2Str);
		}

		// step #2. data processing 데이터 처리
		Double result = 0.0;

		if (opStr.equals("+")) {
			result = num1 + num2;
		} else if (opStr.equals("-")) {
			result = num1 - num2;
		} else if (opStr.equals("*")) {
			result = num1 * num2;
		} else if (opStr.equals("/")) {
			result = num1 / num2;
		}

		Map<String, Object> calculationData = new HashMap<>();
		calculationData.put("num1", num1);
		calculationData.put("num2", num2);
		calculationData.put("opStr", opStr);
		calculationData.put("result", result);

		// Set the Map as a request attribute
		request.setAttribute("calculationData", calculationData);

		RequestDispatcher view = request.getRequestDispatcher("/CalculatorResult.jsp");
		view.forward(request, response);

		/*
		 * // step #3. output results 결과 출력 
		 * response.setContentType("text/html");
		 * response.setCharacterEncoding("UTF-8");
		 * 
		 * PrintWriter out = response.getWriter();
		 * 
		 * out.println("<html>"); out.println("<head>");
		 * out.println("<title>사칙연산 계산기</title>"); out.println("</head>");
		 * out.println("<body>"); out.println("<h1>Calculation Result</h1><hr>");
		 * out.println("<p>" + num1 + opStr + num2 + "=" + result + "</p>");
		 * out.println("</body>"); out.println("</html>");
		 * 
		 * out.close();
		 */
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
