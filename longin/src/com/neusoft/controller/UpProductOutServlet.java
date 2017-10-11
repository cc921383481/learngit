package com.neusoft.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.entity.Product;
import com.neusoft.services.ProductSerice;

/**
 * Servlet implementation class UpProductOutServlet
 */
@WebServlet("/UpProductOutServlet")
public class UpProductOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpProductOutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String pname=request.getParameter("pname");
		int cid =Integer.parseInt(request.getParameter("sel1"));
		int id =Integer.parseInt(request.getParameter("sel2"));
		String pno = request.getParameter("pno");
//		Double price = Double.parseDouble(request.getParameter("price");
//		String sel3 = request.getParameter("sel3");
		ProductSerice ps = new ProductSerice();
		boolean b =ps.updateProduct(new Product(id, pname, cid, pno));
		System.out.println("ps============"+new Product(id, pname, cid, pno));
		if(b){
			System.out.println("修改成功");
			request.getRequestDispatcher("ProductServlet").forward(request, response);
		}else{
			System.out.println("修改失败");
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
