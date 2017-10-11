package com.neusoft.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.dao.DaoException;
import com.neusoft.services.ProductSerice;
import com.neusoft.services.ProductService;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		ProductSerice ps=new ProductSerice();
		//ps.getProductLogin(request, response);
		
		String reqType=request.getParameter("reqType");
		
		if(reqType!=null && !reqType.equals("")){
			if(reqType.equals("4")){
				//处理删除商品请求     捕获并且处理异常
				try{
					String delet_id=request.getParameter("delet_id");
					int id=Integer.parseInt(delet_id);
					ps.deleteProduct(id);
					//删除后显示当前页面
					ps.disReqType2(request, response);
				}catch(DaoException e){
					request.setAttribute("error", e.getMessage());
					request.getRequestDispatcher("productmanager.jsp?reqType=2&pageNo=1&pageSize=5").forward(request, response);
				}
			}else if(reqType.equals("2")){
				//处理查询分类请求    捕获并且处理异常
				try{
					ps.getProductLogin(request, response);
					}catch(DaoException e){
						request.setAttribute("error", e.getMessage());
					}
			}
		}else{
			ps.disReqType2(request, response);
		}
		ps.deleteProductLogin(request, response);
		ps.disReqType2(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
