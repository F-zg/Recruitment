package com.test.web.controller.EnterpriseInfo;

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

/**
 * Servlet implementation class ListENterpriseInfoforUserServlet
 */
@WebServlet("/ListEnterpriseInfoforUserServlet")
public class ListEnterpriseInfoforUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EnterpriseInfoService enterpriseInfoService = new EnterpriseInfoServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListEnterpriseInfoforUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		List<EnterpriseInfo> list = enterpriseInfoService.findAll();
		request.setAttribute("list", list);
		request.getRequestDispatcher("showAllenterpriseForuser.jsp").forward(request, response);
	}

}
