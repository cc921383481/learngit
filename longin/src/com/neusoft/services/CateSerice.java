package com.neusoft.services;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.dao.CateDao;
import com.neusoft.dao.DaoException;
import com.neusoft.dao.DaoFactory;
import com.neusoft.entity.Cate;
import com.neusoft.entity.PageModel;

public  class CateSerice {
	CateDao cd=DaoFactory.getInstance("cdDao");
	
	public List<Cate> checkCateList(){
	List<Cate> lc=cd.checkCateList();
	
//	System.out.println(lc.size());
	
	if(lc.size()>0){
//		System.out.println(lc);
		return  lc;
	}
		return null ;
      
	}
	public boolean addcate(Cate ca) {
		return cd.addcate(ca);
	}
	
	public boolean updateCate(Cate ca){
		return cd.updateCate(ca);
	}
	
	public void delRegion(Integer cid){
		cd.delRegion(cid);
	}
	/**
	 *分页查询业务逻辑
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public void getCateLogin(HttpServletRequest request,HttpServletResponse response) throws DaoException,IOException,ServletException{
		
		String pageNo=request.getParameter("pageNo");
		String pageSize=request.getParameter("pageSize");
		
		int _pageNo=Integer.parseInt(pageNo);
		int _pageSize=Integer.parseInt(pageSize);

		PageModel<Cate> cates=getCateByPage(_pageNo, _pageSize);
		if(cates!=null){
			int totalPageSize=(cates.getTotalcount()%_pageSize==0 ? cates.getTotalcount()/_pageSize : cates.getTotalcount()/_pageSize+1);
			cates.setTotalPageSize(totalPageSize);
			cates.setPageNo(_pageNo);
		}
		request.setAttribute("cates", cates);
		try {
			request.getRequestDispatcher("fenlei.jsp").forward(request, response);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	
	}
	//分页查询
	public PageModel<Cate> getCateByPage(int pageNo,int pageSize){
		return cd.getPageModel(pageNo, pageSize);
	}
	/**
	 * 显示reqType=2
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void disReqType2(ServletRequest request,ServletResponse response) throws ServletException, IOException{
		int _pageNo=1;
		int _pageSize=5;
		PageModel<Cate> cates=getCateByPage(_pageNo, _pageSize);
		if(cates!=null){
			int totalPageSize=(cates.getTotalcount()%_pageSize==0 ? cates.getTotalcount()/_pageSize : cates.getTotalcount()/_pageSize+1);
			cates.setTotalPageSize(totalPageSize);
			cates.setPageNo(_pageNo);
		}
		request.setAttribute("cates", cates);
		try {
			request.getRequestDispatcher("CateServlet?reqType=2&pageNo=1&pageSize=5").forward(request, response);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}
}
