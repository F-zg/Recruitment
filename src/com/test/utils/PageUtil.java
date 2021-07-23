package com.test.utils;

import java.io.IOException;
import java.util.Properties;

public class PageUtil {
	private static Properties prop = new Properties();
	
	static {
		try {
			prop.load(DBUtil.class.getClassLoader().getResourceAsStream("pageinfo.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static int pagesize = Integer.parseInt(prop.getProperty("pagesize"));
}
