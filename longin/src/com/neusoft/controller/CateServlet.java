package com.neusoft.controller;

import java.io.IOException;
import java.util.List;

import javax.print.ServiceUIFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.Request;

import com.neusoft.dao.DaoException;
import com.neusoft.entity.Cate;
import com.neusoft.services.CateSerice;



/**
 * Servlet implementation class CateServlet
 */
@WebServlet("/CateServlet")
public class CateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CateSerice cd= new CateSerice();
		
		String reqType=request.getParameter("reqType");
		//删除分类
		String delet_cid=request.getParameter("delet_cid");
		
		
		if(reqType!=null && !reqType.equals("")){
			if(reqType.equals("4")){
				//处理删除分类请求     捕获并且处理异常
				try{
					int delcid=Integer.parseInt(delet_cid);
					cd.delRegion(delcid);
					cd.disReqType2(request, response);
				
				}catch(DaoException e){
					request.setAttribute("error", e.getMessage());
					request.getRequestDispatcher("fenlei.jsp?reqType=2&pageNo=1&pageSize=10").forward(request, response);
				}
			}else if(reqType.equals("2")){
				//处理查询分类请求    捕获并且处理异常
				try{
					cd.getCateLogin(request, response);
					}catch(DaoException e){
						request.setAttribute("error", e.getMessage());
//						request.getRequestDispatcher("index.jsp").forward(request, response);
					}
			}
		}else{
			cd.disReqType2(request, response);
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
