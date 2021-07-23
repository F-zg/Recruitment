package com.test.web.controller.userinfo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.biz.UserInfoService;
import com.test.biz.impl.UserInfoServiceImpl;
import com.test.domain.po.UserInfo;


@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//依赖biz实现功能
	private UserInfoService userInfoService=new UserInfoServiceImpl();
    public LoginServlet() {
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
		String username=request.getParameter("username");
		String password=request.getParameter("password"); 
		HttpSession session=request.getSession();
		session.setAttribute("username", username);
		session.setAttribute("password", password);
		//2.调用biz方法
		UserInfo user=new UserInfo(username, password);
		boolean result=userInfoService.login(user);		
		//3.根据返回值来执行相应的跳转
		if(result) {
		   //转发跳转到 index.jsp页面
			UserInfo userInfo=userInfoService.findUser1ByUserNameAndUseerPassword(username, password);
			Integer  userId=userInfo.getUserId();
			session.setAttribute("userId", userId);
			System.out.println(session.getAttribute("userId"));
		   RequestDispatcher rdp= request.getRequestDispatcher("userindex.jsp");
		   rdp.forward(request, response);
	    }
		else {
			//转向跳转到 login.jsp页面
			 RequestDispatcher rdp= request.getRequestDispatcher("login.jsp");
			   rdp.forward(request, response);
		}
		
	}

}
