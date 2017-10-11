package com.neusoft.services;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.dao.AccProductDao;
import com.neusoft.dao.DaoException;
import com.neusoft.dao.impl.AccProductDaoImpl;
import com.neusoft.entity.AccProduct;
import com.neusoft.entity.PageModel;
import com.neusoft.utils.DbUtil;

public class AccProductService {
	AccProductDao apd=DbUtil.getInstance("accProductDao", AccProductDaoImpl.class);
	//��ѯȫ������
		public List<AccProduct> getAccProductList(){
			List<AccProduct> AccProductList=apd.getAccProductList();
			if(AccProductList.size()>0){
				return AccProductList;
			}
			return null;
		}
		//��ѯ��Ʒ
		public PageModel<AccProduct> getAccProductByPage(int pageNo,int pageSize){
			return apd.getPageModel(pageNo, pageSize);
		}
		//��ѯҵ���߼�
		public void getAccProductLogin(HttpServletRequest request,HttpServletResponse response) throws DaoException,IOException,ServletException{
				
				String pageNo=request.getParameter("pageNo");
				String pageSize=request.getParameter("pageSize");
				System.out.println(pageNo);
				int _pageNo=Integer.parseInt(pageNo);
				int _pageSize=Integer.parseInt(pageSize);

				PageModel<AccProduct> accProducts=getAccProductByPage(_pageNo, _pageSize);
				if(accProducts!=null){
					int totalPageSize=(accProducts.getTotalcount()%_pageSize==0 ? accProducts.getTotalcount()/_pageSize : accProducts.getTotalcount()/_pageSize+1);
					accProducts.setTotalPageSize(totalPageSize);
					accProducts.setPageNo(_pageNo);
				}
				request.setAttribute("accProducts",accProducts);
				try {
					request.getRequestDispatcher("acc_product.jsp").forward(request, response);
				} catch (NumberFormatException e) {
					e.printStackTrace();
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
			PageModel<AccProduct> accProducts=getAccProductByPage(_pageNo, _pageSize);
			if(accProducts!=null){
				int totalPageSize=(accProducts.getTotalcount()%_pageSize==0 ? accProducts.getTotalcount()/_pageSize : accProducts.getTotalcount()/_pageSize+1);
				accProducts.setTotalPageSize(totalPageSize);
				accProducts.setPageNo(_pageNo);
			}
			request.setAttribute("accProducts", accProducts);
			try {
				request.getRequestDispatcher("acc_product.jsp").forward(request, response);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
		}
	//����id��ѯ��Ա
		public AccProduct getAccProductById(Integer id){
			return apd.getAccProduct(id);
		}
		//��Ҫ�޸ĵĻ�Ա��ʾ���޸�ҳ��ҵ���߼�
		public void updateAccProductLogin(HttpServletRequest request,HttpServletResponse response) throws DaoException,IOException,ServletException{
			int id = Integer.parseInt(request.getParameter("getid"));
			AccProduct accProduct=getAccProductById(id);
			request.setAttribute("accProduct", accProduct);
			request.getRequestDispatcher("updateacc_product.jsp").forward(request, response);
		}
	//�޸Ļ�Ա��Ϣ
		public boolean updateAccProduct(AccProduct accProduct){
			boolean flag=apd.updateAccProduct(accProduct);
			if(flag){
				return true;
			}
			return false;
		}
		//�޸�ҵ���߼�
		public void updateAccProductOutLogin(HttpServletRequest request,HttpServletResponse response)throws DaoException,IOException,ServletException{
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
						
			String button_value=request.getParameter("sub");
			if(button_value.equals("ȷ��")){
				//�õ��������Id
				int id=Integer.parseInt(request.getParameter("type"));
				
				String loginname=request.getParameter("loginname");
				String password=request.getParameter("password");
				long registertime=Long.parseLong(request.getParameter("registertime"));
				long lastlogintime=Long.parseLong(request.getParameter("lastlogintime"));
				String ip=request.getParameter("ip");
		
				boolean flag=updateAccProduct(new AccProduct(id, loginname, password, registertime, lastlogintime, ip));
				System.out.println(flag);
				if(flag){
					request.getRequestDispatcher("accProductServlet.do").forward(request, response);
				}
				}else{
				request.getRequestDispatcher("accProductServlet.do").forward(request, response);
				}
		}
		//��ӻ�Ա
		public boolean addAccProduct(AccProduct accProduct){
			return apd.addAccProduct(accProduct);
		}
		//���ҵ���߼�
		public void addAccProductLogin(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			
			String button_value=request.getParameter("sub");
			if(button_value.equals("ȷ��")){
			
				String loginname=request.getParameter("loginname");
					if(loginname==null || loginname.equals("")){
						throw new DaoException("�û�������Ϊ��");
					}
				String password=request.getParameter("password");
					if(password==null || password.equals("")){
						throw new DaoException("���벻��Ϊ��");
					}
	//			SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
	//			String registertime=dateFormat.format(System.currentTimeMillis());
				long registertime=System.currentTimeMillis();
				long lastlogintime=System.currentTimeMillis();
	//			String registertime=request.getParameter("registertime");
	//			String lastlogintime=request.getParameter("lastlogintime");
				String ip=request.getRemoteAddr();
				
				AccProduct AccProduct=new AccProduct(loginname, password, registertime, lastlogintime, ip);
				boolean flag=addAccProduct(AccProduct);
				System.out.println(flag);
				if(flag){
					request.getRequestDispatcher("accProductServlet.do").forward(request, response);
				}
			}else{
				request.getRequestDispatcher("accProductServlet.do").forward(request, response);
			}
		
		}
		//ɾ��������Ϣ
		public boolean deleteAccProduct(Integer id){
			return apd.deleteAccProduct(id);
		}
		
}
