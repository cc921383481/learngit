package com.neusoft.services;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.neusoft.dao.OrderDao;

import com.neusoft.dao.impl.OrderDaoImpl;
import com.neusoft.entity.PageModel;
import com.neusoft.entity.Product_orderinfo;
import com.neusoft.utils.DbUtil;

public class OrderService {	
	OrderDao od=DbUtil.getInstance("orderDao", OrderDaoImpl.class);
	public PageModel<Product_orderinfo> getPageModel(int pageNo,int pageSize){
		PageModel<Product_orderinfo>  pageModel=od.getPageModel(pageNo, pageSize);
		return pageModel;
	}
	//分页查询业务逻辑
	public void getOrderLogin(ServletRequest request,ServletResponse response) throws ServletException, IOException {
	    //从网页的标签获取
	   String pageNo=request.getParameter("pageNo");
	   String pageSize=request.getParameter("pageSize");
		
		try {
			int _pageNo=Integer.parseInt(pageNo);
			int _pageSize=Integer.parseInt(pageSize);
			//可以直接设置为第一页，加载五条数据
//			int _pageNo=1;
//  		int _pageSize=5;
			System.out.println("进入分页查询不是展示");
			PageModel<Product_orderinfo>  orders=getPageModel(_pageNo,_pageSize);
			if(orders!=null) {
				int totalPageSize= (orders.getTotalcount()%_pageSize==0?orders.getTotalcount()/_pageSize:orders.getTotalcount()/_pageSize+1);
				orders.setTotalPageSize(totalPageSize);
				orders.setPageNo(_pageNo);
			}
			
			request.setAttribute("orderlist", orders);
			
			System.out.println("跳转页面之前");
			request.getRequestDispatcher("orderinfo.jsp").forward(request, response);
			
		}catch(NumberFormatException e) {
			e.printStackTrace();
		}
		
}

//首页显示
	public void getShow(ServletRequest request,ServletResponse response) {
		try {
			
		//可以直接设置为第一页，加载4条数据
		int _pageNo=1;
  		int _pageSize=4;
		System.out.println("进入展示页面");
		PageModel<Product_orderinfo>  orders=getPageModel(_pageNo,_pageSize);
//		System.out.println(orders);
		if(orders!=null) {
			int totalPageSize= (orders.getTotalcount()%_pageSize==0?orders.getTotalcount()/_pageSize:orders.getTotalcount()/_pageSize+1);
			orders.setTotalPageSize(totalPageSize);
			orders.setPageNo(_pageNo);
		}

		request.setAttribute("orderlist", orders);
		
	    try {
			request.getRequestDispatcher("orderinfo.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		} 
	}catch(NumberFormatException e) {
		e.printStackTrace();
	}
	}
	//分页查询待支付，已完成，已付款，已发货
	public  PageModel<Product_orderinfo> getPageModelStatus(int pageNo,int pageSize,int searchType) {
		
		PageModel<Product_orderinfo> pageModel=od.getPageModelStatus(pageNo, pageSize, searchType);
		   return pageModel;
	}

	//分页查询方法
	public void getOrdersLogicStatus(ServletRequest request,ServletResponse response) {
			System.out.println("执行了吗？");
		    String pageNo=request.getParameter("pageNo");
			String pageSize=request.getParameter("pageSize");
			String searchType=request.getParameter("searchType");
			request.setAttribute("searchType",searchType);
			
			try {
				int _pageNo=Integer.parseInt(pageNo);
				int _pageSize=Integer.parseInt(pageSize);
				int _searchType=Integer.parseInt(searchType);
				System.out.println("进入分页查询不是展示");
				PageModel<Product_orderinfo>  orders=getPageModelStatus(_pageNo,_pageSize,_searchType);
				if(orders!=null) {
					int totalPageSize= (orders.getTotalcount()%_pageSize==0?orders.getTotalcount()/_pageSize:orders.getTotalcount()/_pageSize+1);
					orders.setTotalPageSize(totalPageSize);
					orders.setPageNo(_pageNo);
				}
				
				request.setAttribute("orderlist", orders);
			}catch(NumberFormatException e) {
				e.printStackTrace();
			}
	}
	 //点击事件，分别显示不同的订单状态
	public void getShowStatus(ServletRequest request,ServletResponse response) {
		
		String searchType=request.getParameter("searchType");
//       	System.out.println("点击后="+searchType);
		try {
			
			//可以直接设置为第一页，加载3条数据
			int _pageNo=1;
			int _pageSize=4;
			int _searchType=Integer.parseInt(searchType);

			System.out.println("进入展示页面");
			PageModel<Product_orderinfo>  orders=getPageModelStatus(_pageNo,_pageSize,_searchType);
			if(orders!=null) {
				int totalPageSize= (orders.getTotalcount()%_pageSize==0?orders.getTotalcount()/_pageSize:orders.getTotalcount()/_pageSize+1);
				orders.setTotalPageSize(totalPageSize);
				orders.setPageNo(_pageNo);
			}

			request.setAttribute("orderlist", orders);
		}catch(NumberFormatException e) {
			e.printStackTrace();
		}
		
}

}
