package com.test.dao.jdbcimpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.test.dao.EnterpriseInfoDao;
import com.test.domain.po.EnterpriseInfo;
import com.test.domain.vo.Page;
import com.test.utils.PageUtil;

public class EnterpriseInfoDaoImpl extends GenericBaseDao implements EnterpriseInfoDao {

	@Override
	public EnterpriseInfo findById(Integer id) {
		EnterpriseInfo ennEnterpriseInfo = null;
		try {
			this.getConnection();
			String sql = "select * from enterpriseinfo where eid = ?";
			this.executeQuery(sql, id);
			if (rs != null && rs.next()) {
				ennEnterpriseInfo = new EnterpriseInfo(rs.getInt("eid"), rs.getString("ename"), rs.getString("eintro"),
						rs.getString("intustry"));
			}
			this.closeAll();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

		return ennEnterpriseInfo;
	}

	@Override
	public List<EnterpriseInfo> findAll() {
		List<EnterpriseInfo> enterpriseInfos = null;
		try {
			this.getConnection();
			String sql = "select * from enterpriseinfo";
			this.executeQuery(sql);
			if (rs != null) {
				enterpriseInfos = new ArrayList<EnterpriseInfo>();
				while (rs.next()) {
					EnterpriseInfo userInfo = new EnterpriseInfo(rs.getInt("eid"), rs.getString("ename"),
							rs.getString("eintro"), rs.getString("intustry"));
					enterpriseInfos.add(userInfo);
				}
			}
			this.closeAll();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return enterpriseInfos;
	}

	@Override
	public List<EnterpriseInfo> findBySQL(String sql, Object... params) {
		List<EnterpriseInfo> enterpriseInfos = null;
		try {
			this.getConnection();
			this.executeQuery(sql, params);
			if (rs != null) {
				enterpriseInfos = new ArrayList<EnterpriseInfo>();
				while (rs.next()) {
					EnterpriseInfo enterpriseInfo = new EnterpriseInfo(rs.getInt("eid"), rs.getString("ename"),
							rs.getString("eintro"), rs.getString("intustry"));
					enterpriseInfos.add(enterpriseInfo);
				}
			}
			this.closeAll();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return enterpriseInfos;
	}

	@Override
	public int insert(EnterpriseInfo entity) {
		int res = -1;
		try {
			this.getConnection();
			String sql = "insert into enterpriseinfo values(null,?, ?, ?) ";

			this.executeUpdate(sql, entity.getEname(), entity.getEintro(), entity.getIntustry());
			res = result;
			this.closeAll();
		} catch (SQLException e) {
			e.printStackTrace();
			return res;
		}

		return res;
	}

	@Override
	public int delete(EnterpriseInfo entity) {
		return this.delete(entity.getEid());

	}

	@Override
	public int delete(Integer id) {
		int res = -1;
		try {
			this.getConnection();
			String sql = "delete from enterpriseinfo where eid = ?";
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
	public int update(EnterpriseInfo entity) {
		int res = -1;
		System.out.println("entity's eid " + entity.getEid());
		try {
			this.getConnection();
			String sql = "update enterpriseinfo set ename = ?, eintro = ?, intustry = ? where eid = ?";
			this.executeUpdate(sql, entity.getEname(), entity.getEintro(), entity.getIntustry(), entity.getEid());
			res = result;
			this.closeAll();
		} catch (SQLException e) {
			e.printStackTrace();
			return res;
		}
		System.out.println("update鐨勭粨鏋滄槸" + res);
		return res;
	}

	private int getTotalRows(String sql) {
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
	public Page selectEnterpriseinfoByPage(int currentPage) {
		Page page = new Page();
		String sql = "select count(*) from enterpriseinfo";
		int totalRows = this.getTotalRows(sql);
		page.setTotalRows(totalRows);
		// 娉ㄦ剰锛屾澶勫簲璇ユ敼涓猴細
		// page.setCurrentPage(PageUtil.pagesie); // 鏆傛椂缁欏嚭璧嬪�煎舰寮忥紝搴旇浠庨厤缃枃浠朵腑璇诲叆
		page.setPageSize(PageUtil.pagesize);
		int totalPages = (int) Math.ceil(page.getTotalRows() * 1.0 / page.getPageSize());
		page.setTotalPages(totalPages);
		page.setCurrentPage(currentPage);
		// 绠楀叾瀹炶褰曚綅缃�
		int beginPos = (page.getCurrentPage() - 1) * page.getPageSize();
		String sql02 = "select * from enterpriseinfo limit " + beginPos + ", " + page.getPageSize();
		List<Object> list = new ArrayList<>();

		try {
			this.executeQuery(sql02);
			// 閬嶅巻rs 鏀惧叆 page data list
			EnterpriseInfo enterpriseInfo = null;
			while (rs.next()) {
				int eid = rs.getInt("eid");
				String ename = rs.getString("ename");
				String eintro = rs.getString("eintro");
				String intustry = rs.getString("intustry");
				enterpriseInfo = new EnterpriseInfo(eid, ename, eintro, intustry);
				list.add(enterpriseInfo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		page.setData(list);
		return page;
	}

}
