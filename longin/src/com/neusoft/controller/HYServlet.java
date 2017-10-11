package com.neusoft.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neusoft.entity.Consumer;
import com.neusoft.services.HYService;
import com.neusort.file.MD5Utils;

/**
 * Servlet implementation class HYServlet
 */
@WebServlet("/HYServlet")
public class HYServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HYServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		   response.setContentType("text/html;charset=\"utf-8\"");
		   request.setCharacterEncoding("utf-8");
		   PrintWriter pw=response.getWriter();
		   
		   String user = request.getParameter("username");
		   String psw = request.getParameter("password");
		   String type = request.getParameter("type");
		 
		   HttpSession session = request.getSession();
		   if(type!=null&&!type.equals("")&&type.equals("1")){
		   if(user==null||user.equals(""))
		   {
//			  
		   }
		   if(psw==null||psw.equals(""))
			
		   {
//			  
		   }
		   HYService ls = new HYService();
		   
		   Consumer acc=new Consumer(user,psw);
		   acc = ls.doLogin(acc);
		   
		   if(acc!=null)
		   {
		   
		   String isChecked=request.getParameter("checkbox");
		   if(isChecked!=null&&isChecked.equals("1")){
			   Cookie username_cookie=new Cookie("username_cookie", URLEncoder.encode(user,"UTF-8"));
			   username_cookie.setMaxAge(7*24*60*60);
			   Cookie psw_cookie=new Cookie("password_cookie", MD5Utils.GetMD5Code(psw));
			   psw_cookie.setMaxAge(7*24*60*60);
			   response.addCookie(username_cookie);
			   response.addCookie(psw_cookie);
		   }
			session.setAttribute("acc", acc);
			request.getRequestDispatcher("shouye.jsp").forward(request, response);

		   }else
		   {
//			   pw.append("<script>alert(\"¶Ô²»Æð,µÇÂ¼Ê§°Ü!\")</script>");
//			   session.setAttribute("acc", new Account("admin","admin","127.0.0.1"));
	  		   response.sendRedirect("HYServlet");
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
