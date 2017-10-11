package com.neusoft.dao;

import java.util.List;


import com.neusoft.entity.Cate;
import com.neusoft.entity.PageModel;


public interface CateDao {
     
	   //增加
		public boolean addcate(Cate ca) ;
		
		//查询
		public Cate getCate(int cid);
		
		public List<Cate> checkCateList();
		
		//修改
		public boolean updateCate(Cate ca);
		
		/**
		 * 分页查询商品分类
		 */
		public PageModel<Cate> getPageModel(int pageNo,int pageSize);
		/**
		 * 删除商品分类
		 */
		public void deleteCate(int cid);
		
		//删除方法
		public Cate rearchId(int cid);
		//删除主方法
		public void delRegion(Integer cid);
	
}
