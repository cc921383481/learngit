package com.neusoft.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.entity.Cate;
import com.neusoft.services.CateSerice;



/**
 * Servlet implementation class AddCateServlet
 */
@WebServlet("/AddCateServlet")
public class AddCateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub\
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
			
			CateSerice cs= new CateSerice();
			
			String option_value=request.getParameter("add_select");
			String cname=request.getParameter("input_add");
			String type_value=request.getParameter("button_name");
			
			
			if(option_value!=null&&!option_value.equals("")) {
//				System.out.println("新加分类="+cname);
				int pid=Integer.parseInt(option_value);
//				System.out.println("上级ID="+pid);
//				System.out.println("上级ID="+pid);
				if(type_value.equals("yes")){
					System.out.println("cname="+cname);
					Cate cate=new Cate(cname,pid);
					boolean flag=cs.addcate(cate);
					request.getRequestDispatcher("CateServlet").forward(request, response);
				}else{
					request.getRequestDispatcher("CateServlet").forward(request, response);
				}
				
			}else{

				List<Cate> catelist=cs.checkCateList();
				request.setAttribute("catelist",catelist );
				request.getRequestDispatcher("tianjia.jsp").forward(request, response);
			}
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		 TODO Auto-generated method stub
		doGet(request, response);
	}

}
