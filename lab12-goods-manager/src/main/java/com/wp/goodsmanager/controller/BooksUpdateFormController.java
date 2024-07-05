package com.wp.goodsmanager.controller;

import java.io.IOException;

import com.wp.goodsmanager.service.GoodsDO;
import com.wp.goodsmanager.service.GoodsinfoDAO;
import com.wp.goodsmanager.service.GoodsinfoDAObyDBCP;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "BooksUpdateFromController",
			value = {"/books/update_form"})
public class BooksUpdateFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BooksUpdateFormController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// step #1. get request parameters
		request.setCharacterEncoding("UTF-8");
		
		String code = request.getParameter("code");
		
		// step #2. process business logic
		// get book list from DB
		String dbcpResourceName = 
				getServletContext().getInitParameter("dbcp_resource_name");
		GoodsinfoDAO dao = new GoodsinfoDAObyDBCP(dbcpResourceName);
		
		GoodsDO goods = new GoodsDO();
		goods.setCode(code);
		goods = dao.getGoods(goods);
			
		// step #3. output results to the client
		request.setAttribute("goods", goods);
		
		RequestDispatcher view = request.getRequestDispatcher("/views/update_form.jsp");
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
