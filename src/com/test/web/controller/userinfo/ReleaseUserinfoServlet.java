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

@WebServlet("/releaseUserinfoServlet")
public class ReleaseUserinfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//����bizʵ�ֹ���
	private UserInfoService userInfoService=new UserInfoServiceImpl();     
    public ReleaseUserinfoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ȡid
	    int userId  = WebUtils.parseInt(request.getParameter("userId"), 0);
		//ִ�нⶳ����������1,�ⶳ�ɹ�����֮ʧ��
		int result=userInfoService.releasestate(userId);
		if(result==1) {
			//�ⶳ�ɹ� �ض���
			RequestDispatcher rdp= request.getRequestDispatcher("listAllUserForFreezeorReleaseServlet");
			rdp.forward(request, response);
		}
		else {
		//�ⶳʧ��
			response.sendRedirect("500.jsp");
		}
	}

}
