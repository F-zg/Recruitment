package com.test.web.controller.userinfo;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.biz.UserInfoService;
import com.test.biz.impl.UserInfoServiceImpl;
import com.test.utils.WebUtils;


@WebServlet("/deleteUserinfoServlet")
public class DeleteUserinfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//����bizʵ�ֹ���
	private UserInfoService userInfoService=new UserInfoServiceImpl();  
   
    public DeleteUserinfoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ȡid
		int userId  = WebUtils.parseInt(request.getParameter("userId"), 0);
		//ִ��ɾ������������1,ɾ���ɹ�����֮ʧ��
		int result=userInfoService.del(userId);
		if(result==1) {
			//ɾ���ɹ� �ض���
			RequestDispatcher rdp= request.getRequestDispatcher("listAllUserForDeleteServlet");
			rdp.forward(request, response);
		}
		else {
			//ɾ��ʧ��
			RequestDispatcher rdp= request.getRequestDispatcher("500.jsp");
			rdp.forward(request, response);
		}
	}

}
