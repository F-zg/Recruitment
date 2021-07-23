package com.test.web.controller.enterpriseUser;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.biz.EnterpriseUserService;
import com.test.biz.impl.EnterpriseUserServiceImpl;
import com.test.domain.po.EnterpriseUser;

/**
 * Servlet implementation class ListAllEuserServlet
 */
@WebServlet("/ListAllEuserServlet")
public class ListAllEuserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListAllEuserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   EnterpriseUserService enterPserUserService=new EnterpriseUserServiceImpl();
	   List<EnterpriseUser> list=enterPserUserService.findAll();
	   request.setAttribute("alleuser", list);
	   request.getRequestDispatcher("/listEnterpriseUser.jsp").forward(request, response);
	
	}

}
