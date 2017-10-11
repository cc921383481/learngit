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
	//添加商品
	public boolean addProduct(Product product){
	     return pd.addProduct(product);
	}
	//添加商品业务逻辑
	public void addProductLogin(HttpServletRequest request,HttpServletResponse response) throws DaoException,IOException,ServletException{
		
		String pname = request.getParameter("pname"); //商品名称
		String pno = request.getParameter("pno"); //商品货号
		
	//	System.out.println(request.getParameter("price")); 
		String _pic=request.getParameter("picture");
		String pic="img/"+_pic;
		System.out.println(pic);
		
		Double price =Double.parseDouble(request.getParameter("price")); //商品价格 
		boolean shangxia  = Boolean.parseBoolean(request.getParameter("picon1")) ; //上架下架
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
	//查询商品
	public PageModel<Product> getProductByPage(int pageNo,int pageSize){
		return pd.getPageModel(pageNo, pageSize);
	}
	//查询业务逻辑
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
	//查询全部商品
	public List<Product> getProductList(){
		List<Product>products=pd.getProductList();
		if(products.size()>0){
			return products;
		}
		return null;
	}
	//删除商品
	public boolean deleteProduct(Integer id){
		return pd.deleteProduct(id);
	}
	//批量删除商品逻辑
	public void deleteProductLogin(HttpServletRequest request,HttpServletResponse response) throws DaoException,IOException,ServletException{
		
		String[] productId=request.getParameterValues("delid");
		
	//	System.out.println(productId[0].trim());
		if(productId.length>0){
			//获取要删除的商品编号
	        pd.deleteProductList(productId);
	        List<Product> productList=pd.getProductList();
	        request.setAttribute("productList", productList);
	        request.getRequestDispatcher("ProductServlet").forward(request, response);
		}else{
			request.getRequestDispatcher("ProductServlet").forward(request, response);
		}
	}
	
	/**
	 * 显示reqType=2
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
	//修改前显示（查询）商品信息业务逻辑
	public void updateProductLogin(HttpServletRequest request,HttpServletResponse response) throws DaoException,IOException,ServletException{
		//1.接收id
		Integer id=Integer.parseInt(request.getParameter("id"));		
		//2.调用dao根据id查询商品信息的方法
		String pname = request.getParameter("pname"); //商品名称
		String pno = request.getParameter("pno"); //商品货号
	
		String _pic=request.getParameter("picture");
		String pic="img/"+_pic;
		System.out.println(pic);
		
		Double price =Double.parseDouble(request.getParameter("price")); //商品价格 
		boolean shangxia  = Boolean.parseBoolean(request.getParameter("picon1")) ; //上架下架
		int online = 0;
		if(shangxia){
			online = 1;
		}
		String pdetail = request.getParameter("pdetail");
	
	//	System.out.println(new Product(pname, 101, pno, "idsj", price, online, pcontent).toString());
		Product product=new Product(pname,101, pno,pic, price, online, pdetail);
		pd.getproductById(id);
		//3.把商品显示到浏览器中
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
