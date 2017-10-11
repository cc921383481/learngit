package com.neusoft.dao;

import java.util.List;


import com.neusoft.entity.Cate;
import com.neusoft.entity.PageModel;


public interface CateDao {
     
	   //����
		public boolean addcate(Cate ca) ;
		
		//��ѯ
		public Cate getCate(int cid);
		
		public List<Cate> checkCateList();
		
		//�޸�
		public boolean updateCate(Cate ca);
		
		/**
		 * ��ҳ��ѯ��Ʒ����
		 */
		public PageModel<Cate> getPageModel(int pageNo,int pageSize);
		/**
		 * ɾ����Ʒ����
		 */
		public void deleteCate(int cid);
		
		//ɾ������
		public Cate rearchId(int cid);
		//ɾ��������
		public void delRegion(Integer cid);
	
}
