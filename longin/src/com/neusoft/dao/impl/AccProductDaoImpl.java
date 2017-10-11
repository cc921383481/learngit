package com.neusoft.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.neusoft.dao.AccProductDao;
import com.neusoft.dao.DaoException;
import com.neusoft.entity.AccProduct;
import com.neusoft.entity.PageModel;
import com.neusoft.utils.ConnectionFactory;

public class AccProductDaoImpl implements AccProductDao {
	Connection conn=null;
	QueryRunner qr=new QueryRunner();
	AccProduct accProduct=null;
	Statement st=null;
	PreparedStatement pstmt = null;
    ResultSet rs = null;
    List<AccProduct> accProductList=new ArrayList<AccProduct>();
	@Override
	public List<AccProduct> getAccProductList() {
		try {
			 conn=ConnectionFactory.getInstance().getConnection();

			String sql="select * from account_product order by id";
			ResultSetHandler<List<AccProduct>> rs = new BeanListHandler<AccProduct>(AccProduct.class);
			accProductList= qr.query(conn, sql ,rs);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				DbUtils.closeQuietly(conn);
			}
			
			return accProductList;
	}

	@Override
	public boolean addAccProduct(AccProduct accProduct) throws DaoException {
		try {
			 conn=ConnectionFactory.getInstance().getConnection();
			String sql= "insert into account_product(loginname,password,registertime,lastlogintime,ip) values(?,?,?,?,?)";
			int count = qr.update(conn, sql, accProduct.getLoginname(),accProduct.getPassword(),accProduct.getRegistertime(),accProduct.getLastlogintime(),accProduct.getIp());
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
	public boolean deleteAccProduct(Integer id) throws DaoException {
		try {
			 conn=ConnectionFactory.getInstance().getConnection();
			String sql = "delete from account_product where id = ?";
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
	public boolean updateAccProduct(AccProduct accProduct) throws DaoException {
		try {
			 conn=ConnectionFactory.getInstance().getConnection();
			String sql = "update account_product  set loginname=?,password=?,registertime=?,lastlogintime=?,ip=? where id=?";
			int count = qr.update(conn, sql, accProduct.getLoginname(),accProduct.getPassword(),accProduct.getRegistertime(),accProduct.getLastlogintime(),accProduct.getIp(),accProduct.getId());
			if(count>0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public AccProduct getAccProduct(Integer id) throws DaoException {
		try {
			 conn=ConnectionFactory.getInstance().getConnection();
			String sql = "select * from account_product where id = ?";
			ResultSetHandler<AccProduct> rsh = new BeanHandler<AccProduct>(AccProduct.class);
			accProduct=(AccProduct)qr.query(conn, sql,rsh,id);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accProduct;
	}

	@Override
	public PageModel<AccProduct> getPageModel(int pageNo, int pageSize) throws DaoException {
		
		PageModel<AccProduct> model=null;
		try {
			 conn=ConnectionFactory.getInstance().getConnection();
		
		//准备sql
		String totalcount_sql="select count(id) from account_product";
		//查询总的记录 ScalarHandler:第一行第一列的值
		ResultSetHandler<Long> rsh=new ScalarHandler<Long>();
		
		Integer totalcount=qr.query(conn, totalcount_sql, rsh).intValue();
		if(totalcount>0){
			model=new PageModel<AccProduct>();
			model.setTotalcount(totalcount);
			//分页查询
			String sql="select id,loginname,password,registertime,lastlogintime,ip from account_product order by id desc limit ?,?";
			Object[] params={(pageNo-1)*pageSize,pageSize};
			List<AccProduct> accProducts=qr.query(conn, sql, new BeanListHandler<AccProduct>(AccProduct.class),params);
			model.setDatas(accProducts);
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
