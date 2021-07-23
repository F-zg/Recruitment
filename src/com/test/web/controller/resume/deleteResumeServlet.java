package com.test.web.controller.resume;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.biz.ResumeService;
import com.test.biz.impl.ResumeServiceImpl;
import com.test.domain.po.Resume;

/**
 * Servlet implementation class deleteResumeServlet
 */
@WebServlet("/deleteResumeServlet")
public class deleteResumeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ResumeService resumeService = new ResumeServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String ridString=request.getParameter("rid");
		Integer rid=Integer.parseInt(ridString);
		
		boolean result = resumeService.remove(rid);
		if (result) {
			// 转发跳转到index.jsp
		 request.getRequestDispatcher("/ListResumeServlet").forward(request, response);	
		}
		else {	
			request.getRequestDispatcher("/ListResumeServlet").forward(request, response);	
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
