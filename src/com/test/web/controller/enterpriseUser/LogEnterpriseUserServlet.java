package com.test.web.controller.enterpriseUser;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.biz.EnterpriseUserService;
import com.test.biz.impl.EnterpriseUserServiceImpl;
import com.test.domain.po.EnterpriseUser;
/**
 * Servlet implementation class LogEnterpriseUserServlet
 */
@WebServlet("/LogEnterpriseUserServlet")
public class LogEnterpriseUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogEnterpriseUserServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		String euname=request.getParameter("euname");
	   String eupassword=request.getParameter("eupassword");
	   EnterpriseUserService enterPserUserService=new EnterpriseUserServiceImpl();
	   EnterpriseUser enterpriseUser=enterPserUserService.findByName(euname);
	   if(enterpriseUser!=null) {
		   String realpassword=enterpriseUser.getEupassword();
		   if(eupassword.equals(realpassword)) {
			   HttpSession session=request.getSession();
			   session.setAttribute("enterpriseUser", enterpriseUser);
			   response.sendRedirect("indexEnterpriseuser.jsp");    
		   }else {
			   out.print("<script type='text/javascript' charset='UTF-8'>");
				out.print("alert('eupassword error');");
				out.print("window.location='logenterpriseUser.jsp';");
				out.print("</script>");
		   }
	   }else {
		   out.print("<script type='text/javascript'>");
			out.print("alert('not existed this euname');");
			out.print("window.location='logenterpriseUser.jsp';");
			out.print("</script>");
	   }
	}

}
