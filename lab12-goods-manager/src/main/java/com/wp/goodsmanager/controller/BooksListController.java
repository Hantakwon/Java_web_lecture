package com.wp.goodsmanager.controller;

import java.io.IOException;
import java.util.List;

import com.wp.goodsmanager.service.DBConnectionInfo;
import com.wp.goodsmanager.service.GoodsDO;
import com.wp.goodsmanager.service.GoodsinfoDAO;
import com.wp.goodsmanager.service.GoodsinfoDAOImpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "BooksListController",
			value = {"/books/list"})
public class BooksListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BooksListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// step #1. get request parameters
		// no request parameters
		
		// step #2. process business logic
		// get book list from DB
		DBConnectionInfo dbInfo = (DBConnectionInfo)getServletContext().getAttribute("db_info");
		GoodsinfoDAO dao = new GoodsinfoDAOImpl(dbInfo);
		List<GoodsDO> list = dao.listGoods();
			
		// step #3. output results to the client
		request.setAttribute("goods_list", list);
		
		RequestDispatcher view = request.getRequestDispatcher("/views/list_goods.jsp");
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
