package com.neusoft.services;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.dao.DaoException;
import com.neusoft.dao.RuleDao;
import com.neusoft.dao.impl.RuleDaoImpl;
import com.neusoft.entity.PageModel;
import com.neusoft.entity.Rule;
import com.neusoft.utils.DbUtil;

public class RuleService {
	RuleDao rd=DbUtil.getInstance("ruleDao", RuleDaoImpl.class);
	//查询全部规格
	public List<Rule> getRuleList(){
		List<Rule> ruleList=rd.getRuleList();
		if(ruleList.size()>0){
			return ruleList;
		}
		return null;
	}
	//查询商品
		public PageModel<Rule> getRuleByPage(int pageNo,int pageSize){
			return rd.getPageModel(pageNo, pageSize);
		}
		//查询业务逻辑
	public void getRuleLogin(HttpServletRequest request,HttpServletResponse response) throws DaoException,IOException,ServletException{
			
			String pageNo=request.getParameter("pageNo");
			String pageSize=request.getParameter("pageSize");
			System.out.println(pageNo);
			int _pageNo=Integer.parseInt(pageNo);
			int _pageSize=Integer.parseInt(pageSize);

			PageModel<Rule> rules=getRuleByPage(_pageNo, _pageSize);
			if(rules!=null){
				int totalPageSize=(rules.getTotalcount()%_pageSize==0 ? rules.getTotalcount()/_pageSize : rules.getTotalcount()/_pageSize+1);
				rules.setTotalPageSize(totalPageSize);
				rules.setPageNo(_pageNo);
			}
			request.setAttribute("rules", rules);
			try {
				request.getRequestDispatcher("norm.jsp").forward(request, response);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
		}
	/**
	 * 显示reqType=2
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void disReqType2(ServletRequest request,ServletResponse response) throws ServletException, IOException{
		int _pageNo=1;
		int _pageSize=5;
		PageModel<Rule> rules=getRuleByPage(_pageNo, _pageSize);
		if(rules!=null){
			int totalPageSize=(rules.getTotalcount()%_pageSize==0 ? rules.getTotalcount()/_pageSize : rules.getTotalcount()/_pageSize+1);
			rules.setTotalPageSize(totalPageSize);
			rules.setPageNo(_pageNo);
		}
		request.setAttribute("rules", rules);
		try {
			request.getRequestDispatcher("norm.jsp").forward(request, response);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}
	//删除规格
	public boolean deleteRule(Integer id){
		return rd.deleteRule(id);
	}
	//添加业务逻辑
	public void addRuleLogin(HttpServletRequest request,HttpServletResponse response) throws DaoException,IOException,ServletException{
		Integer pid=Integer.parseInt(request.getParameter("_textid"));
		String  size=request.getParameter("_textsize");
		
		Rule rule=new Rule(pid,size);
		boolean flag=rd.addRule(rule);
		if(flag){
			request.getRequestDispatcher("ruleServlet.do").forward(request, response);
		}
	}
	//根据id查询规格
	public Rule getRuleById(Integer id){
		return rd.getRule(id);
	}
	//将要修改的规格显示到修改页面业务逻辑
	public void updateRuleLogin(HttpServletRequest request,HttpServletResponse response) throws DaoException,IOException,ServletException{
		int id = Integer.parseInt(request.getParameter("getid"));
		Rule rule=getRuleById(id);
		request.setAttribute("rule", rule);
		request.getRequestDispatcher("updaterule.jsp").forward(request, response);
	}
	
	//修改规格
	public boolean updateRule(Rule rule){
		
		boolean flag = rd.updateRule(rule);
		if(flag){
			return true;
		}
		return false;
		
	}
	
}
