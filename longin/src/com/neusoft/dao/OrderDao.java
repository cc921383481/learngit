package com.neusoft.dao;

import com.neusoft.entity.PageModel;
import com.neusoft.entity.Product_orderinfo;

public interface OrderDao {
	//��ҳ��ѯ
	public PageModel<Product_orderinfo> getPageModel(int pageNo,int pageSize);
	//��ҳ��ѯ����״̬
	public PageModel<Product_orderinfo> getPageModelStatus(int pageNo, int pageSize,int searchType);
}
