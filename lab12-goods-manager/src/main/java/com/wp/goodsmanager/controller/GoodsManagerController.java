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

/**
 * Servlet implementation class GoodsManagerController
 */
@WebServlet("/books/*")
public class GoodsManagerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoodsManagerController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// step #1. get request parameters
		request.setCharacterEncoding("UTF-8");
		
		// step #2. data processing
		// get DAO object
		DBConnectionInfo dbInfo = (DBConnectionInfo)getServletContext().getAttribute("db_info");
		GoodsinfoDAO dao = new GoodsinfoDAOImpl(dbInfo);	
		
		// get dispatching info.
		String pathInfo = request.getPathInfo();
		String action = request.getParameter("action");
		
		String viewName = null;
		
		if (pathInfo != null && pathInfo.length() > 1) {
			if (pathInfo.equals("/list")) {
				// get all records from db table
				List<GoodsDO> goodsList = null;
				goodsList = dao.listGoods();
				
				// bind result as a request attribute
				request.setAttribute("goods_list", goodsList);
				
				viewName = "/views/list_goods2.jsp";
			}
		}
		else if (action != null) {
			if (action.equals("register_form")) {
				viewName = "/views/register_form2.jsp";
			}
			else if (action.equals("register")) {
				// form data binding
				GoodsDO goods = new GoodsDO();
				goods.setCode(request.getParameter("code"));
				goods.setTitle(request.getParameter("title"));
				goods.setWriter(request.getParameter("writer"));
				String priceStr = request.getParameter("price");
				goods.setPrice((priceStr != null && !priceStr.isEmpty()) ? Integer.parseInt(priceStr) : 0);
				
				// form data validation
				// ...
				
				// data processing...
				// insert new goods info to DB
				dao.insertGoods(goods);
				
				// redirect to goods-list page
				viewName = "redirect:/books/list";
			}
			else if (action.equals("update_form")) {
				// get code parameter
				String code = request.getParameter("code");
				
				//search goods info of the code
				GoodsDO goods = new GoodsDO();
				goods.setCode(code);
				
				goods = dao.getGoods(goods);
				
				// bind goods into to request attribute
				request.setAttribute("goods", goods);
				
				// forward to update_form.jsp
				viewName = "/views/update_form2.jsp";				
			}
			else if (action.equals("update")) {
				// form data binding
				GoodsDO goods = new GoodsDO();
				goods.setCode(request.getParameter("code"));
				goods.setTitle(request.getParameter("title"));
				goods.setWriter(request.getParameter("writer"));
				String priceStr = request.getParameter("price");
				goods.setPrice((priceStr != null && !priceStr.isEmpty()) ? Integer.parseInt(priceStr) : 0);
				
				// form data validation
				// ...
				
				// data processing...
				// update goods info on DB
				dao.updateGoods(goods);
				
				// redirect to goods-list page
				viewName = "redirect:/books/list";
			}
			else if (action.equals("delete")) {
				// get code parameter
				String code = request.getParameter("code");
				
				// data processing...
				// delete goods info from DB
				GoodsDO goods = new GoodsDO();
				goods.setCode(code);
						
				dao.deleteGoods(goods);
				
				// redirect to goods-list page
				viewName = "redirect:/books/list";
			}
		}
			
		// step #3. output results
		if (viewName != null) {
			if (viewName.contains("redirect:")) {
				String location = viewName.split(":")[1];
				response.sendRedirect(request.getContextPath() + location);
			}
			else {
				RequestDispatcher view = request.getRequestDispatcher(viewName);
				view.forward(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
