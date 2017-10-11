package com.neusoft.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.dao.DaoException;
import com.neusoft.entity.Product;
import com.neusoft.entity.Rule;
import com.neusoft.services.ProductService;
import com.neusoft.services.RuleService;

/**
 * Servlet implementation class RuleServlet
 */
@WebServlet("/ruleServlet.do")
public class RuleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RuleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		RuleService rs=new RuleService();
		
//		List<Rule> ruleList=rs.getRuleList();
//		request.setAttribute("ruleList", ruleList);
//		request.getRequestDispatcher("norm.jsp").forward(request, response);
		
		String reqType=request.getParameter("reqType");
		
		if(reqType!=null && !reqType.equals("")){
			if(reqType.equals("4")){
				//处理删除规格请求     捕获并且处理异常
				try{
					String delet_id=request.getParameter("delet_id");
					int id=Integer.parseInt(delet_id);
					rs.deleteRule(id);
					//删除后显示当前页面
					rs.disReqType2(request, response);
				}catch(DaoException e){
					request.setAttribute("error", e.getMessage());
					request.getRequestDispatcher("norm.jsp?reqType=2&pageNo=1&pageSize=5").forward(request, response);
				}
			}else if(reqType.equals("2")){
				//处理查询分类请求    捕获并且处理异常
				try{
					rs.getRuleLogin(request, response);
					}catch(DaoException e){
						request.setAttribute("error", e.getMessage());
					}
			}
		}else{
			rs.disReqType2(request, response);
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
