package com.neusoft.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.dao.DaoException;
import com.neusoft.services.AddressService;

/**
 * Servlet implementation class AddressServlet
 */
@WebServlet("/addressServlet.do")
public class AddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddressServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		AddressService as=new AddressService();
		String reqType=request.getParameter("reqType");
		
		if(reqType!=null && !reqType.equals("")){
			if(reqType.equals("4")){
				//处理删除规格请求     捕获并且处理异常
				try{
					String delet_id=request.getParameter("delet_id");
					
					int id=Integer.parseInt(delet_id);
					as.delRegionAddress(id);
					//删除后显示当前页面
					as.disReqType2(request, response);
				}catch(DaoException e){
					request.setAttribute("error", e.getMessage());
					request.getRequestDispatcher("address.jsp?reqType=2&pageNo=1&pageSize=5").forward(request, response);
				}
			}else if(reqType.equals("2")){
				//处理查询分类请求    捕获并且处理异常
				try{
					as.getAddressLogin(request, response);
					}catch(DaoException e){
						request.setAttribute("error", e.getMessage());
					}
			}
		}else{
			as.disReqType2(request, response);
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
