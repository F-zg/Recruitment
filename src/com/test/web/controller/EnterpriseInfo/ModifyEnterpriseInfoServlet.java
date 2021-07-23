package com.test.web.controller.EnterpriseInfo;

import java.io.IOException;

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
 * Servlet implementation class ModifyEnterpriseInfoServlet
 */
@WebServlet("/modifyEnterpriseInfoServlet")
public class ModifyEnterpriseInfoServlet extends HttpServlet {
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
		/*
		 * String action = request.getParameter("action");
		 */ Integer eid = Integer.parseInt(request.getParameter("eid"));
		 
		String ename = request.getParameter("ename");
		String eintro = request.getParameter("eintro");
		String intustry = request.getParameter("intustry");
		EnterpriseInfo enterpriseInfo = new EnterpriseInfo(eid, ename, eintro, intustry);
		
		boolean res = enterpriseInfoService.update(enterpriseInfo);
		if (res == true) {
			request.setAttribute("enterpriseInfo1", enterpriseInfo);
			request.getRequestDispatcher("listEnterpriseInfoServlet").forward(request, response);
		} else {
			request.setAttribute("enterpriseInfo", enterpriseInfo);
			request.getRequestDispatcher("modifyEnterpriseInfo.jsp").forward(request, response);
		}
		/*
		 * if ("update".equals(action)) { update(request, response); } else if
		 * ("getEnterpriseInfoById".equals(action)) { getEnterpriseInfoById(request,
		 * response); }
		 */
	}



	/*
	 * private void update(HttpServletRequest request, HttpServletResponse response)
	 * throws ServletException, IOException { // TODO Auto-generated method stub //
	 * TODO Auto-generated method stub request.setCharacterEncoding("UTF-8");
	 * response.setCharacterEncoding("UTF-8");
	 * response.setContentType("text/html;charset=UTF-8"); int eid =
	 * Integer.parseInt(request.getParameter("eid")); String ename =
	 * request.getParameter("ename"); String eintro =
	 * request.getParameter("eintro"); String intustry =
	 * request.getParameter("instury"); EnterpriseInfo enterpriseInfo = new
	 * EnterpriseInfo(eid, ename, eintro, intustry); boolean res =
	 * enterpriseInfoService.update(enterpriseInfo); if (res == true) {
	 * request.setAttribute("enterpriseInfo", enterpriseInfo);
	 * request.getRequestDispatcher("listEnterpriseInfoServlet").forward(request,
	 * response); } else { request.setAttribute("enterpriseInfo", enterpriseInfo);
	 * request.getRequestDispatcher("modifyEnterpriseInfo.jsp").forward(request,
	 * response); } }
	 */

}
