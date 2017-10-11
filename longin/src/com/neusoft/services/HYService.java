package com.neusoft.services;


import com.neusoft.dao.ConsumerDao;
import com.neusoft.dao.DaoException;
import com.neusoft.dao.DaoFactory;
import com.neusoft.entity.Consumer;

public class HYService {
	public Consumer  doLogin(Consumer mConsumer) {
		ConsumerDao cd=DaoFactory.getInstance("consumerDao");
     Consumer acc=null;
     try {
  	 //根据用户名、密码查询用户是否存在
 		 acc=cd.doLogin(mConsumer.getLoginname(), mConsumer.getPassword());
 		 if(acc!=null) {
 			 acc.setLastlogintime(System.currentTimeMillis());
 			 acc.setId(mConsumer.getId());
 			 //更新用户最后的登录地址和登录时间
 			 cd.update(acc);
 		 }
 		  
     }catch(DaoException e) {
  	   e.printStackTrace();
     }
		
	
		return acc;
}
}