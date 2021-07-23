package com.test.web.controller.Reinformation;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.biz.ReinformationBiz;
import com.test.biz.impl.ReinformationBizImpl;
import com.test.domain.po.Reinformation;

/**
 * Servlet implementation class SearchReinformationServlet2
 */
@WebServlet("/SearchReinformationServlet2")
public class SearchReinformationServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReinformationBiz reinformationBiz = new ReinformationBizImpl();  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchReinformationServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sql = "select r.*, e.* " + 
				" from reinformation r, enterpriseinfo e " + 
				" where r.eid = e.eid and ";
		
		//只会从一个分类中搜索，所以用if...else if...进行判断
		if(request.getParameter("cat").equals("rePositionName")) {
			sql+="r.rePositionName like '%"+request.getParameter("va")+"%'";
		}else if(request.getParameter("cat").equals("reSalary")) {
			sql+="r.reSalary like '%"+request.getParameter("va")+"%'";
		}else if(request.getParameter("cat").equals("reCity")) {
			sql+="r.reCity like '%"+request.getParameter("va")+"%'";
		}else if(request.getParameter("cat").equals("reWorkYears")) {
			sql+="r.reWorkYears like '%"+request.getParameter("va")+"%'";
		}else if(request.getParameter("cat").equals("reEducation")) {
			sql+="r.reEducation like '%"+request.getParameter("va")+"%'";
		}else if(request.getParameter("cat").equals("rePersonNum")) {
			sql+="r.rePersonNum like '%"+request.getParameter("va")+"%'";
		}else if(request.getParameter("cat").equals("reLightPoint")) {
			sql+="r.reLightPoint like '%"+request.getParameter("va")+"%'";
		}else if(request.getParameter("cat").equals("reJobDesc")) {
			sql+="r.reJobDesc like '%"+request.getParameter("va")+"%'";
		}else if(request.getParameter("cat").equals("reDepartment")) {
			sql+="r.reDepartment like '%"+request.getParameter("va")+"%'";
		}else if(request.getParameter("cat").equals("reProfessional")) {
			sql+="r.reProfessional like '%"+request.getParameter("va")+"%'";
		}else if(request.getParameter("cat").equals("ename")) {
			sql+="e.ename like '%"+request.getParameter("va")+"%'";
		}
		
		
		
//		  if(request.getParameter("reid")!=null) {
//		  sql+="r.reid = "+request.getParameter("reid"); }else
//		  if(request.getParameter("rePositionName")!=null) {
//		  sql+="r.rePositionName = "+request.getParameter("rePositionName"); }else
//		  if(request.getParameter("reSalary")!=null) {
//		  sql+="r.reSalary = "+request.getParameter("reSalary"); }else
//		  if(request.getParameter("reCity")!=null) {
//		  sql+="r.reCity = "+request.getParameter("reCity"); }else
//		  if(request.getParameter("reArea")!=null) {
//		  sql+="r.reArea = "+request.getParameter("reArea"); }else
//		  if(request.getParameter("reWorkYears")!=null) {
//		  sql+="r.reWorkYears = "+request.getParameter("reWorkYears"); }else
//		  if(request.getParameter("reEducation")!=null) {
//		  sql+="r.reEducation = "+request.getParameter("reEducation"); }else
//		  if(request.getParameter("rePersonNum")!=null) {
//		  sql+="r.rePersonNum = "+request.getParameter("rePersonNum"); }else
//		  if(request.getParameter("reLightPoint")!=null) {
//		  sql+="r.reLightPoint = "+request.getParameter("reLightPoint"); }else
//		  if(request.getParameter("reJobDesc")!=null) {
//		  sql+="r.reJobDesc = "+request.getParameter("reJobDesc"); }else
//		  if(request.getParameter("reDepartment")!=null) {
//		  sql+="r.reDepartment = "+request.getParameter("reDepartment"); }else
//		  if(request.getParameter("reProfessional")!=null) {
//		  sql+="r.reProfessional = "+request.getParameter("reProfessional"); }else
//		  if(request.getParameter("reReportPerson")!=null) {
//		  sql+="r.reReportPerson = "+request.getParameter("reReportPerson"); }else
//		  if(request.getParameter("reSubordinates")!=null) {
//		  sql+="r.reSubordinates = "+request.getParameter("reSubordinates"); }else
//		  if(request.getParameter("eid")!=null) {
//		  sql+="e.eid = "+request.getParameter("eid"); }else
//		  if(request.getParameter("ename")!=null) {
//		  sql+="e.ename = "+request.getParameter("ename"); }else
//		  if(request.getParameter("eintro")!=null) {
//		  sql+="e.eintro = "+request.getParameter("eintro"); }else
//		  if(request.getParameter("intustry")!=null) {
//		  sql+="e.intustry = "+request.getParameter("intustry"); }
		 
		
		List<Reinformation> list = reinformationBiz.selectBySQL(sql);
		request.setAttribute("Reinformationlist", list);
		request.getRequestDispatcher("/showAllReinformationForUser.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
