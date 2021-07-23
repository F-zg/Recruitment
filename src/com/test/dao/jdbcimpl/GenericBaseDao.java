package com.test.dao.jdbcimpl;

import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.test.utils.DBUtil;

public class GenericBaseDao {
	// �������ݿ����ò���
	private static String driver;
	private static String url;
	private static String usn;
	private static String pwd;
	// ��ȡ������DBConfig properties
	static {
		// ��ȡ���ݿ����ò���
		
		driver = DBUtil.driver;
		url = DBUtil.url;
		usn = DBUtil.usn;
		pwd = DBUtil.pwd;
		
	    /*��DBUtil�����������ʱ�������ô��ʱ����һ��
		driver="com.mysql.cj.jdbc.Driver";
		url="jdbc:mysql://localhost:3306/job?serverTimezone=UTC&useSSL=false";
		usn="root";
		pwd="zzs";*/
		// ע����������
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	// ����JDBC�õ����Ĵ����
	protected Connection conn;
	protected PreparedStatement pstmt;
	protected ResultSet rs;
	protected int result = -1;
	
	// ���е��쳣ֻ���׳����ݲ�����
	// 1. ��ȡ����
	public void getConnection() throws SQLException {
		conn = DriverManager.getConnection(url, usn, pwd);
	}
	
	// 2. �ر�����
	public void closeAll() throws SQLException {
		if (conn != null && !conn.isClosed())
			conn.close();
		if (result != -1)
			result = -1;
	}
	
	// 3. ���ʵĲ�ѯ
	public void executeQuery(final String sql, final Object... params) throws SQLException {
		pstmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		// �жϿɱ���������ޣ��������������в��������ô���
		if (params != null) {	// �в������룬���в���������
			for (int i = 0; i < params.length; i++)
				pstmt.setObject(i+1, params[i]);
		}
		rs = pstmt.executeQuery();
	}
	
	// 4. ���ʵ���ɾ��
	public void executeUpdate(final String sql, final Object... params) throws SQLException {
		pstmt = conn.prepareStatement(sql);
		// �жϿɱ���������ޣ��������������в��������ô���
		if (params != null) {	// �в������룬���в���������
			for (int i = 0; i < params.length; i++)
				pstmt.setObject(i+1, params[i]);
		}
		result = pstmt.executeUpdate();
	}

}
