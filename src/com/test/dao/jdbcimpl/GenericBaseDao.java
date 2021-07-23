package com.test.dao.jdbcimpl;

import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.test.utils.DBUtil;

public class GenericBaseDao {
	// 声明数据库配置参数
	private static String driver;
	private static String url;
	private static String usn;
	private static String pwd;
	// 获取上述的DBConfig properties
	static {
		// 获取数据库配置参数
		
		driver = DBUtil.driver;
		url = DBUtil.url;
		usn = DBUtil.usn;
		pwd = DBUtil.pwd;
		
	    /*当DBUtil出现流错误的时候可以这么暂时代替一下
		driver="com.mysql.cj.jdbc.Driver";
		url="jdbc:mysql://localhost:3306/job?serverTimezone=UTC&useSSL=false";
		usn="root";
		pwd="zzs";*/
		// 注册驱动程序
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	// 声明JDBC用到的四大对象
	protected Connection conn;
	protected PreparedStatement pstmt;
	protected ResultSet rs;
	protected int result = -1;
	
	// 所有的异常只做抛出，暂不处理
	// 1. 获取连接
	public void getConnection() throws SQLException {
		conn = DriverManager.getConnection(url, usn, pwd);
	}
	
	// 2. 关闭连接
	public void closeAll() throws SQLException {
		if (conn != null && !conn.isClosed())
			conn.close();
		if (result != -1)
			result = -1;
	}
	
	// 3. 普适的查询
	public void executeQuery(final String sql, final Object... params) throws SQLException {
		pstmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		// 判断可变参数的有无，并根据数量进行参数的设置传入
		if (params != null) {	// 有参数传入，进行参数的设置
			for (int i = 0; i < params.length; i++)
				pstmt.setObject(i+1, params[i]);
		}
		rs = pstmt.executeQuery();
	}
	
	// 4. 普适的增删改
	public void executeUpdate(final String sql, final Object... params) throws SQLException {
		pstmt = conn.prepareStatement(sql);
		// 判断可变参数的有无，并根据数量进行参数的设置传入
		if (params != null) {	// 有参数传入，进行参数的设置
			for (int i = 0; i < params.length; i++)
				pstmt.setObject(i+1, params[i]);
		}
		result = pstmt.executeUpdate();
	}

}
