package com.neusoft.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.neusoft.dao.DaoException;
import com.neusoft.dao.RuleDao;
import com.neusoft.entity.PageModel;
import com.neusoft.entity.Rule;
import com.neusoft.utils.ConnectionFactory;

public class RuleDaoImpl implements RuleDao{
	Connection conn=null;
	QueryRunner qr=new QueryRunner();
	Rule rule=null;
	PreparedStatement pstmt = null;
    ResultSet rs = null;
    List<Rule> ruleList=new ArrayList<Rule>();
	@Override
	public List<Rule> getRuleList() {
		try {
			Connection conn=ConnectionFactory.getInstance().getConnection();
//			String sql = "select r.id,p.pname,p.id,r.size from rule r right outer join product p on r.pid=p.id ";
			String sql="select * from rule order by id";
			ResultSetHandler<List<Rule>> rs = new BeanListHandler<Rule>(Rule.class);
			ruleList= qr.query(conn, sql ,rs);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				DbUtils.closeQuietly(conn);
			}
			
			return ruleList;
	}

	@Override
	public boolean addRule(Rule rule) throws DaoException {
		try {
			Connection conn=ConnectionFactory.getInstance().getConnection();

			String sql= "insert into rule(pid,size) values(?,?)";
			int count = qr.update(conn, sql, rule.getPid(),rule.getSize());
			if(count>0){
//				System.out.println("插入成功");
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
		}

	@Override
	public boolean deleteRule(Integer id) throws DaoException {
		try {
			Connection conn=ConnectionFactory.getInstance().getConnection();

			String sql = "delete from rule where id = ?";
			int count = qr.update(conn, sql,id);
			if(count>0) {
//				System.out.println("删除成功");
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateRule(Rule rule) throws DaoException {
		try {
			Connection conn=ConnectionFactory.getInstance().getConnection();

			String sql = "update rule set pid=?,size=? where id=?";
			int count = qr.update(conn, sql, rule.getPid(),rule.getSize(),rule.getId());
			if(count>0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Rule getRule(Integer id) throws DaoException {
		try {
			Connection conn=ConnectionFactory.getInstance().getConnection();

			String sql = "select * from rule where id = ?";
			ResultSetHandler<Rule> rsh = new BeanHandler<Rule>(Rule.class);
			rule=(Rule)qr.query(conn, sql,rsh,id);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rule;
	}

	@Override
	public PageModel<Rule> getPageModel(int pageNo, int pageSize) throws DaoException {
		PageModel<Rule> model=null;
		try {
			Connection conn=ConnectionFactory.getInstance().getConnection();

		
		//准备sql
		String totalcount_sql="select count(id) from rule";
		//查询总的记录 ScalarHandler:第一行第一列的值
		ResultSetHandler<Long> rsh=new ScalarHandler<Long>();
		
		Integer totalcount=qr.query(conn, totalcount_sql, rsh).intValue();
		if(totalcount>0){
			model=new PageModel<Rule>();
			model.setTotalcount(totalcount);
			//分页查询
			String sql="select id,pid,size from rule order by id desc limit ?,?";
			Object[] params={(pageNo-1)*pageSize,pageSize};
			List<Rule> rules=qr.query(conn, sql, new BeanListHandler<Rule>(Rule.class),params);
			model.setDatas(rules);
		}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("分页查询出错",e);
		}finally{
			DbUtils.closeQuietly(conn);
		}
		return model;
	}
	

}
