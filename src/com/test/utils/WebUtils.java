package com.test.utils;



public class WebUtils {
	
	//����Ϊ�����࣬��װ���õĺ�����catch����ת���쳣�����ϳ���׳��
	
	/**
     * �ַ���תint
     * @param string ��ת�����ַ���
     * @param defaultValue Ĭ��ֵ
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
