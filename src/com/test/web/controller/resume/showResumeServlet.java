package com.test.web.controller.resume;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;

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
 * Servlet implementation class showResumeServlet
 */
@WebServlet("/showResumeServlet")
public class showResumeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ResumeService resumeService = new ResumeServiceImpl();

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
		HttpSession session=request.getSession();
		String userIdString=session.getAttribute("userId").toString();
		Integer userId=Integer.parseInt(userIdString);
		Resume  resume=resumeService.findByUserId(userId);
        request.setAttribute("resume", resume);
		request.getRequestDispatcher("/showResume.jsp").forward(request, response);	
	}

}
