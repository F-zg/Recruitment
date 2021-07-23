package com.test.web.controller.Reinformation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.biz.ReinformationBiz;
import com.test.biz.impl.ReinformationBizImpl;
import com.test.domain.vo.Page;

/**
 * Servlet implementation class ReinformationPagesServlet
 */
//@WebServlet("/reinformationPagesServlet")
public class ReinformationPagesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ReinformationBiz reinformationBiz = new ReinformationBizImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("ReinformationPagesServlet����ȡ��Ƹ��ҳ��Ϣ");
		
		int currentPage = 1;
		
		if(request.getParameter("currentPage")!=null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		Page page = reinformationBiz.selectReinByPage(currentPage);
		request.setAttribute("page", page);
		request.getRequestDispatcher("reinPages.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
