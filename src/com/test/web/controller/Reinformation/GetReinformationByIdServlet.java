package com.test.web.controller.Reinformation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.biz.ReinformationBiz;
import com.test.biz.impl.ReinformationBizImpl;
import com.test.domain.po.Reinformation;

/**
 * Servlet implementation class GetReinformationByIdServlet
 */
@WebServlet("/GetReinformationByIdServlet")
public class GetReinformationByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ReinformationBiz reinformationBiz = new ReinformationBizImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetReinformationByIdServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = -1;
		String path = "/detailReinformation.jsp";
		if(request.getParameter("reid")!=null) {
			id=Integer.parseInt(request.getParameter("reid"));
		}
		if(request.getParameter("path")!=null) {
			path=request.getParameter("path");
		}
		
		Reinformation reinformation = reinformationBiz.findById(id);
		request.setAttribute("reinformation", reinformation);
		request.getRequestDispatcher(path).forward(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
