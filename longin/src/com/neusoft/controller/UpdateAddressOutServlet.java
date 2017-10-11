package com.neusoft.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.entity.Address;
import com.neusoft.services.AddressService;


/**
 * Servlet implementation class UpdateAddressOutServlet
 */
@WebServlet("/updateAddressOutServlet.do")
public class UpdateAddressOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAddressOutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		
		String button_value=request.getParameter("sub");
		if(button_value.equals("确认")){
			int id=Integer.parseInt(request.getParameter("type"));
			String shname=request.getParameter("_text");
			String sname=request.getParameter("option_name");
			
			System.out.println(id);
			System.out.println(shname);
			System.out.println(sname);
			
			AddressService as=new AddressService();
			boolean flag=as.updateAddress(new Address(id,shname,sname));
			//dao层实现类的修改sql写的有问题
			System.out.println(flag);
			if(flag){
				request.getRequestDispatcher("addressServlet.do").forward(request, response);
			}
		}else{
			request.getRequestDispatcher("addressServlet.do").forward(request, response);
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
