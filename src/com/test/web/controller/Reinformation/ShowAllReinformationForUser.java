package com.test.web.controller.Reinformation;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.biz.ReinformationBiz;
import com.test.biz.impl.ReinformationBizImpl;
import com.test.domain.po.Reinformation;

/**
 * Servlet implementation class ShowAllReinformationForUser
 */
@WebServlet("/ShowAllReinformationForUser")
public class ShowAllReinformationForUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReinformationBiz reinformationBiz = new ReinformationBizImpl(); 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowAllReinformationForUser() {
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
		List<Reinformation> list = reinformationBiz.findAll();
		request.setAttribute("Reinformationlist", list);
		request.getRequestDispatcher("/showAllReinformationForUser.jsp").forward(request, response);
	}

}
