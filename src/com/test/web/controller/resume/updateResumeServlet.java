package com.test.web.controller.resume;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
 * Servlet implementation class updateResumeServlet
 */
@WebServlet("/updateResumeServlet")
public class updateResumeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ResumeService resumeService = new ResumeServiceImpl();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String userIdString=session.getAttribute("userId").toString();
		Integer userId=Integer.parseInt(userIdString);
		ResumeService resumeService=new ResumeServiceImpl();
	    Resume resume1 =resumeService.findByUserId(userId);
		if(resume1==null) {
			PrintWriter out=response.getWriter();
			  out.print("<script type='text/javascript' charset='UTF-8'>");
				out.print("alert('you should add a resume first');");
				out.print("window.location='addResume.jsp';");
				out.print("</script>");
				return ;
		}
		Integer rid=resume1.getRid();
		Integer examState=resume1.getExamState();
		String rcompany = request.getParameter("rcompany");
		String position = request.getParameter("position");		
		String workStartTimeString = request.getParameter("workStartTime");	
		String workEndTimeString = request.getParameter("workEndTime");
		DateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		Date workStartTime = null;
		try {
			workStartTime = sdf.parse(workStartTimeString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Date workEndTime = null;
		try {
			workEndTime = sdf.parse(workEndTimeString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String salarystring = request.getParameter("salary");
		String duty = request.getParameter("duty");
		String schoolName = request.getParameter("schoolName");
		String education = request.getParameter("education");
		String professional = request.getParameter("professional");
		String entranceTimeString = request.getParameter("entranceTime");		
		String graduateTimeString = request.getParameter("graduateTime");
		Date entranceTime = null;
		try {
			entranceTime = sdf.parse(entranceTimeString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Date graduateTime = null;
		try {
			graduateTime = sdf.parse(graduateTimeString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		BigDecimal salary=new BigDecimal(salarystring); 
		Resume resume = new Resume( rid,rcompany,  position, workStartTime,  workEndTime,  salary,duty,  schoolName,  education, professional,  entranceTime,  graduateTime,examState, userId);
		
		boolean result = resumeService.update(resume);
		if (result) {
			// 转发跳转到index.jsp
			RequestDispatcher rdp = request.getRequestDispatcher("showResumeServlet");
			rdp.forward(request, response);
		}
		else {	
			response.sendRedirect("addResume.jsp");
		}
	}

}
