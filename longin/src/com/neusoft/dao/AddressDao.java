package com.neusoft.dao;

import java.util.List;

import com.neusoft.entity.Address;
import com.neusoft.entity.PageModel;

public interface AddressDao {
	//��ѯȫ����ַ
	public List<Address> getAddressList();
	//��ӵ�ַ
	public boolean addAddress(Address address) throws DaoException;
	//ɾ����ַ
	public boolean deleteAddress(int id) throws DaoException;
	//�޸ĵ�ַ
	public boolean updateAddress(Address address) throws DaoException;
	//��ѯ��ַ
	public Address getAddress(Integer id) throws DaoException;
	//��ҳ
	public PageModel<Address> getPageModel(int pageNo,int pageSize) throws DaoException;
	
	//�ݹ� ɾ��
	public Address rearchId(int id);
   //ɾ��������
	public void delRegion(Integer id);
}
