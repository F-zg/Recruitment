package com.test.web.controller.EnterpriseInfo;

//鏂藉伐瀹屾垚
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.biz.EnterpriseInfoService;
import com.test.biz.impl.EnterpriseInfoServiceImpl;
import com.test.domain.po.EnterpriseInfo;
import com.test.domain.vo.Page;

/**
 * Servlet implementation class EnterpriseInfoPagesServelt
 */
@WebServlet("/enterpriseInfoPagesServelt")
public class EnterpriseInfoPagesServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EnterpriseInfoService enterpriseInfoService = new EnterpriseInfoServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EnterpriseInfoPagesServelt() {
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

		int currentPage = 1;

		// 鍒ゆ柇浠庣鍑犻〉寮�濮嬫樉绀�
		if (request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}

		Page page = enterpriseInfoService.selectEnterpriseinfoByPage(currentPage);
		request.setAttribute("page", page);
		request.getRequestDispatcher("showPageEnterpriseInfo.jsp").forward(request, response);

	}
}
