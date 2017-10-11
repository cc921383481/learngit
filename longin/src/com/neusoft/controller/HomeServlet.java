package com.neusoft.controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.entity.Account;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	 ServletConfig config=this.getServletConfig();
	 
	 Enumeration<String> names=config.getInitParameterNames();
	 while(names.hasMoreElements()){
		 String name=names.nextElement();
		 String value=config.getInitParameter(name);
		 System.out.println(name+":"+value);
	 }
	 
	 ServletContext sContext=this.getServletContext();
	 String encoding=sContext.getInitParameter("encoding");
	 System.out.println("encoding"+encoding);
	 
	 Object obj=request.getAttribute("acc");
	 if(obj!=null&&obj instanceof Account){
		 Account acc=(Account)obj;
		 response.getWriter().append(acc.getUsername()+""+acc.getLogindate()+""+acc.getIp());
		 
	 }else{
		 Object o =sContext.getAttribute("acc");
		 if(o!=null&&o instanceof Account){
			 Account acc=(Account)o;
			 response.getWriter().append(acc.getUsername()+""+acc.getLogindate()+""+acc.getIp());
		 }
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
