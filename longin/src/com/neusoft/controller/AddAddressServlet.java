package com.neusoft.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.entity.Address;
import com.neusoft.services.AddressService;

/**
 * Servlet implementation class AddAddressServlet
 */
@WebServlet("/addAddressServlet.do")
public class AddAddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAddressServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		AddressService as=new AddressService();
		
		String option_value=request.getParameter("add_select");
		String name=request.getParameter("input_add");
		String type_value=request.getParameter("button_name");
		
		
		if(option_value!=null&&!option_value.equals("")) {
//			System.out.println("新加分类="+cname);
			int parentid=Integer.parseInt(option_value);
//			System.out.println("上级ID="+parentid);
			if(type_value.equals("确认")){
				System.out.println("name="+name);
				Address address=new Address(name,parentid);
				boolean flag=as.addAddress(address);
				if(flag){
					request.getRequestDispatcher("addressServlet.do").forward(request, response);
				}
			}else{
				request.getRequestDispatcher("addressServlet.do").forward(request, response);
			}
			
		}
//		else if(option_value.equals("def")){
//			if(type_value.equals("确认")){
//				System.out.println("name="+name);
//				Address address=new Address(name,0);
//				boolean flag=as.addAddress(address);
//				if(flag){
//					request.getRequestDispatcher("addressServlet.do").forward(request, response);
//				}
//			}else{
//				request.getRequestDispatcher("addressServlet.do").forward(request, response);
//			}
//		}
		else{

			List<Address> addressList=as.getAddressList();
			request.setAttribute("addressList",addressList);
			request.getRequestDispatcher("addaddress.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
