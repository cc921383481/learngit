package com.neusoft.dao;

import java.util.List;

import com.neusoft.entity.PageModel;
import com.neusoft.entity.Rule;

public interface RuleDao {
	//��ѯ���й����Ϣ
	public List<Rule> getRuleList();
	//�����Ʒ
	public boolean addRule(Rule rule) throws DaoException;
	//ɾ����Ʒ
	public boolean deleteRule(Integer id) throws DaoException;
	//�޸���Ʒ
	public boolean updateRule(Rule rule) throws DaoException;
	//��ѯ��Ʒ
	public Rule getRule(Integer id) throws DaoException;
	//��ҳ
	public PageModel<Rule> getPageModel(int pageNo,int pageSize) throws DaoException;
}
