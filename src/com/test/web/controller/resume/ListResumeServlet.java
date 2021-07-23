package com.test.web.controller.resume;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.biz.ResumeService;
import com.test.biz.impl.ResumeServiceImpl;
import com.test.domain.po.Resume;

/**
 * Servlet implementation class ListResumeServlet
 */
@WebServlet("/ListResumeServlet")
public class ListResumeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListResumeServlet() {
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
		List<Resume> list=new ArrayList<Resume>();
		ResumeService resumeService=new ResumeServiceImpl();
		list=resumeService.findAll();
		request.setAttribute("resumelist", list);
		request.getRequestDispatcher("/listResume.jsp").forward(request, response);	
	}

}
