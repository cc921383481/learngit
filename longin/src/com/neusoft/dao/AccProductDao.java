package com.neusoft.dao;

import java.util.List;

import com.neusoft.entity.AccProduct;
import com.neusoft.entity.PageModel;

public interface AccProductDao {
		//��ѯȫ����Ա
		public List<AccProduct> getAccProductList();
		//������
		public boolean addAccProduct(AccProduct accProduct) throws DaoException;
		//ɾ�����
		public boolean deleteAccProduct(Integer id) throws DaoException;
		//�޸����
		public boolean updateAccProduct(AccProduct accProduct) throws DaoException;
		//��ѯ���
		public AccProduct getAccProduct(Integer id) throws DaoException;
		//��ҳ
		public PageModel<AccProduct> getPageModel(int pageNo,int pageSize) throws DaoException;
}
