package com.neusoft.dao;




import java.util.List;

import com.neusoft.entity.PageModel;
import com.neusoft.entity.Product;


public interface ProductDao {
	
	/**
	 * ��ȡ������Ʒ��Ϣ
	 */
	public List<Product> getProductList();
	/**
	 * �����Ʒ
	 */
	public boolean addProduct(Product product);
	
	/**
	 * ����id��ѯ��Ʒ��Ϣ
	 */
	public Product getproductById(Integer id);
	/**
	 * ��ҳ��ѯ��Ʒ����
	 */
	public PageModel<Product> getPageModel(int pageNo,int pageSize);
	/**
	 * ������Ʒ���ƻ�ȡ��Ʒ��Ϣ
	 */
	public List<Product> getproductByName(String name);
	
	/**
	 * �޸���Ʒ��Ϣ
	 * */
	public boolean updateProduct(Product product);
	/**
	 * ɾ����Ʒ��Ϣ����id
	 */
	public boolean deleteProduct(Integer id);
	
	public void deleteProductList(String[] productId);
}