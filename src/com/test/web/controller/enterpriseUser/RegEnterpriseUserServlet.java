package com.test.web.controller.enterpriseUser;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.biz.EnterpriseUserService;
import com.test.biz.impl.EnterpriseUserServiceImpl;
import com.test.domain.po.EnterpriseUser;

/**
 * Servlet implementation class RegEnterpriseUserServlet
 */
@WebServlet("/RegEnterpriseUserServlet")
public class RegEnterpriseUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegEnterpriseUserServlet() {
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
		PrintWriter out=response.getWriter();
		String euname=request.getParameter("euname");
	   String eupassword=request.getParameter("eupassword");
	   Integer eid=Integer.parseInt(request.getParameter("eid"));
	   EnterpriseUserService enterPserUserService=new EnterpriseUserServiceImpl();
	   EnterpriseUser enterpriseUser1=enterPserUserService.findByName(euname);
	   if(enterpriseUser1==null) {
		  EnterpriseUser enterpriseUser2=new EnterpriseUser(euname,eupassword,eid);
		  boolean flag=enterPserUserService.register(enterpriseUser2);
		   if(flag==true) {
			   response.sendRedirect("logenterpriseUser.jsp");    
		   }else {
			   out.print("<script type='text/javascript'>");
				out.print("alert('register failed');");
				out.print("window.location='regEnterpriseUser.jsp';");
				out.print("</script>");
		   }
	   }else {
		   out.print("<script type='text/javascript'>");
			out.print("alert('this euname has existed');");
			out.print("window.location='regEnterpriseUser.jsp';");
			out.print("</script>");
	   }
	}

}
