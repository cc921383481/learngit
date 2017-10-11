package com.neusoft.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neusoft.entity.Account;
import com.neusoft.services.LoginService;
import com.neusort.file.MD5Utils;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html;charset=\"utf-8\"");
		request.setCharacterEncoding("utf-8");
	  
	  // System.out.println(user);
	  // System.out.println(psw);
	 
		response.setContentType("text/html;charset=UTF-8");
		
		//获取servletConfig引用 
		ServletConfig config=this.getServletConfig();
		
		Enumeration<String> names=config.getInitParameterNames();
		while(names.hasMoreElements()) {
			String name=names.nextElement();
			String value=config.getInitParameter(name);
			System.out.println(name+":"+value);
		}
		
		//获取ServletContext引用
		ServletContext sContext=this.getServletContext();
		String encoding=sContext.getInitParameter("encoding");
		System.out.println("encoding="+encoding);
	  // System.out.println(user);
	  // System.out.println(psw);
		
		PrintWriter pw=response.getWriter();
		
		pw.append("<html>");
		pw.append("<head>");
		pw.append("<title>");
		pw.append("欢迎登录");
		pw.append("</title>");
		
		pw.append("</head>");
		pw.append("<body>");
		pw.append("<div style=\"width: 100%; height: 600px; background-color: #7FFFD4;border: 1px solid gold;\">");
		pw.append("<form method=\"post\" action=\"\" >");
		pw.append("<div style=\"width: 30%; height: 230px; background-color: white;border: 46px solid burlywood;border-radius:10px;;margin:auto;margin-top: 150px ;\">");
		pw.append("<p align=\"left\" style=\"background-color: #7FFFD4;margin-top: 1px;width: 100%;height: 45px;display: block;line-height: 45px;text-align: left;\">");
		pw.append("<img  style=\"width: 30px; height: 30px; margin-top: 5px; align=\"left\" src=\"img/denglu.png\"/>");
		pw.append("用户登录</p>");
		pw.append("<p align=\"center\">用户名：<input name=\"username\"/></p>");
			
			
		pw.append("<p align=\"center\">密          码： <input name=\"password\"/></p>");
		pw.append("<p style=\"margin-left: 145px;\"><input type=\"checkbox\"  name=\"checkbox\" value=\"1\" align=\"center\"/>自动登录</p>");
		
	    pw.append("<input type=\"submit\"  value=\"登录\"  style=\"width:70px; height:30px;margin-left: 155px;background-color: #7FFFD4;border-radius:10px;\"/>");
			
	    pw.append("</div>");
	    pw.append("<input type=\"hidden\" name=\"type\" value=\"1\" />");
	    pw.append("</form>");
		pw.append("</div>");
		
		pw.append("</body>");
		pw.append("</html>");
		
		
	   String user = request.getParameter("username");
	   String psw = request.getParameter("password");
	   String type = request.getParameter("type");
	 /*  System.out.println(user);
	   System.out.println(psw);*/
	   HttpSession session = request.getSession();
	   if(type!=null&&!type.equals("")&&type.equals("1")){
	   if(user==null||user.equals(""))
	   {
//		   pw.append("<script>alert(\"用户名不能为空\")</script>");
//		   return;
	   }
	   if(psw==null||psw.equals(""))
		
	   {
//		   pw.append("<script>alert(\"密码不能为空\")</script>");
//		   return;
	   }
	   LoginService ls = new LoginService();
	   
	   Account acc=new Account(user,MD5Utils.GetMD5Code(psw),request.getRemoteAddr());
	   acc = ls.doLogin(acc);
	   
	   if(acc!=null)
	   {
//		   pw.append("<script>alert(\"success\")</script>");
//		   request.setAttribute("acc", acc);	
//		   request.getRequestDispatcher("denglu.jsp").forward(request, response);
	   
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
//		   pw.append("<script>alert(\"对不起,登录失败!\")</script>");
//		   session.setAttribute("acc", new Account("admin","admin","127.0.0.1"));
  		   response.sendRedirect("LoginServlet");
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
