package com.test.web.controller.Reinformation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.biz.ReinformationBiz;
import com.test.biz.impl.ReinformationBizImpl;
import com.test.domain.po.EnterpriseInfo;
import com.test.domain.po.Reinformation;

/**
 * Servlet implementation class AddReinformationServlet
 */
@WebServlet("/AddReinformationServlet")
public class AddReinformationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private ReinformationBiz reinformationBiz = new ReinformationBizImpl();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddReinformationServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		Reinformation re = new Reinformation();
		EnterpriseInfo e = new EnterpriseInfo();
		
		if(!request.getParameter("reid").equals("-1")) {
			re.setReid(Integer.parseInt(request.getParameter("reid")));
		}
		//re.setReid(Integer.parseInt(request.getParameter("reid")));
		re.setRePositionName(request.getParameter("rePositionName"));
		re.setReSalary(request.getParameter("reSalary"));
		re.setReCity(request.getParameter("reCity"));
		re.setReArea(request.getParameter("reArea"));
		re.setReWorkYears(request.getParameter("reWorkYears"));
		re.setReEducation(request.getParameter("reEducation"));
		re.setRePersonNum(Integer.parseInt(request.getParameter("rePersonNum")));
		re.setReLightPoint(request.getParameter("reLightPoint"));
		re.setReJobDesc(request.getParameter("reJobDesc"));
		re.setReDepartment(request.getParameter("reDepartment"));
		re.setReProfessional(request.getParameter("reProfessional"));
		re.setReReportPerson(request.getParameter("reReportPerson"));
		re.setReSubordinates(Integer.parseInt(request.getParameter("reSubordinates")));
		
		e.setEid(Integer.parseInt(request.getParameter("eid")));
		re.setE(e);
		
		boolean result = false;
		
		if(re.getReid()!=null) {
			result = reinformationBiz.modify(re);
		}else {
			result = reinformationBiz.add(re);
		}
		
		if(result) {
			//request.setAttribute("msg", "添加成功");
			request.getRequestDispatcher("/addReinformation.jsp").forward(request, response);
		}else {
			//request.setAttribute("msg", "添加失败");
			request.getRequestDispatcher("/addReinformation.jsp").forward(request, response);
		}
//		  if(request.getParameter("reid")!=null) {
//		  id=Integer.parseInt(request.getParameter("reid")); }
		 
		
		//Reinformation reinformation = reinformationBiz.findById(id);
		//request.setAttribute("reinformation", reinformation);
		//request.getRequestDispatcher("").forward(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
