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
 * Servlet implementation class ModifyReinformationServlet
 */
@WebServlet("/ModifyReinformationServlet")
public class ModifyReinformationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ReinformationBiz reinformationBiz = new ReinformationBizImpl();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyReinformationServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Reinformation re = new Reinformation();
		EnterpriseInfo e = new EnterpriseInfo();
		
		re.setReid(Integer.parseInt(request.getParameter("reid")));
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
		
		boolean result = reinformationBiz.modify(re);
		
		if(result) {
			//request.setAttribute("msg", "添加成功");
			request.getRequestDispatcher("/addReinformation.jsp").forward(request, response);
		}else {
			//request.setAttribute("msg", "添加失败");
			request.getRequestDispatcher("/addReinformation.jsp").forward(request, response);
		}
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
