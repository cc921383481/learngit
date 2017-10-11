package com.neusoft.dao;

import com.neusoft.entity.Account;

/**
 * 登录Dao
 * */
public interface AccountDao {
 
	public Account doLogin(String username,String password) throws DaoException;
	
	/**
	 * 修改登录Ip及时间
	 * */
	
	public boolean update(Account acc)throws DaoException;
	
}
