package com.test.web.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.biz.AdminInfoService;
import com.test.biz.impl.AdminInfoServiceImpl;
import com.test.domain.po.AdminInfo;

@WebServlet("/logAdminServlet")
public class LogAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminInfoService adminInfoService=new AdminInfoServiceImpl();
       
    public LogAdminServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 //实现登录的servlet
		/*
		 * 1.获取前端请求数据
		 */
		String adminname=request.getParameter("adminname");
		String adminpassword=request.getParameter("adminpassword"); 
		HttpSession session=request.getSession();
		session.setAttribute("adminname", adminname);
		session.setAttribute("adminpassword", adminpassword);
		//2.调用biz方法
		AdminInfo adminInfo=new AdminInfo(adminname, adminpassword);
		boolean result=adminInfoService.login(adminInfo);		
		//3.根据返回值来执行相应的跳转
		if(result) {
		   //转发跳转到 index.jsp页面
			//System.out.println(2222);
		   RequestDispatcher rdp= request.getRequestDispatcher("adminindex.jsp");
		   rdp.forward(request, response);
	    }
		else {
			RequestDispatcher rdp= request.getRequestDispatcher("adminlogin.jsp");
			   rdp.forward(request, response);
			//System.out.println(3333);
			//request.setAttribute("","用户名或密码不正确");
			
		}
		//doGet(request, response);
	}

}
