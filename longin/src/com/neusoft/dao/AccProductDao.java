package com.neusoft.dao;

import java.util.List;

import com.neusoft.entity.AccProduct;
import com.neusoft.entity.PageModel;

public interface AccProductDao {
		//查询全部会员
		public List<AccProduct> getAccProductList();
		//添加买家
		public boolean addAccProduct(AccProduct accProduct) throws DaoException;
		//删除买家
		public boolean deleteAccProduct(Integer id) throws DaoException;
		//修改买家
		public boolean updateAccProduct(AccProduct accProduct) throws DaoException;
		//查询买家
		public AccProduct getAccProduct(Integer id) throws DaoException;
		//分页
		public PageModel<AccProduct> getPageModel(int pageNo,int pageSize) throws DaoException;
}
