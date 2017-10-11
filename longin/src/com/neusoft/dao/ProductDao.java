package com.neusoft.dao;




import java.util.List;

import com.neusoft.entity.PageModel;
import com.neusoft.entity.Product;


public interface ProductDao {
	
	/**
	 * 获取所有商品信息
	 */
	public List<Product> getProductList();
	/**
	 * 添加商品
	 */
	public boolean addProduct(Product product);
	
	/**
	 * 根据id查询商品信息
	 */
	public Product getproductById(Integer id);
	/**
	 * 分页查询商品分类
	 */
	public PageModel<Product> getPageModel(int pageNo,int pageSize);
	/**
	 * 根据商品名称获取商品信息
	 */
	public List<Product> getproductByName(String name);
	
	/**
	 * 修改商品信息
	 * */
	public boolean updateProduct(Product product);
	/**
	 * 删除商品信息根据id
	 */
	public boolean deleteProduct(Integer id);
	
	public void deleteProductList(String[] productId);
}