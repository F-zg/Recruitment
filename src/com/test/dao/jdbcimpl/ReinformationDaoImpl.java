package com.test.dao.jdbcimpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.test.dao.ReinformationDao;
import com.test.domain.po.EnterpriseInfo;
import com.test.domain.po.Reinformation;
import com.test.domain.vo.Page;
import com.test.utils.PageUtil;

// 锟斤拷应锟斤拷实锟斤拷锟斤拷锟叫猴拷锟叫癸拷锟斤拷锟斤拷实锟斤拷锟斤拷锟斤拷锟斤拷锟�
public class ReinformationDaoImpl extends GenericBaseDao implements ReinformationDao {

	@Override
	public Reinformation findById(Integer id) {
		Reinformation reinformation = null;
		try {
			this.getConnection();
			String sql = "select r.*, e.* " + 
					" from reinformation r, enterpriseinfo e " + 
					" where r.eid = e.eid and r.reid = ?";			
			this.executeQuery(sql, id);
			if (rs != null & rs.next()) {
				reinformation = new Reinformation();
				reinformation.setReid(rs.getInt(1));
				reinformation.setRePositionName(rs.getString(2));
				reinformation.setReSalary(rs.getString(3));
				reinformation.setReCity(rs.getString(4));
				reinformation.setReArea(rs.getString(5));;
				reinformation.setReWorkYears(rs.getString(6));
				reinformation.setReEducation(rs.getString(7));
				reinformation.setRePersonNum(rs.getInt(8));
				reinformation.setReLightPoint(rs.getString(9));
				reinformation.setReJobDesc(rs.getString(10));;
				reinformation.setReDepartment(rs.getString(11));
				reinformation.setReProfessional(rs.getString(12));
				reinformation.setReReportPerson(rs.getString(13));
				reinformation.setReSubordinates(rs.getInt(14));
				EnterpriseInfo e = new EnterpriseInfo();
					e.setEid(rs.getInt(15));
					e.setEname(rs.getString(17));
					e.setEintro(rs.getString(18));
					e.setIntustry(rs.getString(19));
				reinformation.setE(e);
			}
			this.closeAll();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		return reinformation;
	}

	@Override
	public List<Reinformation> findAll() {
		List<Reinformation> list = null;
		try {
			this.getConnection();
			String sql = "select r.*, e.* " + 
					" from reinformation r, enterpriseinfo e where r.eid=e.eid";
			this.executeQuery(sql);
			if(rs!=null) {
				list = new ArrayList<Reinformation>();
				while(rs.next()) {
					Reinformation reinformation = new Reinformation();
					reinformation.setReid(rs.getInt(1));
					reinformation.setRePositionName(rs.getString(2));
					reinformation.setReSalary(rs.getString(3));
					reinformation.setReCity(rs.getString(4));
					reinformation.setReArea(rs.getString(5));
					reinformation.setReWorkYears(rs.getString(6));
					reinformation.setReEducation(rs.getString(7));
					reinformation.setRePersonNum(rs.getInt(8));
					reinformation.setReLightPoint(rs.getString(9));
					reinformation.setReJobDesc(rs.getString(10));;
					reinformation.setReDepartment(rs.getString(11));
					reinformation.setReProfessional(rs.getString(12));
					reinformation.setReReportPerson(rs.getString(13));
					reinformation.setReSubordinates(rs.getInt(14));
					EnterpriseInfo e = new EnterpriseInfo();
						e.setEid(rs.getInt(15));
						e.setEname(rs.getString(17));
						e.setEintro(rs.getString(18));
						e.setIntustry(rs.getString(19));
					reinformation.setE(e);
					list.add(reinformation);
				}
			}
			this.closeAll();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

		return list;
	}

	@Override
	public List<Reinformation> findBySQL(String sql, Object... params) {
		List<Reinformation> list = null;
		try {
			this.getConnection();
			this.executeQuery(sql, params);
			if(rs!=null) {
				list = new ArrayList<Reinformation>();
				while(rs.next()) {
					Reinformation reinformation = new Reinformation();
					reinformation.setReid(rs.getInt(1));
					reinformation.setRePositionName(rs.getString(2));
					reinformation.setReSalary(rs.getString(3));
					reinformation.setReCity(rs.getString(4));
					reinformation.setReArea(rs.getString(5));;
					reinformation.setReWorkYears(rs.getString(6));
					reinformation.setReEducation(rs.getString(7));
					reinformation.setRePersonNum(rs.getInt(8));
					reinformation.setReLightPoint(rs.getString(9));
					reinformation.setReJobDesc(rs.getString(10));;
					reinformation.setReDepartment(rs.getString(11));
					reinformation.setReProfessional(rs.getString(12));
					reinformation.setReReportPerson(rs.getString(13));
					reinformation.setReSubordinates(rs.getInt(14));
					EnterpriseInfo e = new EnterpriseInfo();
						e.setEid(rs.getInt(15));
						e.setEname(rs.getString(17));
						e.setEintro(rs.getString(18));
						e.setIntustry(rs.getString(19));
					reinformation.setE(e);
					list.add(reinformation);
				}
			}
			this.closeAll();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return list;
	}

	@Override
	public int insert(Reinformation entity) {
		//entity.getE().getEid()
		int res = -1;
		try {
			this.getConnection();
			String sql = "insert into reinformation values(null,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			this.executeUpdate(sql, entity.getRePositionName(), entity.getReSalary(), entity.getReCity()
					, entity.getReArea(), entity.getReWorkYears(), entity.getReEducation()
					, entity.getRePersonNum(), entity.getReLightPoint(), entity.getReJobDesc()
					, entity.getReDepartment(), entity.getReProfessional(), entity.getReReportPerson()
					, entity.getReSubordinates(), entity.getE().getEid());
			
//			sql = "select * from enterpriseinfo where ename = ?";
//			this.executeQuery(sql, entity.getE().getEname());
//			if(rs==null) {
//				sql = "insert into enterpriseinfo values(null,?,?,?,?)";
//				this.executeUpdate(sql,entity.getE().getEname(),entity.getE().getEintro(),entity.getE().getE);
//			}
			
			res=result;
			this.closeAll();
		} catch (SQLException e) {
			e.printStackTrace();
			return res;
		}
		
		return res;
	}

	@Override
	public int delete(Reinformation entity) {
		return this.delete(entity.getReid());
	}

	@Override
	public int delete(Integer id) {
		int res = -1;
		try {
			this.getConnection();
			String sql = "delete from reinformation where reid = ?";
			this.executeUpdate(sql,id);
			res=result;
			this.closeAll();
		} catch (SQLException e) {
			e.printStackTrace();
			return res;
		}
		
		return res;
	}

	@Override
	public int update(Reinformation entity) {
		int res = -1;
		try {
			this.getConnection();
			String sql = "update  reinformation set rePositionName = ?, reSalary = ?"
					+", reCity = ?, reArea = ?, reWorkYears = ?, reEducation = ?, rePersonNum = ?"
					+", reLightPoint = ?, reJobDesc = ?, reDepartment = ?, reProfessional = ?"
					+", reReportPerson = ?, reSubordinates = ?, eid = ? where reid = ?";
			this.executeUpdate(sql,entity.getRePositionName(), entity.getReSalary(), entity.getReCity()
					, entity.getReArea(), entity.getReWorkYears(), entity.getReEducation()
					, entity.getRePersonNum(), entity.getReLightPoint(), entity.getReJobDesc()
					, entity.getReDepartment(), entity.getReProfessional(), entity.getReReportPerson()
					, entity.getReSubordinates(), entity.getE().getEid(),entity.getReid());
			res=result;
			this.closeAll();
		} catch (SQLException e) {
			e.printStackTrace();
			return res;
		}
		
		return res;
	}

	@Override
	public int getTotalRows(String sql) {
		// sql : select count(*) from xxtable [where ....]
		try {
			this.getConnection();
			this.executeQuery(sql);
			if (rs != null && rs.next())
				return rs.getInt(1);
			this.closeAll();
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
		
		return -1;
	}

	@Override
	public Page findByPage(int currentPage) {
		Page page = new Page();
		String sql = "select count(*) from reinformation";
		int totalRows = this.getTotalRows(sql);
		page.setTotalRows(totalRows);
		// 注锟解，锟剿达拷应锟矫革拷为锟斤拷
		//page.setCurrentPage(PageUtil.pagesie);		// 锟斤拷时锟斤拷锟斤拷锟斤拷值锟斤拷式锟斤拷应锟矫达拷锟斤拷锟斤拷锟侥硷拷锟叫讹拷锟斤拷
		page.setPageSize(PageUtil.pagesize);
		int totalPages = (int) Math.ceil(page.getTotalRows() * 1.0 / page.getPageSize());
		page.setTotalPages(totalPages);
		page.setCurrentPage(currentPage);
		// 锟斤拷锟斤拷实锟斤拷录位锟斤拷
		int beginPos = (page.getCurrentPage()-1)*page.getPageSize();
		String sql02 = "select * from reinformation limit " + beginPos + ", " + page.getPageSize();
		try {
			this.executeQuery(sql02);
			// 锟斤拷锟斤拷rs 锟斤拷锟斤拷 page data list
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return page;
	}

}
