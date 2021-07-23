package com.test.web.controller.EnterpriseInfo;

//企业信息增加  施工完成
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.biz.EnterpriseInfoService;
import com.test.biz.impl.EnterpriseInfoServiceImpl;
import com.test.domain.po.EnterpriseInfo;

/**
 * Servlet implementation class AddEnterpriseInfoServlet
 */
@WebServlet("/addEnterpriseInfoServlet")
public class AddEnterpriseInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EnterpriseInfoService enterpriseInfoService = new EnterpriseInfoServiceImpl();

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
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
		String ename = request.getParameter("ename");
		String eintro = request.getParameter("eintro");
		String intustry = request.getParameter("intustry");

		EnterpriseInfo enterpriseInfo = new EnterpriseInfo(ename, eintro, intustry);
		boolean result = enterpriseInfoService.add(enterpriseInfo);
		if (result == true) {
			RequestDispatcher rdp = request
					.getRequestDispatcher("listEnterpriseInfoServlet");
			rdp.forward(request, response);
		} else {
			response.sendRedirect("addEnterpriseInfo.jsp");
		}
	}

}
