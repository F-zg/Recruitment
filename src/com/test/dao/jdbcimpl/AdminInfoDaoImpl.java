package com.test.dao.jdbcimpl;

import java.sql.SQLException;
import java.util.List;

import com.test.dao.AdminInfoDao;
import com.test.domain.po.AdminInfo;

public class AdminInfoDaoImpl extends GenericBaseDao implements AdminInfoDao {

	@Override
	public AdminInfo findById(Integer id) {
		return null;
	}

	@Override
	public List<AdminInfo> findAll() {
		return null;
	}

	@Override
	public List<AdminInfo> findBySQL(String sql, Object... params) {
		return null;
	}

	@Override
	public int insert(AdminInfo entity) {
		return 0;
	}

	@Override
	public int delete(AdminInfo entity) {
		return 0;
	}

	@Override
	public int delete(Integer id) {
		return 0;
	}

	@Override
	public int update(AdminInfo entity) {
		return 0;
	}

	@Override
	public int update(int userId) {
		return 0;
	}

	@Override
	public int findUserByUsernameAndUseerPassword(AdminInfo adminInfo) {
		String adminname=adminInfo.getAdminname();
		String adminpassword=adminInfo.getAdminpassword();
		if(adminname==null||adminpassword==null) {
			return 0;
		}
		try {
			//1.获取连接
			this.getConnection();
			 //2.定义sql
			 String sql="select * from admininfo where adminname='"+adminname+"'and adminpassword='"+adminpassword+"' ";
			 this.executeQuery(sql);
			 if(rs!=null&&rs.next()) {
				 return 1;
			 }
			 this.closeAll();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
		return 0;	
	}

}
