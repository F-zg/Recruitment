package com.test.web.controller.EnterpriseInfo;

//施工完成
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.biz.EnterpriseInfoService;
import com.test.biz.impl.EnterpriseInfoServiceImpl;

/**
 * Servlet implementation class DelEnterpriseInfoServlet
 */
@WebServlet("/delEnterpriseInfoServlet")
public class DelEnterpriseInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EnterpriseInfoService enterpriseInfoService = new EnterpriseInfoServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DelEnterpriseInfoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		int eid = Integer.parseInt(request.getParameter("eid"));
		boolean result = enterpriseInfoService.remove(eid);
		if (result == true) {
			RequestDispatcher rdp = request.getRequestDispatcher("listEnterpriseInfoServlet");
			rdp.forward(request, response);
		} else {
			response.sendRedirect("showPageEnterpriseInfo.jsp");
		}
	}
}
