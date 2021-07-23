package com.test.dao.jdbcimpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.test.dao.UserInfoDao;
import com.test.domain.po.UserInfo;

public class UserInfoDaoImpl extends GenericBaseDao implements UserInfoDao{
	
	/*
	 * 1.打开连接
	 * 2.生成sql语句
	 * 3.调用普适的查询 增删改
	 * 4-1 查询操作
	 *     将rs中的数据封装到对应的实体类中
	 * 4-2增删改操作
	 * 获取并返回result
	 * 5.关闭连接
	 */
	
	@Override
	public UserInfo findById(Integer userid) {		
		UserInfo userinfo=null;
		try {
			this.getConnection();
			String sql="select * from userinfo where userId=?";
			this.executeQuery(sql, userid);
			if(rs!=null&&rs.next()) {
				userinfo =new UserInfo( rs.getInt("userId"), rs.getString("username"), rs.getString("password")
						, rs.getDate("borndate"), rs.getString("gender"), rs.getString("city")
						, rs.getString("telephone"), rs.getString("email"), rs.getString("address"),rs.getInt("state"));
				return userinfo;
			}
			this.closeAll();
		} catch (SQLException e) {	
			e.printStackTrace();
			return null;
		}		
		return null;
	}

	@Override
	public List<UserInfo> findAll() {
		List<UserInfo>userinfos=null;
		try {
			this.getConnection();
			String sql="select * from userinfo";
			this.executeQuery(sql);
			if(rs!=null) {
				userinfos=new ArrayList<UserInfo>();
				while(rs.next()){
					UserInfo userinfo=new UserInfo(rs.getInt("userId"), rs.getString("username"), rs.getString("password")
							, rs.getDate("borndate"), rs.getString("gender"), rs.getString("city")
							, rs.getString("telephone"), rs.getString("email"), rs.getString("address"),rs.getInt("state"));
					userinfos.add(userinfo);
				}
			}
			this.closeAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return userinfos;
	}

	@Override
	public List<UserInfo> findBySQL(String sql, Object... params) {
		List<UserInfo> userInfos = null;
		try {
			this.getConnection();
			this.executeQuery(sql, params);
			if (rs!=null) {
				userInfos = new ArrayList<UserInfo>();
				while(rs.next()){
					UserInfo userInfo = new UserInfo(
						rs.getInt("userId"), rs.getString("username"), rs.getString("password")
						, rs.getDate("borndate"), rs.getString("gender"), rs.getString("city")
						, rs.getString("telephone"), rs.getString("email"), rs.getString("address"),rs.getInt("state"));
					userInfos.add(userInfo);
				}
			}
			this.closeAll();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return userInfos;
	}
    /*
     * 插入用户
     */
	@Override
	public int insert(UserInfo entity) {
		int res=-1;
		try {
			this.getConnection();
			String sql="insert into userinfo values(null, ?, ?, ?, ?, ?, ?, ?, ?,?)";
			this.executeUpdate(sql, entity.getUsername(), entity.getPassword(), entity.getBorndate(),
					entity.getGender(), entity.getCity(), entity.getTelephone(), entity.getEmail()
					, entity.getAddress(),entity.getState());
			res=result;
			this.closeAll();
		} catch (SQLException e) {
			e.printStackTrace();
			return res;
		}
		return res;
	}

	@Override
	public int delete(UserInfo entity) {
		return this.delete(entity.getUserId());
	}
	
  /*
   * 删除用户
   */
	@Override
	public int delete(Integer id) {
		int res=-1;
		try {
			this.getConnection();
			String sql="delete from userinfo where userId=?";
			this.executeUpdate(sql, id);
			res=result;
			this.closeAll();
		} catch (SQLException e) {
			
			e.printStackTrace();
			return res;
		}
		return res;
	}
    /*
     * 修改信息
     */
	@Override
	public int update(UserInfo entity) {
		int res = -1;
		try {
			this.getConnection();
			String sql = "update userinfo set username = ?, password = ?, borndate = ?, gender = ?"
					+ ", city = ?, telephone = ?, email = ?, address = ? where userId = ?";
			this.executeUpdate(sql, entity.getUsername(), entity.getPassword(), entity.getBorndate()
					, entity.getGender(), entity.getCity(), entity.getTelephone(), entity.getEmail()
					, entity.getAddress(), entity.getUserId());
			res = result;
			this.closeAll();
		} catch (SQLException e) {
			e.printStackTrace();
			return res;
		}		
		return res;
	}
/*
 * 登录用的
 */
	@Override
	public int findUserByUsernameAndUseerPassword(UserInfo user) {
		String username=user.getUsername();
		String password=user.getPassword();
		if(username==null||password==null) {
			return 0;
		}
		try {
			//1.获取连接
			this.getConnection();
			 //2.定义sql
			 String sql="select * from userinfo where username='"+username+"'and password='"+password+"' ";
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
	@Override
	public UserInfo findUser1ByUserNameAndUseerPassword(String username, String password) {
		UserInfo userinfo=null;
		if(username==null||password==null) {
			return null;
		}
		try {
			//1.获取连接
			this.getConnection();
			 //2.定义sql
			 String sql="select * from userinfo where username='"+username+"'and password='"+password+"' ";
			 this.executeQuery(sql);
			 if(rs!=null&&rs.next()) {
				 userinfo =new UserInfo( rs.getInt("userId"), rs.getString("username"), rs.getString("password")
							, rs.getDate("borndate"), rs.getString("gender"), rs.getString("city")
							, rs.getString("telephone"), rs.getString("email"), rs.getString("address"),rs.getInt("state"));
					return userinfo;
			 }
			 this.closeAll();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return null;	
	}
    
	/*
	 * 冻结用户
	 */
	@Override
	public int updatestate(int userId) {
		int res = -1;
		try {
			this.getConnection();
			String sql = "update userinfo set state=0 where userId=?";
			this.executeUpdate(sql,userId);
			res = result;
			this.closeAll();
		} catch (SQLException e) {
			e.printStackTrace();
			return res;
		}		
		return res;
	}
	/*
	 * 解冻
	 */
	@Override
	public int releasestate(int userId) {
		int res = -1;
		try {
			this.getConnection();
			String sql = "update userinfo set state = 1 where userId =?";
			this.executeUpdate(sql,userId);
			res = result;
			this.closeAll();
		} catch (SQLException e) {
			e.printStackTrace();
			return res;
		}		
		return res;
	}

	@Override
	public int update(int userId) {
		// TODO Auto-generated method stub
		return 0;
	}
}
