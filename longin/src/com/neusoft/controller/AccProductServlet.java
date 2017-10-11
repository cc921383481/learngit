package com.neusoft.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.dao.DaoException;
import com.neusoft.services.AccProductService;



/**
 * Servlet implementation class AccProductServlet
 */
@WebServlet("/accProductServlet.do")
public class AccProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		AccProductService aps=new AccProductService();
		

		String reqType=request.getParameter("reqType");
		
		if(reqType!=null && !reqType.equals("")){
			if(reqType.equals("4")){
				//处理删除卖家信息请求     捕获并且处理异常
				try{
					String delete_id=request.getParameter("delete_id");
					int id=Integer.parseInt(delete_id);
					boolean flag=aps.deleteAccProduct(id);
					//删除后显示当前页面
					if(flag){
						request.getRequestDispatcher("accProductServlet.do?reqType=2&pageNo=1&pageSize=5").forward(request, response);
					}
				}catch(DaoException e){
					request.setAttribute("error", e.getMessage());
					request.getRequestDispatcher("acc_product.jsp?reqType=2&pageNo=1&pageSize=5").forward(request, response);
				}
			}else if(reqType.equals("2")){
				//处理查询分类请求    捕获并且处理异常
				try{
					aps.getAccProductLogin(request, response);
					}catch(DaoException e){
						request.setAttribute("error", e.getMessage());
					}
			}
		}else{
			aps.disReqType2(request, response);
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
