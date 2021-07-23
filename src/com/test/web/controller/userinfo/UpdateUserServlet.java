package com.test.web.controller.userinfo;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.biz.UserInfoService;
import com.test.biz.impl.UserInfoServiceImpl;
import com.test.domain.po.UserInfo;


@WebServlet("/updateUserServlet")
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//依赖biz实现功能
	private UserInfoService userInfoService=new UserInfoServiceImpl();	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("utf-8");
        String username1=(String)request.getSession().getAttribute("username");
		String password1=(String)request.getSession().getAttribute("password");
		System.out.println(username1);
		//寻找用户
		UserInfo userInfo1=userInfoService.findUser1ByUserNameAndUseerPassword(username1, password1);
		int userid=userInfo1.getUserId();
		System.out.println(userid);
		//更改用户信息
		String username=request.getParameter("username");
		System.out.println(username);
		String password=request.getParameter("password");
		System.out.println(password);
		// 将borndateString(yyyy-mm-dd)转成date
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date borndate = null;
		try {
			borndate =sdf.parse(request.getParameter("borndate"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println(borndate);
		String gender=request.getParameter("gender");
		String city=request.getParameter("city");
		String telephone=request.getParameter("telephone");
		String email=request.getParameter("email");
		String address=request.getParameter("address");
		UserInfo userInfo2=new UserInfo(userid, username, password, borndate, gender, city, telephone, email, address);
		//3.调用biz方法
		boolean result=userInfoService.update(userInfo2);
		//4.根据返回值来执行相应的跳转
		if(result) {
			//修改成功
			System.out.println(88888888);
			RequestDispatcher rdp= request.getRequestDispatcher("displayUserinfoServlet");
			rdp.forward(request, response);
		}
		else {
			System.out.println("修改失败");
		}
		doGet(request, response);
	}

}
