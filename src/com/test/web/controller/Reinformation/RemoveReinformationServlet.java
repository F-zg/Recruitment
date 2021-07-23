package com.test.web.controller.Reinformation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.biz.ReinformationBiz;
import com.test.biz.impl.ReinformationBizImpl;

/**
 * Servlet implementation class RemoveReinformationServlet
 */
@WebServlet("/RemoveReinformationServlet")
public class RemoveReinformationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private ReinformationBiz reinformationBiz = new ReinformationBizImpl();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveReinformationServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int reid = Integer.parseInt(request.getParameter("reid"));
		
		boolean result = reinformationBiz.remove(reid);
		
		if(result) {
			//request.setAttribute("msg", "添加成功");
			request.getRequestDispatcher("/GetAllReinformationsServlet").forward(request, response);
		}else {
			//request.setAttribute("msg", "添加失败");
			request.getRequestDispatcher("/GetAllReinformationsServlet").forward(request, response);
		}
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
