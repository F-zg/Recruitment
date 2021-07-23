package com.test.utils;

import java.io.IOException;

import java.util.Properties;

// �����࣬public static �����Ժͷ���
// ��ȡdbconfig.properties�ļ���db����key�������Ӧ��value
public class DBUtil {
	private static Properties prop = new Properties();
	
	static {
		try {
			prop.load(DBUtil.class.getClassLoader().getResourceAsStream("dbconfig.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String driver = prop.getProperty("driver");
	public static String url = prop.getProperty("url");
	public static String usn = prop.getProperty("usn");
	public static String pwd = prop.getProperty("pwd");
}
