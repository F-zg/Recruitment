package com.test.web.controller.delivery;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.biz.DeliveryService;
import com.test.biz.impl.DeliveryServiceImpl;
import com.test.domain.po.Delivery;

/**
 * Servlet implementation class DeletedeliveryServlet
 */
@WebServlet("/DeletedeliveryServlet")
public class DeletedeliveryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletedeliveryServlet() {
        super();
        // TODO Auto-generated constructor stub
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
		Integer did=Integer.parseInt(request.getParameter("did"));
		DeliveryService deliveryService=new DeliveryServiceImpl();
		Delivery delivery=deliveryService.findById(did);
		Integer reid=delivery.getReid();
		boolean flag=deliveryService.remove(did);
		if(flag==true) {
			request.getRequestDispatcher("/ShowAlldeliveryServlet").forward(request, response);	
    	}else {
    		PrintWriter out=response.getWriter();
			 out.print("<script type='text/javascript'>");
				out.print("alert('delete failed');");
				out.print("</script>");
				request.getRequestDispatcher("/ShowAlldeliveryServlet").forward(request, response);	
    	}
	}

}
