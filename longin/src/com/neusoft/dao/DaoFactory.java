package com.neusoft.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DaoFactory {

	/**
	 *  通过读取配置文件，实例化实现类对象
	 */
	
	private static Properties ps = new Properties();
	
	static {
	 InputStream is = 	Thread.currentThread().getContextClassLoader().getResourceAsStream("dao.properties");
	 try {
		ps.load(is);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	/**
	 * 反射实例化对象
	 */
	
	public static <T>  T getInstance(String daoname) {
		T t=null;
		if(daoname==null||"".equals(daoname)) {
			return t;
		}
		
		String className= ps.getProperty(daoname);
		if(className==null||"".equals(className)) {
			return t ;
		}
		try {
			Class<?> clzz= Class.forName(className);
			  t = (T)clzz.newInstance();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t;
	}
}
