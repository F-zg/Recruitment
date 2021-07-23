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

/**
 * Servlet implementation class DeleteEuserServlet
 */
@WebServlet("/DeleteEuserServlet")
public class DeleteEuserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteEuserServlet() {
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
		Integer euid=Integer.parseInt(request.getParameter("euid"));
		EnterpriseUserService enterPserUserService=new EnterpriseUserServiceImpl();
		boolean flag=enterPserUserService.remove(euid);
		if(flag==true) {
			request.getRequestDispatcher("/ListAllEuserServlet").forward(request, response);	
		}else {
			PrintWriter out=response.getWriter();
			 out.print("<script type='text/javascript'>");
				out.print("alert('delete failed');");
				out.print("</script>");
				request.getRequestDispatcher("/ListAllEuserServlet").forward(request, response);	
		}
	}

}
