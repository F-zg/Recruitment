package com.test.web.controller.delivery;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.biz.DeliveryService;
import com.test.biz.ReinformationBiz;
import com.test.biz.ResumeService;
import com.test.biz.impl.DeliveryServiceImpl;
import com.test.biz.impl.ReinformationBizImpl;
import com.test.biz.impl.ResumeServiceImpl;
import com.test.domain.po.Delivery;
import com.test.domain.po.Reinformation;
import com.test.domain.po.Resume;

/**
 * Servlet implementation class QuerydeliveryServlet
 */
@WebServlet("/QuerydeliveryServlet")
public class QuerydeliveryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuerydeliveryServlet() {
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
		DeliveryService deliveryService=new DeliveryServiceImpl();
		Delivery delivery=deliveryService.findById(did);
		Integer reid=delivery.getReid();
		Integer userId=delivery.getUserid();
		ReinformationBiz reinformationBiz=new ReinformationBizImpl();
		Reinformation reinformation=reinformationBiz.findById(reid);
		ResumeService resumeService=new ResumeServiceImpl();
		Resume resume=resumeService.findByUserId(userId);
		request.setAttribute("delivery", delivery);
		request.setAttribute("reinformation", reinformation);
		request.setAttribute("resume", resume);
		request.getRequestDispatcher("/Detaildelivery.jsp").forward(request, response);	
	}

}
