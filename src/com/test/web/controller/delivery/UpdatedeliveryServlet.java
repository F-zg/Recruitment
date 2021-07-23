package com.test.web.controller.delivery;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.biz.DeliveryService;
import com.test.biz.ResumeService;
import com.test.biz.impl.DeliveryServiceImpl;
import com.test.biz.impl.ResumeServiceImpl;
import com.test.domain.po.Delivery;
import com.test.domain.po.Resume;

/**
 * Servlet implementation class UpdatedeliveryServlet
 */
@WebServlet("/UpdatedeliveryServlet")
public class UpdatedeliveryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatedeliveryServlet() {
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
		Integer did=Integer.parseInt(request.getParameter("did"));
		Integer state=Integer.parseInt(request.getParameter("state"));
		DeliveryService deliveryService=new DeliveryServiceImpl();
		Delivery delivery=deliveryService.findById(did);
		Integer userId=delivery.getUserid();
		ResumeService resumeService=new ResumeServiceImpl();
		Resume resume=resumeService.findByUserId(userId);
		if(state==1) {
			delivery.setState(1);
			resume.setExamState(1);
			deliveryService.update(delivery);
			resumeService.update(resume);
		}else {
			delivery.setState(0);
			resume.setExamState(0);
			deliveryService.update(delivery);
			resumeService.update(resume);
		}
		request.getRequestDispatcher("/ShowAlldeliveryServlet").forward(request, response);	
	}

}
