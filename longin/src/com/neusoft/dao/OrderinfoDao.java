package com.neusoft.dao;

import com.neusoft.entity.Orderinfo;
import com.neusoft.entity.PageModel;

public interface OrderinfoDao {
	    //分页查询
		public PageModel<Orderinfo> getPageModel(int pageNo,int pageSize);
		//分页查询订单状态
		public PageModel<Orderinfo> getPageModelStatus(int pageNo, int pageSize,int searchType);
}
