package com.neusoft.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.entity.Rule;
import com.neusoft.services.RuleService;

/**
 * Servlet implementation class UpdateRuleOutServlet
 */
@WebServlet("/updateRuleOutServlet.do")
public class UpdateRuleOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateRuleOutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		
		String button_value=request.getParameter("sub");
		if(button_value.equals("х╥хо")){
			int id=Integer.parseInt(request.getParameter("type"));
			int pid =Integer.parseInt(request.getParameter("_textid"));
			String size=request.getParameter("_textsize");
			
//			System.out.println(id);
//			System.out.println(pid);
//			System.out.println(size);
			
			RuleService rs=new RuleService();
			boolean flag=rs.updateRule(new Rule(id,pid,size));
			System.out.println(flag);
			if(flag){
				request.getRequestDispatcher("ruleServlet.do").forward(request, response);
			}
		}else{
			request.getRequestDispatcher("ruleServlet.do").forward(request, response);
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
