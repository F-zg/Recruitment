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

@WebServlet("/regServlet")
public class RegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	//����bizʵ�ֹ���
	private UserInfoService userInfoService=new UserInfoServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		        //ʵ��ע���servlet
				/*
				 * 1.��ȡǰ����������
				 */
		        request.setCharacterEncoding("utf-8");
		        response.setContentType("text/html; charset=UTF-8");
		        response.setCharacterEncoding("utf-8");
		        System.out.println(3333);
				String username=request.getParameter("username");
				System.out.println(username);
				String password=request.getParameter("password");
				String gender=request.getParameter("gender");
				System.out.println(gender);
				// ��borndateString(yyyy-mm-dd)ת��date
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date borndate = null;
				try {
					borndate =sdf.parse(request.getParameter("borndate"));
				} catch (ParseException e) {
					e.printStackTrace();
				}				
				String city=request.getParameter("city");
				String telephone=request.getParameter("telephone");
				String email=request.getParameter("email");
				String address=request.getParameter("address");
				System.out.println(address);
				int state=1;
				//2.����biz����
				UserInfo user=new UserInfo(username, password, borndate, gender, city, telephone, email, address,state);
				boolean result=userInfoService.register(user);
				//3.���ݷ���ֵ��ִ����Ӧ����ת
				if(result) {
					//ת����ת�� index.jspҳ��
					RequestDispatcher rdp= request.getRequestDispatcher("login.jsp");
					rdp.forward(request, response);
				}
				else {					
					//ת����ת�� reguser.jspҳ��
					response.sendRedirect("500.jsp");
				}
		doGet(request, response);
	}

}
