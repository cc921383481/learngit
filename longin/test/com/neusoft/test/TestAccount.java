package com.neusoft.test;

import java.util.List;

import com.neusoft.dao.CateDao;
import com.neusoft.dao.DaoFactory;
import com.neusoft.dao.ProductDao;
import com.neusoft.dao.impl.CateDaoImpl;
import com.neusoft.dao.impl.ProductDaoImpl;
import com.neusoft.entity.Cate;
import com.neusoft.entity.PageModel;
import com.neusoft.entity.Product;
import com.neusoft.utils.DbUtil;

public class TestAccount {

	public static void main(String[] args) {
//		testLogin();
//		addMsg();   
//		update();
//		chaxun();
//		delete();
//		testGetPageModelP();
		testGetProductList();
//		testDeleteProduct();
//		updata();
//		AddProduct();
	}
	
//	public static void testLogin() {
//		
//		AccountDao accDao=DaoFactory.getInstance("accDao", AccountDao.class);
//		
//		Account acc=accDao.doLogin("admin", "admin");
//		 if(acc!=null) {
//			 acc.setLogindate(System.currentTimeMillis());
//			 acc.setIp("10.25.151.170");
//			 accDao.update(acc);
//		 }
//		
//		
//		
//	}
	
	//测试商品分页
	public static void testGetPageModelP(){
		ProductDao pd=DbUtil.getInstance("proDao", ProductDaoImpl.class);
		PageModel<Product> pageModel=pd.getPageModel(1, 1);
		System.out.println(pageModel);
		
	}
	
	public static void AddProduct(){
		ProductDao	pcd=DbUtil.getInstance("proDao", ProductDaoImpl.class);
	    Product pdd= new Product("休闲裤", 17, "122", "1", 100, 1, "李宁");
		System.out.println(pcd.addProduct(pdd));
	}
	//查询全部商品
	public static void testGetProductList(){
		ProductDao pd=DbUtil.getInstance("proDao", ProductDaoImpl.class);
		List<Product> productList=pd.getProductList();
		System.out.println(productList);
	}
	//删除商品
	public static void testDeleteProduct(){
		ProductDao pd=DbUtil.getInstance("proDao", ProductDaoImpl.class);
		System.out.println(pd.deleteProduct(11));
	}
	public static void updata(){
		ProductDao pd=DbUtil.getInstance("proDao", ProductDaoImpl.class);
		System.out.println(pd.updateProduct(new Product(15, "wa", 1, "0", "oo", 20.00, 1, "iei")));
	}
		
	}
	

