package com.test.web.controller.userinfo;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.biz.UserInfoService;
import com.test.biz.impl.UserInfoServiceImpl;
import com.test.domain.po.UserInfo;

@WebServlet("/listAllUserForFreezeorReleaseServlet")
public class ListAllUserForFreezeorReleaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//依赖biz实现功能
	private UserInfoService userInfoService=new UserInfoServiceImpl();   
    public ListAllUserForFreezeorReleaseServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//得到全部用户
		List<UserInfo> userinfos = userInfoService.findAll();
		System.out.println(userinfos);
		request.setAttribute("userinfos", userinfos);
		request.getRequestDispatcher("/freezeorreleaseuser.jsp").forward(request, response);
	}

}
