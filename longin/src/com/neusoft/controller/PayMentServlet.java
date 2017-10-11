package com.neusoft.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.dao.DaoException;
import com.neusoft.services.OrderService;

/**
 * Servlet implementation class PayMentServlet
 */
@WebServlet("/payMentServlet.do")
public class PayMentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PayMentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		OrderService os=new OrderService();
		
		String reqType=request.getParameter("reqType");
		
		
		if(reqType!=null && !reqType.equals("")){
			if(reqType.equals("2")){
				//处理查询订单请求    捕获并且处理异常
				try{
					os.getOrdersLogicStatus(request, response);
					request.getRequestDispatcher("payment.jsp").forward(request, response);
				}catch(DaoException e){
					request.setAttribute("error", e.getMessage());
				}
			}
		}else{
			os.getShowStatus(request, response);
			request.getRequestDispatcher("payment.jsp").forward(request, response);
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
