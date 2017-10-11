package com.neusoft.services;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.dao.DaoException;
import com.neusoft.dao.DaoFactory;
import com.neusoft.dao.ProductDao;
import com.neusoft.dao.impl.ProductDaoImpl;
import com.neusoft.entity.PageModel;
import com.neusoft.entity.Product;
import com.neusoft.utils.DbUtil;

	public class ProductSerice {
		ProductDao pd=DbUtil.getInstance("proDao", ProductDaoImpl.class);
	//�����Ʒ
	public boolean addProduct(Product product){
	     return pd.addProduct(product);
	}
	//�����Ʒҵ���߼�
	public void addProductLogin(HttpServletRequest request,HttpServletResponse response) throws DaoException,IOException,ServletException{
		
		String pname = request.getParameter("pname"); //��Ʒ����
		String pno = request.getParameter("pno"); //��Ʒ����
		
	//	System.out.println(request.getParameter("price")); 
		String _pic=request.getParameter("picture");
		String pic="img/"+_pic;
		System.out.println(pic);
		
		Double price =Double.parseDouble(request.getParameter("price")); //��Ʒ�۸� 
		boolean shangxia  = Boolean.parseBoolean(request.getParameter("picon1")) ; //�ϼ��¼�
		int online = 0;
		if(shangxia){
			online = 1;
		}
		String pdetail = request.getParameter("pdetail");
	
	//	System.out.println(new Product(pname, 101, pno, "idsj", price, online, pcontent).toString());
		Product product=new Product(pname,101, pno,pic, price, online, pdetail);
		boolean flag=pd.addProduct(product);
		if(flag){
			request.getRequestDispatcher("ProductServlet").forward(request, response);
		}
	}
	//��ѯ��Ʒ
	public PageModel<Product> getProductByPage(int pageNo,int pageSize){
		return pd.getPageModel(pageNo, pageSize);
	}
	//��ѯҵ���߼�
	public void getProductLogin(HttpServletRequest request,HttpServletResponse response) throws DaoException,IOException,ServletException{
		
		String pageNo=request.getParameter("pageNo");
		String pageSize=request.getParameter("pageSize");
		System.out.println(pageNo);
		int _pageNo=Integer.parseInt(pageNo);
		int _pageSize=Integer.parseInt(pageSize);
	//	int _pageNo=1;
	//	int _pageSize=5; 
	
		PageModel<Product> products=getProductByPage(_pageNo, _pageSize);
		if(products!=null){
			int totalPageSize=(products.getTotalcount()%_pageSize==0 ? products.getTotalcount()/_pageSize : products.getTotalcount()/_pageSize+1);
			products.setTotalPageSize(totalPageSize);
			products.setPageNo(_pageNo);
		}
		request.setAttribute("products", products);
		try {
			request.getRequestDispatcher("productmanager.jsp").forward(request, response);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	
	}
	//��ѯȫ����Ʒ
	public List<Product> getProductList(){
		List<Product>products=pd.getProductList();
		if(products.size()>0){
			return products;
		}
		return null;
	}
	//ɾ����Ʒ
	public boolean deleteProduct(Integer id){
		return pd.deleteProduct(id);
	}
	//����ɾ����Ʒ�߼�
	public void deleteProductLogin(HttpServletRequest request,HttpServletResponse response) throws DaoException,IOException,ServletException{
		
		String[] productId=request.getParameterValues("delid");
		
	//	System.out.println(productId[0].trim());
		if(productId.length>0){
			//��ȡҪɾ������Ʒ���
	        pd.deleteProductList(productId);
	        List<Product> productList=pd.getProductList();
	        request.setAttribute("productList", productList);
	        request.getRequestDispatcher("ProductServlet").forward(request, response);
		}else{
			request.getRequestDispatcher("ProductServlet").forward(request, response);
		}
	}
	
	/**
	 * ��ʾreqType=2
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void disReqType2(ServletRequest request,ServletResponse response) throws ServletException, IOException{
		int _pageNo=1;
		int _pageSize=5;
		PageModel<Product> products=getProductByPage(_pageNo, _pageSize);
		if(products!=null){
			int totalPageSize=(products.getTotalcount()%_pageSize==0 ? products.getTotalcount()/_pageSize : products.getTotalcount()/_pageSize+1);
			products.setTotalPageSize(totalPageSize);
			products.setPageNo(_pageNo);
		}
		request.setAttribute("products", products);
		try {
			request.getRequestDispatcher("productmanager.jsp").forward(request, response);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}
	//�޸�ǰ��ʾ����ѯ����Ʒ��Ϣҵ���߼�
	public void updateProductLogin(HttpServletRequest request,HttpServletResponse response) throws DaoException,IOException,ServletException{
		//1.����id
		Integer id=Integer.parseInt(request.getParameter("id"));		
		//2.����dao����id��ѯ��Ʒ��Ϣ�ķ���
		String pname = request.getParameter("pname"); //��Ʒ����
		String pno = request.getParameter("pno"); //��Ʒ����
	
		String _pic=request.getParameter("picture");
		String pic="img/"+_pic;
		System.out.println(pic);
		
		Double price =Double.parseDouble(request.getParameter("price")); //��Ʒ�۸� 
		boolean shangxia  = Boolean.parseBoolean(request.getParameter("picon1")) ; //�ϼ��¼�
		int online = 0;
		if(shangxia){
			online = 1;
		}
		String pdetail = request.getParameter("pdetail");
	
	//	System.out.println(new Product(pname, 101, pno, "idsj", price, online, pcontent).toString());
		Product product=new Product(pname,101, pno,pic, price, online, pdetail);
		pd.getproductById(id);
		//3.����Ʒ��ʾ���������
//		request.getRequestDispatcher("ProductServlet").forward(request, response);
	}
	public Product getproductById(Integer id){
		return pd.getproductById(id);
	}
	
	public boolean updateProduct(Product product){
		
		boolean b = pd.updateProduct(product);
		if(b){
			return true;
		}
		return false;
		
	   }
}
