package com.test.dao.jdbcimpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.test.dao.UserInfoDao;
import com.test.domain.po.UserInfo;

public class UserInfoDaoImpl extends GenericBaseDao implements UserInfoDao{
	
	/*
	 * 1.������
	 * 2.����sql���
	 * 3.�������ʵĲ�ѯ ��ɾ��
	 * 4-1 ��ѯ����
	 *     ��rs�е����ݷ�װ����Ӧ��ʵ������
	 * 4-2��ɾ�Ĳ���
	 * ��ȡ������result
	 * 5.�ر�����
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
     * �����û�
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
   * ɾ���û�
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
     * �޸���Ϣ
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
 * ��¼�õ�
 */
	@Override
	public int findUserByUsernameAndUseerPassword(UserInfo user) {
		String username=user.getUsername();
		String password=user.getPassword();
		if(username==null||password==null) {
			return 0;
		}
		try {
			//1.��ȡ����
			this.getConnection();
			 //2.����sql
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
			//1.��ȡ����
			this.getConnection();
			 //2.����sql
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
	 * �����û�
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
	 * �ⶳ
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
