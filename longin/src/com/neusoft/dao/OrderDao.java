package com.neusoft.dao;

import com.neusoft.entity.PageModel;
import com.neusoft.entity.Product_orderinfo;

public interface OrderDao {
	//分页查询
	public PageModel<Product_orderinfo> getPageModel(int pageNo,int pageSize);
	//分页查询订单状态
	public PageModel<Product_orderinfo> getPageModelStatus(int pageNo, int pageSize,int searchType);
}
