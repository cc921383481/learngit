package com.neusoft.services;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.dao.AddressDao;
import com.neusoft.dao.DaoException;
import com.neusoft.dao.impl.AddressDaoImpl;
import com.neusoft.entity.Address;
import com.neusoft.entity.PageModel;
import com.neusoft.entity.Rule;
import com.neusoft.utils.DbUtil;

public class AddressService {
	AddressDao ad=DbUtil.getInstance("addressDao", AddressDaoImpl.class);
	//查询全部地址
		public List<Address> getAddressList(){
			List<Address> addressList=ad.getAddressList();
			if(addressList.size()>0){
				return addressList;
			}
			return null;
		}
		//查询地址
			public PageModel<Address> getAddressByPage(int pageNo,int pageSize){
				return ad.getPageModel(pageNo, pageSize);
			}
			//查询业务逻辑
		public void getAddressLogin(HttpServletRequest request,HttpServletResponse response) throws DaoException,IOException,ServletException{
				
				String pageNo=request.getParameter("pageNo");
				String pageSize=request.getParameter("pageSize");
				System.out.println(pageNo);
				int _pageNo=Integer.parseInt(pageNo);
				int _pageSize=Integer.parseInt(pageSize);

				PageModel<Address> addresss=getAddressByPage(_pageNo, _pageSize);
				if(addresss!=null){
					int totalPageSize=(addresss.getTotalcount()%_pageSize==0 ? addresss.getTotalcount()/_pageSize : addresss.getTotalcount()/_pageSize+1);
					addresss.setTotalPageSize(totalPageSize);
					addresss.setPageNo(_pageNo);
				}
				request.setAttribute("addresss", addresss);
				try {
					request.getRequestDispatcher("address.jsp").forward(request, response);
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
			PageModel<Address> addresss=getAddressByPage(_pageNo, _pageSize);
			if(addresss!=null){
				int totalPageSize=(addresss.getTotalcount()%_pageSize==0 ? addresss.getTotalcount()/_pageSize : addresss.getTotalcount()/_pageSize+1);
				addresss.setTotalPageSize(totalPageSize);
				addresss.setPageNo(_pageNo);
			}
			request.setAttribute("addresss", addresss);
			try {
				request.getRequestDispatcher("address.jsp").forward(request, response);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
		}
		//添加地址
		public boolean addAddress(Address address){
			return ad.addAddress(address);
		}
		//删除地址
		public void delRegionAddress(Integer id){
			ad.delRegion(id);
		}
		//修改地址
		public boolean updateAddress(Address address){
			return ad.updateAddress(address);
		}
		//查询地址
		public Address getAddressById(Integer id){
			return ad.getAddress(id);
		}
		
		//将要修改的地址显示到修改页面业务逻辑
		public void updateAddressLogin(HttpServletRequest request,HttpServletResponse response) throws DaoException,IOException,ServletException{
			int id = Integer.parseInt(request.getParameter("getid"));
			Address address=getAddressById(id);
			System.out.println(address);
			List<Address> addressList=getAddressList();
			request.setAttribute("address",address);
			request.setAttribute("addressList", addressList);
			request.getRequestDispatcher("updateaddress.jsp").forward(request, response);
		}
		
}
