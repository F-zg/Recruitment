package com.test.dao.jdbcimpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.test.dao.ResumeDao;
import com.test.domain.po.Resume;

public class ResumeDaoImpl extends GenericBaseDao implements ResumeDao {

	@Override
	public Resume findById(Integer id) {
		Resume resume=null;
		try {
			this.getConnection();
			String sql="select * from resume where rid=?";
			this.executeQuery(sql, id);
			if(rs!=null&&rs.next()) {
				resume=new Resume(rs.getInt("rid"),rs.getString("rcompany"),rs.getString("position")
						,rs.getDate("workStartTime"),rs.getDate("workEndTime"),rs.getBigDecimal("salary")
						,rs.getString("duty"),rs.getString("schoolName"),rs.getString("education"),rs.getString("professional")
						,rs.getDate("entranceTime"),rs.getDate("graduateTime"),rs.getInt("examineState"),rs.getInt("userId"));
						
			}
			this.closeAll();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return resume;
	}
	@Override
	public Resume findByUserId(Integer userId) {
		Resume resume=null;
		try {
			this.getConnection();
			String sql="select *  from resume where userId=?";
			this.executeQuery(sql, userId);
			if(rs!=null&&rs.next()) {
				resume=new Resume(rs.getInt("rid"),rs.getString("rcompany"),rs.getString("position")
						,rs.getDate("workStartTime"),rs.getDate("workEndTime"),rs.getBigDecimal("salary")
						,rs.getString("duty"),rs.getString("schoolName"),rs.getString("education"),rs.getString("professional")
						,rs.getDate("entranceTime"),rs.getDate("graduateTime"),rs.getInt("examineState"),rs.getInt("userId"));
						
			}
			this.closeAll();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return resume;
	}
	@Override
	public List<Resume> findAll() {
		List<Resume> list=null;
		try {
			this.getConnection();
			String sql = "select * from resume";
			this.executeQuery(sql);
			if(rs!=null) {
				list=new ArrayList<Resume>();
				while(rs.next()) {
			Resume	resume=new Resume(rs.getInt("rid"),rs.getString("rcompany"),rs.getString("position")
							,rs.getDate("workStartTime"),rs.getDate("workEndTime"),rs.getBigDecimal("salary")
							,rs.getString("duty"),rs.getString("schoolName"),rs.getString("education"),rs.getString("professional")
							,rs.getDate("entranceTime"),rs.getDate("graduateTime"),rs.getInt("examineState"),rs.getInt("userId"));
				list.add(resume);
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
	public List<Resume> findBySQL(String sql, Object... params) {
		List<Resume> list=null;
		try {
			this.getConnection();
			this.executeQuery(sql,params);
			if(rs!=null) {
				list=new ArrayList<Resume>();
				while(rs.next()) {
			Resume	resume=new Resume(rs.getInt("rid"),rs.getString("rcompany"),rs.getString("position")
							,rs.getDate("workStartTime"),rs.getDate("workEndTime"),rs.getBigDecimal("salary")
							,rs.getString("duty"),rs.getString("schoolName"),rs.getString("education"),rs.getString("professional")
							,rs.getDate("entranceTime"),rs.getDate("graduateTime"),rs.getInt("examineState"),rs.getInt("userId"));
				list.add(resume);
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
	public int insert(Resume entity) {
		int res = -1;
		try {
			this.getConnection();
			String sql = "insert into resume values(null, ?, ?, ?, ?, ?, ?, ?, ?,?,?,?,?,?) ";
			this.executeUpdate(sql, entity.getRcompany(),entity.getPosition(),entity.getWorkStartTime(),entity.getWorkEndTime()
					,entity.getSalary(),entity.getDuty(),entity.getSchoolName(),entity.getEducation(),entity.getProfessional()
					,entity.getEntranceTime(),entity.getGraduateTime(),entity.getExamState(),entity.getUserId());
			res = result;
			this.closeAll();
		} catch (SQLException e) {
			e.printStackTrace();
			return res;
		}
		return res;
	}

	@Override
	public int delete(Resume entity) {
		return this.delete(entity.getUserId());
	}

	@Override
	public int delete(Integer id) {
		int res = -1;
		try {
			this.getConnection();
			String sql = "delete from resume where rid = ?";
			this.executeUpdate(sql, id);
			res = result;
			this.closeAll();
		} catch (SQLException e) {
			e.printStackTrace();
			return res;
		}
		
		return res;
	}

	@Override
	public int update(Resume entity) {
		int res = -1;
		try {
			this.getConnection();
			String sql = "update resume set rcompany=?,position=?,workStartTime=?,workEndTime=?,salary=?,duty=?,schoolName=?"
					+ ",education=?,professional=?,entranceTime=?,graduateTime=?,examineState=?,userId=?";
			this.executeUpdate(sql, entity.getRcompany(),entity.getPosition(),entity.getWorkStartTime(),entity.getWorkEndTime()
					,entity.getSalary(),entity.getDuty(),entity.getSchoolName(),entity.getEducation(),entity.getProfessional()
					,entity.getEntranceTime(),entity.getGraduateTime(),entity.getExamState(),entity.getUserId());
			res = result;
			this.closeAll();
		} catch (SQLException e) {
			e.printStackTrace();
			return res;
		}
		return res;
	}



}
