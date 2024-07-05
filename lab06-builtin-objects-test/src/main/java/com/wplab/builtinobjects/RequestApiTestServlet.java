package com.wplab.builtinobjects;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/request_test.do")
public class RequestApiTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RequestApiTestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		StringBuffer url = request.getRequestURL();
		String method = request.getMethod();
		String queryString = request.getQueryString();
		Enumeration<String> names = request.getParameterNames();
		Enumeration<String> headers = request.getHeaderNames();
		String host = request.getRemoteHost();
		int port = request.getRemotePort();
		
		RequestInfo requestinfo = new RequestInfo();
		
		requestinfo.setUrl(url);
		requestinfo.setMethod(method);
		requestinfo.setQueryString(queryString);
		requestinfo.setNames(names);
		requestinfo.setHeaders(headers);
		requestinfo.setHost(host);
		requestinfo.setPort(port);
		
		HttpSession session = request.getSession();
		session.setAttribute("requestinfo", requestinfo);             

		RequestDispatcher view = request.getRequestDispatcher("/result.jsp");
		view.forward(request, response);
	}
		
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
