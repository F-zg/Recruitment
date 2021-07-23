package com.test.web.controller.Reinformation;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.biz.ReinformationBiz;
import com.test.biz.impl.ReinformationBizImpl;
import com.test.domain.po.Reinformation;

/**
 * Servlet implementation class GetReinformationByIdServlet2
 */
@WebServlet("/GetReinformationByIdServlet2")
public class GetReinformationByIdServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReinformationBiz reinformationBiz = new ReinformationBizImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetReinformationByIdServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = -1;
		String path = "/detailReinformation2.jsp";
		if(request.getParameter("reid")!=null) {
			id=Integer.parseInt(request.getParameter("reid"));
		}
		Reinformation reinformation = reinformationBiz.findById(id);
		request.setAttribute("reinformation", reinformation);
	     HttpSession session=request.getSession();
	     session.setAttribute("reid", id);
		request.getRequestDispatcher(path).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
