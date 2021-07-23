package com.test.web.controller.delivery;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.biz.DeliveryService;
import com.test.biz.ResumeService;
import com.test.biz.UserInfoService;
import com.test.biz.impl.DeliveryServiceImpl;
import com.test.biz.impl.ResumeServiceImpl;
import com.test.biz.impl.UserInfoServiceImpl;
import com.test.domain.po.Delivery;
import com.test.domain.po.Resume;
import com.test.domain.po.UserInfo;

/**
 * Servlet implementation class AddDeliveryServlet
 */
@WebServlet("/AddDeliveryServlet")
public class AddDeliveryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddDeliveryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		HttpSession  session=request.getSession();
		Integer userId=-1;
		String userIdString=session.getAttribute("userId").toString();
		if(userIdString!=null&&userIdString!="") {
			 userId=Integer.parseInt(userIdString);
		}
		UserInfoService userInfoService=new UserInfoServiceImpl();
		UserInfo userInfo=userInfoService.findById(userId);
		if(userInfo==null) {
			 out.print("<script type='text/javascript' charset='UTF-8'>");
				out.print("alert('did not exit this user');");
				out.print("window.location='userindex.jsp';");
				out.print("</script>");
				return ;
		}
		if(userInfo.getState()==0) {
			 out.print("<script type='text/javascript' charset='UTF-8'>");
				out.print("alert('you have been freezen!');");
				out.print("window.location='userindex.jsp';");
				out.print("</script>");
		}
		ResumeService resumeService=new ResumeServiceImpl();
		Resume resume=resumeService.findByUserId(userId);
		if(resume==null) {
			 out.print("<script type='text/javascript' charset='UTF-8'>");
				out.print("alert('you need add a resume first!');");
				out.print("window.location='userindex.jsp';");
				out.print("</script>");
				return ;
		}
		String reidString=session.getAttribute("reid").toString();
		Integer reid=Integer.parseInt(reidString);
		Integer state=0;
		DeliveryService deliveryService=new DeliveryServiceImpl();
		Delivery delivery=new Delivery(reid,userId,state);
		deliveryService.register(delivery);
		response.sendRedirect("userindex.jsp");
	}

}
