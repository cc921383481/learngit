package com.neusoft.dao;

import com.neusoft.entity.Orderinfo;
import com.neusoft.entity.PageModel;

public interface OrderinfoDao {
	    //��ҳ��ѯ
		public PageModel<Orderinfo> getPageModel(int pageNo,int pageSize);
		//��ҳ��ѯ����״̬
		public PageModel<Orderinfo> getPageModelStatus(int pageNo, int pageSize,int searchType);
}
