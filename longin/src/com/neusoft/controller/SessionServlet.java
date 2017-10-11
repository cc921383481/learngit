package com.neusoft.controller;

import java.awt.FontFormatException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionServlet
 */
@WebServlet("/SessionServlet")
public class SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
         response.setContentType("text/html;charset=UTF-8");
	
         HttpSession session = request.getSession();
	     session.setMaxInactiveInterval(20);
	     PrintWriter pw=response.getWriter();
	
	     if(session.isNew()){
	    	 pw.println("<p>�´�����һ���Ự���Ựid="+session.getId()+"</p>");
	     }else{
	    	 pw.println("<p>�Ѵ��ڵ�һ���Ự���Ựid="+session.getId()+"</p>");
	      }
	      
	     SimpleDateFormat formate=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	     String _date=formate.format(new Date(session.getCreationTime()));
	     pw.println("<p>session�Ĵ���ʱ��"+_date+"</p>");
	     
	     String _last_date=formate.format(new Date(session.getCreationTime()));
	     pw.println("<p>���һ�η��ʵ�ʱ��"+_last_date+"</p>");
	     
	     pw.println("<p>�Ự��ʱʱ��(s):"+session.getMaxInactiveInterval()+"</p>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
