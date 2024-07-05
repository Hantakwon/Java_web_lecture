package com.wplab.memberjoin;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/join.do")
public class MemberJoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MemberJoinServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		MemberInfo memberinfo = new MemberInfo();
		memberinfo.setName(request.getParameter("name"));
		memberinfo.setId(request.getParameter("id"));
		memberinfo.setPasswd(request.getParameter("passwd"));
		memberinfo.setGender(request.getParameter("gender"));
		memberinfo.setInotice(getNoticeMsg(request.getParameter("inotice")));
		memberinfo.setCnotice(getNoticeMsg(request.getParameter("cnotice")));
		memberinfo.setDnotice(getNoticeMsg(request.getParameter("dnotice")));
		memberinfo.setJob(request.getParameter("job"));

		
		HttpSession session = request.getSession();
		session.setAttribute("memberinfo", memberinfo);

		RequestDispatcher view = request.getRequestDispatcher("/MemberResult.jsp");
		view.forward(request, response);
	}

	private String getNoticeMsg(String notice) {
		if (notice != null && notice.equals("on")) {
			return "수신함";
		}
		else return "수신 거부";
	}
}
