package com.neusoft.dao;

import java.util.List;

import com.neusoft.entity.PageModel;
import com.neusoft.entity.Rule;

public interface RuleDao {
	//查询所有规格信息
	public List<Rule> getRuleList();
	//添加商品
	public boolean addRule(Rule rule) throws DaoException;
	//删除商品
	public boolean deleteRule(Integer id) throws DaoException;
	//修改商品
	public boolean updateRule(Rule rule) throws DaoException;
	//查询商品
	public Rule getRule(Integer id) throws DaoException;
	//分页
	public PageModel<Rule> getPageModel(int pageNo,int pageSize) throws DaoException;
}
