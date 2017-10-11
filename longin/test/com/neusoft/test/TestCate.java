package com.neusoft.test;

import java.util.List;

import com.neusoft.dao.CateDao;
import com.neusoft.dao.ConsumerDao;
import com.neusoft.dao.DaoFactory;
import com.neusoft.dao.OrderinfoDao;
import com.neusoft.dao.impl.CateDaoImpl;
import com.neusoft.dao.impl.ConsumerDaoImpl;
import com.neusoft.dao.impl.OrderinfoDaoImpl;
import com.neusoft.entity.Cate;
import com.neusoft.entity.Consumer;
import com.neusoft.entity.PageModel;
import com.neusoft.utils.DbUtil;



public class TestCate {
     
	public static void main(String[] args) {
//		 addMsg();
//		 chaxun();   
//		 delete();
//		Testupdate();
//		testcheckCateList();
//		dele();
//		testGetPageModel();
		testAddConsumer();
//		testGetConsumerList();
//		testGetPageModelOrder();
	}
	

      public static void addMsg() {
		
	     CateDao cdDao=DaoFactory.getInstance("cdDao");
		
		Cate ca=new Cate("�˶���",103);
		System.out.println(cdDao.addcate(ca));
		}
      public static void  chaxun() {
    	  CateDao   cdDao=DaoFactory.getInstance("cdDao");
  		  System.out.println(cdDao.getCate(2));
  	}
      
      
    public static void Testupdate(){
  	CateDao cd = DaoFactory.getInstance("cdDao");
  	Cate cate=new Cate(2,"�ǵ�",0);
  	cd.updateCate(cate);
  	System.out.println(cd.updateCate(cate));
    } 
    
    public static void testcheckCateList(){
    	CateDao cd = DaoFactory.getInstance("cdDao");
		List<Cate> cateList=cd.checkCateList();
        System.out.println(cateList);
	}
    public static void dele(){
    	CateDao cd = DaoFactory.getInstance("cdDao");
    	cd.delRegion(12);
    }
  //���Է�ҳ
  	public static void testGetPageModel(){
  		CateDao	cd=DbUtil.getInstance("cdDao", CateDaoImpl.class);
  		PageModel<Cate> pageModel=cd.getPageModel(1, 3);
  		System.out.println(pageModel);
  	}
  	
  //������ӻ�Ա
  	public static void testAddConsumer(){
  		ConsumerDao cd=DbUtil.getInstance("consumerDao", ConsumerDaoImpl.class);
  		System.out.println(cd.addConsumer(new Consumer("jsp2","12345",2017,2017,"10.25.151.170")));
  	}
	//���Ի�Ա
	public static void testGetConsumerList(){
		ConsumerDao cd=DbUtil.getInstance("consumerDao", ConsumerDaoImpl.class);
		System.out.println(cd.getConsumerList());
	}
	//���Զ���
	public static void testGetPageModelOrder(){
		OrderinfoDao od=DbUtil.getInstance("orderDao", OrderinfoDaoImpl.class);
		System.out.println(od.getPageModel(1,1));
    
  }
}