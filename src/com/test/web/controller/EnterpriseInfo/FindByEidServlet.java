package com.test.web.controller.EnterpriseInfo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.biz.EnterpriseInfoService;
import com.test.biz.impl.EnterpriseInfoServiceImpl;
import com.test.domain.po.EnterpriseInfo;


/**
 * Servlet implementation class FindByEidServlet
 */
@WebServlet("/findByEidServlet")
public class FindByEidServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EnterpriseInfoService enterpriseInfoService = new EnterpriseInfoServiceImpl();

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
		int eid=Integer.parseInt(request.getParameter("eid"));
		EnterpriseInfo enterpriseInfo=enterpriseInfoService.findById(eid);
		request.setAttribute("enterpriseInfo", enterpriseInfo);
		request.getRequestDispatcher("modifyEnterpriseInfo.jsp").forward(request, response);
	}

}
