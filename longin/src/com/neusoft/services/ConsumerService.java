package com.neusoft.services;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.dao.ConsumerDao;
import com.neusoft.dao.DaoException;
import com.neusoft.dao.impl.ConsumerDaoImpl;
import com.neusoft.entity.Consumer;
import com.neusoft.entity.PageModel;
import com.neusoft.utils.DbUtil;

public class ConsumerService {
	ConsumerDao cd=DbUtil.getInstance("consumerDao", ConsumerDaoImpl.class);
	//查询全部规格
	public List<Consumer> getConsumerList(){
		List<Consumer> consumerList=cd.getConsumerList();
		if(consumerList.size()>0){
			return consumerList;
		}
		return null;
	}
	//查询商品
	public PageModel<Consumer> getConsumerByPage(int pageNo,int pageSize){
		return cd.getPageModel(pageNo, pageSize);
	}
	//查询业务逻辑
	public void getConsumerLogin(HttpServletRequest request,HttpServletResponse response) throws DaoException,IOException,ServletException{
			
			String pageNo=request.getParameter("pageNo");
			String pageSize=request.getParameter("pageSize");
			System.out.println(pageNo);
			int _pageNo=Integer.parseInt(pageNo);
			int _pageSize=Integer.parseInt(pageSize);

			PageModel<Consumer> consumers=getConsumerByPage(_pageNo, _pageSize);
			if(consumers!=null){
				int totalPageSize=(consumers.getTotalcount()%_pageSize==0 ? consumers.getTotalcount()/_pageSize : consumers.getTotalcount()/_pageSize+1);
				consumers.setTotalPageSize(totalPageSize);
				consumers.setPageNo(_pageNo);
			}
			request.setAttribute("consumers", consumers);
			try {
				request.getRequestDispatcher("acc_consumer.jsp").forward(request, response);
			} catch (NumberFormatException e) {
				e.printStackTrace();
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
		PageModel<Consumer> consumers=getConsumerByPage(_pageNo, _pageSize);
		if(consumers!=null){
			int totalPageSize=(consumers.getTotalcount()%_pageSize==0 ? consumers.getTotalcount()/_pageSize : consumers.getTotalcount()/_pageSize+1);
			consumers.setTotalPageSize(totalPageSize);
			consumers.setPageNo(_pageNo);
		}
		request.setAttribute("consumers", consumers);
		try {
			request.getRequestDispatcher("acc_consumer.jsp").forward(request, response);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}
//根据id查询会员
	public Consumer getConsumerById(Integer id){
		return cd.getConsumer(id);
	}
	//将要修改的会员显示到修改页面业务逻辑
	public void updateConsumerLogin(HttpServletRequest request,HttpServletResponse response) throws DaoException,IOException,ServletException{
		int id = Integer.parseInt(request.getParameter("getid"));
		Consumer consumer=getConsumerById(id);
		request.setAttribute("consumer", consumer);
		request.getRequestDispatcher("updateacc_consumer.jsp").forward(request, response);
	}
//修改会员信息
	public boolean updateConsumer(Consumer consumer){
		boolean flag=cd.updateConsumer(consumer);
		if(flag){
			return true;
		}
		return false;
	}
	//修改业务逻辑
	public void updateConsumerOutLogin(HttpServletRequest request,HttpServletResponse response)throws DaoException,IOException,ServletException{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String button_value=request.getParameter("sub");
		if(button_value.equals("确认")){
			//拿到隐藏域的Id
			int id=Integer.parseInt(request.getParameter("type"));
			System.out.println(id);
			String loginname=request.getParameter("loginname");
			String password=request.getParameter("password");
			long registertime=Long.parseLong(request.getParameter("registertime"));
			long lastlogintime=Long.parseLong(request.getParameter("lastlogintime"));
			String ip=request.getParameter("ip");
			String nickname=request.getParameter("nickname");
//			double money=Double.parseDouble("money");
			long lasttime=Long.parseLong(request.getParameter("lasttime"));
	
			boolean flag=updateConsumer(new Consumer(id, loginname, password, registertime, lastlogintime, ip, nickname,0.0, lasttime));
			System.out.println(flag);
			if(flag){
				request.getRequestDispatcher("consumerServlet.do").forward(request, response);
			}
			}else{
			request.getRequestDispatcher("consumerServlet.do").forward(request, response);
			}
	}
	//添加会员
	public boolean addConsumer(Consumer consumer){
		return cd.addConsumer(consumer);
	}
	//添加业务逻辑
	public void addConsumerLogin(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String button_value=request.getParameter("sub");
		System.out.println(button_value);
		if(button_value.equals("确认")){
		
			String loginname=request.getParameter("loginname");
				if(loginname==null || loginname.equals("")){
					throw new DaoException("用户名不能为空");
				}
				System.out.println(loginname);
			String password=request.getParameter("password");
				if(password==null || password.equals("")){
					throw new DaoException("密码不能为空");
				}
			System.out.println(password);	
//			SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
//			String registertime=dateFormat.format(System.currentTimeMillis());
			long registertime=System.currentTimeMillis();
			long lastlogintime=System.currentTimeMillis();
//			String registertime=request.getParameter("registertime");
//			String lastlogintime=request.getParameter("lastlogintime");
			String ip=request.getRemoteAddr();
			
			Consumer consumer=new Consumer(loginname, password, registertime, lastlogintime, ip);
			boolean flag=addConsumer(consumer);
			System.out.println(flag);
			if(flag){
				request.getRequestDispatcher("consumerServlet.do").forward(request, response);
			}
		}else{
			request.getRequestDispatcher("consumerServlet.do").forward(request, response);
		}
	
	}
	
}
