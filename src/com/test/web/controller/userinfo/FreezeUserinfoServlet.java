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


@WebServlet("/freezeUserinfoServlet")
public class FreezeUserinfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//依赖biz实现功能
	private UserInfoService userInfoService=new UserInfoServiceImpl();  
    public FreezeUserinfoServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取id
	    int userId  = WebUtils.parseInt(request.getParameter("userId"), 0);
	    System.out.println(userId);
		//执行冻结操作，返回1,删除成功，反之失败
		int result=userInfoService.updatestate(userId);
		if(result==1) {
			//冻结成功 重定向
			RequestDispatcher rdp= request.getRequestDispatcher("listAllUserForFreezeorReleaseServlet");
			rdp.forward(request, response);
		}
		else {
		//冻结失败
			RequestDispatcher rdp= request.getRequestDispatcher("500.jsp");
			rdp.forward(request, response);
		}
		
	}

}
