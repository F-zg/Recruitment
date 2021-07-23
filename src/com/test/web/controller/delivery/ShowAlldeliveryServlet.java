package com.test.web.controller.delivery;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
import com.test.domain.po.EnterpriseUser;
import com.test.domain.po.Reinformation;
import com.test.domain.po.Resume;

/**
 * Servlet implementation class ShowAlldeliveryServlet
 */
@WebServlet("/ShowAlldeliveryServlet")
public class ShowAlldeliveryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowAlldeliveryServlet() {
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
		DeliveryService deliveryService=new DeliveryServiceImpl();
		ReinformationBiz reinformationBiz=new ReinformationBizImpl();
		 List<Delivery> list=deliveryService.findAll();
		 List<Reinformation> relist=new ArrayList<Reinformation>();
		 for(int i=0;i<list.size();i++) {
			 Reinformation reinformation=reinformationBiz.findById(list.get(i).getReid());
			 relist.add(reinformation);
		 }
		   request.setAttribute("alldelivery", list);
		   request.setAttribute("relist", relist);
		   request.getRequestDispatcher("/listdelivery.jsp").forward(request, response);
	}

}
