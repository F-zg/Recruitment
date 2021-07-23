package com.test.dao.jdbcimpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.test.dao.DeliveryDao;
import com.test.domain.po.Delivery;

public class DeliveryDaoImpl extends GenericBaseDao implements DeliveryDao {

	@Override
	public Delivery findById(Integer id) {
		Delivery delivery=null;
		try {
			this.getConnection();
			String sql="select * from delivery where did=?";
			this.executeQuery(sql, id);
			if(rs!=null&&rs.next()) {
				delivery=new Delivery(rs.getInt("did"),rs.getInt("reid"),rs.getInt("userid"),rs.getInt("state"));
			}
			this.closeAll();
		}catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return delivery;
	}

	@Override
	public List<Delivery> findAll() {
		List<Delivery> list=null;
		try {
			this.getConnection();
			String sql="select * from delivery";
			this.executeQuery(sql);
			if(rs!=null) {
				list=new ArrayList<Delivery>();
				while(rs.next()) {
				Delivery delivery=new Delivery(rs.getInt("did"),rs.getInt("reid"),rs.getInt("userid"),rs.getInt("state"));
				list.add(delivery);
				}
			}
			this.closeAll();
		}catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return list;
	}

	@Override
	public List<Delivery> findBySQL(String sql, Object... params) {
		List<Delivery> list=null;
		try {
			this.getConnection();
			this.executeQuery(sql,params);
			if(rs!=null) {
				list=new ArrayList<Delivery>();
				while(rs.next()) {
				Delivery delivery=new Delivery(rs.getInt("did"),rs.getInt("reid"),rs.getInt("userid"),rs.getInt("state"));
				list.add(delivery);
				}
			}
			this.closeAll();
		}catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return list;
	}

	@Override
	public int insert(Delivery entity) {
		int res=-1;
		try {
			this.getConnection();
			String sql="insert into delivery values(null,?,?,?)";
			this.executeUpdate(sql, entity.getReid(),entity.getUserid(),entity.getState());
			res=result;
		}catch (SQLException e) {
		e.printStackTrace();
		return res;
		}
		return res;
	}

	@Override
	public int delete(Delivery entity) {
		return this.delete(entity.getDid());
	}

	@Override
	public int delete(Integer id) {
		int res=-1;
		try {
			this.getConnection();
			String sql="delete from delivery where did=?";
			this.executeUpdate(sql, id);
			res=result;
		}catch (SQLException e) {
		e.printStackTrace();
		return res;
		}
		return res;
	}

	@Override
	public int update(Delivery entity) {
		int res=-1;
		try {
			this.getConnection();
			String sql="update  delivery set reid=?,userid=?,state=?";
			this.executeUpdate(sql, entity.getReid(),entity.getUserid(),entity.getState());
			res=result;
		}catch (SQLException e) {
		e.printStackTrace();
		return res;
		}
		return res;
	}

	@Override
	public Delivery findDeliveryByUserId(Integer userid) {
		// TODO Auto-generated method stub
		
		
		Delivery delivery=null;
		try {
			this.getConnection();
			String sql="SELECT * FROM delivery where userid=?";
			this.executeQuery(sql, userid);
			if(rs!=null&&rs.next()) {
				delivery=new Delivery(rs.getInt("did"),rs.getInt("reid"),rs.getInt("userid"),rs.getInt("state"));
			}
			this.closeAll();
		}catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return delivery;
	}

}
