package com.test.web.controller.userinfo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.biz.DeliveryService;
import com.test.biz.UserInfoService;
import com.test.biz.impl.DeliveryServiceImpl;
import com.test.biz.impl.UserInfoServiceImpl;
import com.test.domain.po.Delivery;
import com.test.domain.po.UserInfo;

@WebServlet("/displayUserinfoServlet")
public class DisplayUserinfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DeliveryService deliveryService=new DeliveryServiceImpl();
   
	//依赖biz实现功能
	private UserInfoService userInfoService=new UserInfoServiceImpl();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//信息的展示
		//从servlet session 获取数据
		String username=(String)request.getSession().getAttribute("username");
		String password=(String)request.getSession().getAttribute("password");
//		int state=(int)request.getSession().getAttribute("state");
		int userid=(int)request.getSession().getAttribute("userId");
		HttpSession session=request.getSession();
		session.setAttribute("adminname", username);
		session.setAttribute("adminpassword", password);
		session.setAttribute("userid", userid);
		//寻找用户
		UserInfo userInfo=userInfoService.findUser1ByUserNameAndUseerPassword(username, password);
		List<UserInfo>userInfos= new ArrayList<>();
		userInfos.add(userInfo);
		request.setAttribute("userInfos", userInfos);
//		request.getRequestDispatcher("/displayuser.jsp").forward(request, response);
		Delivery delivery = deliveryService.findDeliveryByUserId(userid);
		request.setAttribute("delivery", delivery);
		request.getRequestDispatcher("/displayuser.jsp").forward(request, response);
		//找到用户
		
	}

}
