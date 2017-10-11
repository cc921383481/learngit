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
  	 //�����û����������ѯ�û��Ƿ����
 		 acc=cd.doLogin(mConsumer.getLoginname(), mConsumer.getPassword());
 		 if(acc!=null) {
 			 acc.setLastlogintime(System.currentTimeMillis());
 			 acc.setId(mConsumer.getId());
 			 //�����û����ĵ�¼��ַ�͵�¼ʱ��
 			 cd.update(acc);
 		 }
 		  
     }catch(DaoException e) {
  	   e.printStackTrace();
     }
		
	
		return acc;
}
}