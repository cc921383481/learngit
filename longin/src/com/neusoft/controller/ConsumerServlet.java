package com.neusoft.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.dao.DaoException;
import com.neusoft.entity.Consumer;
import com.neusoft.services.ConsumerService;

/**
 * Servlet implementation class ConsumerServlet
 */
@WebServlet("/consumerServlet.do")
public class ConsumerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsumerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		ConsumerService cs=new ConsumerService();
		
//		List<Consumer> consumerList=cs.getConsumerList();
//		request.setAttribute("consumerList",consumerList);
//		request.getRequestDispatcher("acc_consumer.jsp").forward(request, response);
		String reqType=request.getParameter("reqType");
		
		if(reqType!=null && !reqType.equals("")){
			if(reqType.equals("4")){
				//处理查看会员信息请求     捕获并且处理异常
				try{
					String check_id=request.getParameter("check_id");
					int id=Integer.parseInt(check_id);
					Consumer consumer=cs.getConsumerById(id);
					//点击返回后显示当前页面
					request.setAttribute("consumer",consumer);
					request.getRequestDispatcher("checkacc_consumer.jsp").forward(request, response);
					
				}catch(DaoException e){
					request.setAttribute("error", e.getMessage());
					request.getRequestDispatcher("acc_consumer.jsp?reqType=2&pageNo=1&pageSize=5").forward(request, response);
				}
			}else if(reqType.equals("2")){
				//处理查询分类请求    捕获并且处理异常
				try{
					cs.getConsumerLogin(request, response);
					}catch(DaoException e){
						request.setAttribute("error", e.getMessage());
					}
			}
		}else{
			cs.disReqType2(request, response);
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
