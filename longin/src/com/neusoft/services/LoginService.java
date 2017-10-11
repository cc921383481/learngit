package com.neusoft.services;

import com.neusoft.dao.AccountDao;
import com.neusoft.dao.DaoException;
import com.neusoft.dao.DaoFactory;
import com.neusoft.entity.Account;

/**
 * 业务逻辑层
 * */
public class LoginService {

	
	 /**
	  * 处理登录业务逻辑。
	  * @param username 用户名
	  * @param password 密码
	  * @return true:登录成功 
	  * */
	public Account  doLogin(Account mAccount) {
		
		
		//获取AccountDao的实现类
       AccountDao accDao=DaoFactory.getInstance("accDao");
       Account acc=null;
       try {
    	 //根据用户名、密码查询用户是否存在
   		 acc=accDao.doLogin(mAccount.getUsername(), mAccount.getPassword());
   		 if(acc!=null) {
   			 acc.setLogindate(System.currentTimeMillis());
   			 acc.setIp(mAccount.getIp());
   			 //更新用户最后的登录地址和登录时间
   			 accDao.update(acc);
   		 }
   		  
       }catch(DaoException e) {
    	   e.printStackTrace();
       }
		
	
		return acc;
	}
	
}
