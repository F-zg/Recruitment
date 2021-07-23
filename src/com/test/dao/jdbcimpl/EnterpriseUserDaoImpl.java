package com.test.dao.jdbcimpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.test.dao.EnterpriseUserDao;
import com.test.domain.po.EnterpriseUser;


public class EnterpriseUserDaoImpl extends GenericBaseDao implements EnterpriseUserDao {

	@Override
	public EnterpriseUser findById(Integer id) {
		EnterpriseUser enterpriseUser=null;
		try {
			this.getConnection();
			String sql="select * from  enterpriseuser where euid=?";
			this.executeQuery(sql, id);
			if (rs != null && rs.next()) {
				enterpriseUser = new EnterpriseUser(
	           rs.getInt("euid"),rs.getString("euname")
	           ,rs.getString("eupassword"),rs.getInt("eid"));
			}
			this.closeAll();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return enterpriseUser;
	}
   @Override
	public EnterpriseUser findByName(String  euname) {
		EnterpriseUser enterpriseUser=null;
		try {
			this.getConnection();
			String sql="select * from  enterpriseuser where euname=?";
			this.executeQuery(sql, euname);
			if (rs != null && rs.next()) {
				enterpriseUser = new EnterpriseUser(
	           rs.getInt("euid"),rs.getString("euname")
	           ,rs.getString("eupassword"),rs.getInt("eid"));
			}
			this.closeAll();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return enterpriseUser;
	}
	
	@Override
	public List<EnterpriseUser> findAll() {
	   List<EnterpriseUser> list=null;
	   try {
		   this.getConnection();
		   String sql="select * from enterpriseuser";
		   this.executeQuery(sql);
		   if(rs!=null) {
			   list=new ArrayList<EnterpriseUser>();
			   while(rs.next()) {
				EnterpriseUser  enterpriseUser = new EnterpriseUser(
				           rs.getInt("euid"),rs.getString("euname")
				           ,rs.getString("eupassword"),rs.getInt("eid"));
				list.add(enterpriseUser);		
			        }
			   }
		   this.closeAll();
		   }catch (SQLException e) {
			e.printStackTrace();
			return  null;
		}
	   return list;
	}

	@Override
	public List<EnterpriseUser> findBySQL(String sql, Object... params) {
		 List<EnterpriseUser> list=null;
		   try {
			   this.getConnection();
			   this.executeQuery(sql,params);
			   if(rs!=null) {
				   list=new ArrayList<EnterpriseUser>();
				   while(rs.next()) {
					EnterpriseUser  enterpriseUser = new EnterpriseUser(
					           rs.getInt("euid"),rs.getString("euname")
					           ,rs.getString("eupassword"),rs.getInt("eid"));
					list.add(enterpriseUser);		
				        }
				   }
			   this.closeAll();
			   }catch (SQLException e) {
				e.printStackTrace();
				return  null;
			}
		   return list;
	}

	@Override
	public int insert(EnterpriseUser entity) {
		int res=-1;
		try {
			this.getConnection();
			String sql="insert into enterpriseuser values(null,?,?,?)";
			this.executeUpdate(sql,entity.getEuname(),entity.getEupassword(),entity.getEid());
			res=result;
			this.closeAll();
		}catch(SQLException e) {
			e.printStackTrace();
			return res;
		}
		return res;
	}

	@Override
	public int delete(EnterpriseUser entity) {
		return this.delete(entity.getEuid());
	}

	@Override
	public int delete(Integer id) {
		int res=-1;
		try {
			this.getConnection();
			String sql="delete from enterpriseuser where euid=?";
			this.executeUpdate(sql,id);
			res=result;
			this.closeAll();
		}catch(SQLException e) {
			e.printStackTrace();
			return res;
		}
		return res;
	}

	@Override
	public int update(EnterpriseUser entity) {
		int res=-1;
		try {
			this.getConnection();
			String sql="update enterpriseuser set euname=?,eupassword=?,eid=?";
			this.executeUpdate(sql, entity.getEuname(),entity.getEupassword(),entity.getEid());
			res=result;
			this.closeAll();
		}catch (SQLException e) {
		e.printStackTrace();
		return res;
		}
		return res;
	}

}
