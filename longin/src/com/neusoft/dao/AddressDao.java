package com.neusoft.dao;

import java.util.List;

import com.neusoft.entity.Address;
import com.neusoft.entity.PageModel;

public interface AddressDao {
	//查询全部地址
	public List<Address> getAddressList();
	//添加地址
	public boolean addAddress(Address address) throws DaoException;
	//删除地址
	public boolean deleteAddress(int id) throws DaoException;
	//修改地址
	public boolean updateAddress(Address address) throws DaoException;
	//查询地址
	public Address getAddress(Integer id) throws DaoException;
	//分页
	public PageModel<Address> getPageModel(int pageNo,int pageSize) throws DaoException;
	
	//递归 删除
	public Address rearchId(int id);
   //删除主方法
	public void delRegion(Integer id);
}
