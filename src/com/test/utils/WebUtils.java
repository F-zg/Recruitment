package com.test.utils;



public class WebUtils {
	
	//该类为工具类，封装常用的函数，catch类型转换异常，保障程序健壮性
	
	/**
     * 字符串转int
     * @param string 被转换的字符串
     * @param defaultValue 默认值
     * @return int
     */
    public static int parseInt(String string,int defaultValue){
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            //e.printStackTrace();
        }
        return defaultValue;
    }
    

}
