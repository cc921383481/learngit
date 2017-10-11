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

import com.neusoft.dao.DaoException;
import com.neusoft.dao.ProductDao;
import com.neusoft.entity.PageModel;
import com.neusoft.entity.Product;
import com.neusoft.utils.ConnectionFactory;


public class ProductDaoImpl implements ProductDao{
	Connection conn=null;
	QueryRunner qr=new QueryRunner();
	Product Product=null;
	PreparedStatement pstmt = null;
	Statement st=null;
    ResultSet rs = null;
    List<Product> productList=new ArrayList<Product>();
	@Override
	public List<Product> getProductList() {
		try {
			conn = ConnectionFactory.getInstance().getConnection();
			String sql = "select id,pname,cid,pno,pic,price,online,pdetail from product order by id desc ";
			ResultSetHandler<List<Product>> rs = new BeanListHandler<Product>(Product.class);
			productList= qr.query(conn, sql ,rs);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				DbUtils.closeQuietly(conn);
			}
			
			return productList;
	}

	@Override
	public boolean addProduct(Product product) {
		try {
			conn = ConnectionFactory.getInstance().getConnection();
			String sql="insert into product(pname,cid,pno,pic,price,online,pdetail) values(?,?,?,?,?,?,?)";
			int	count=qr.update(conn, sql,product.getPname(),product.getCid(),product.getPno(),product.getPic(),product.getPrice(),product.getOnline(),product.getPdetail());
			if(count>0){
				return true;
			}
		}catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("添加商品出错。。。");
		}finally{
			DbUtils.closeQuietly(conn);
		}
		return false;
	}

	@Override
	public Product getproductById(Integer id) {
		Product product=null;
		try {
			conn = ConnectionFactory.getInstance().getConnection();
			String str = "select * from product where id = ?";
			ResultSetHandler<Product> bh = new BeanHandler<Product>(Product.class);
			Object[] objs = {id};
			product=qr.query(conn, str, bh, objs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return product;
	}

	@Override
	public PageModel<Product> getPageModel(int pageNo, int pageSize) {
		PageModel<Product> model=null;
		try {
			conn = ConnectionFactory.getInstance().getConnection();
		
		//准备sql
		String totalcount_sql="select count(id) from product";
		//查询总的记录 ScalarHandler:第一行第一列的值
		ResultSetHandler<Long> rsh=new ScalarHandler<>();
		
		Integer totalcount=qr.query(conn, totalcount_sql, rsh).intValue();
		if(totalcount>0){
			model=new PageModel<Product>();
			model.setTotalcount(totalcount);
			//分页查询
			String sql="select id,pname,cid,pno,pic,price,online,pdetail from product order by id desc limit ?,?";
			Object[] params={(pageNo-1)*pageSize,pageSize};
			List<Product> products=qr.query(conn, sql, new BeanListHandler<Product>(Product.class),params);
			model.setDatas(products);
		}
		} catch (SQLException e) {
			e.printStackTrace();
//			throw new DaoException("分页查询出错",e);
		}finally{
			DbUtils.closeQuietly(conn);
		}
		return model;
	}

	@Override
	public List<Product> getproductByName(String name) {
		try {
			conn = ConnectionFactory.getInstance().getConnection();
			String sql = "select id,pname,cid,pno,pic,price,online,pdetail from product where pname = ?";
			ResultSetHandler<List<Product>> rs = new BeanListHandler<Product>(Product.class);
				Object[] objs = {name};
				productList = qr.query(conn, sql ,rs, objs);
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				DbUtils.closeQuietly(conn);
			}
			
		 return productList;
	}
	@Override
	public boolean updateProduct(Product product) {
		try {
			Connection conn= null;
			conn = ConnectionFactory.getInstance().getConnection();
			String sql="update product set id=?, pname=?, cid=?,pno=?,pic=?,price=?,online=?,pdetail=? where id = ?";
			int i =qr.update(conn,sql,product.getId(),product.getPname(),product.getCid(),product.getPno(),product.getPic(),product.getPrice(),product.getOnline(),product.getPdetail(),product.getId());
			if(i>0){
				System.out.println("修改成功");
				return true;
			}else{
				System.out.println("修改失败");
			}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				DbUtils.closeQuietly(conn);
			}
		return false;
	}

	@Override
	public boolean deleteProduct(Integer id) {
		try {
			conn = ConnectionFactory.getInstance().getConnection();
			 String sql="delete from product where id=?"; 
				int count=qr.update(conn,sql,id);
				if (count>0) {
					return true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				DbUtils.closeQuietly(conn);
			}
		return false;
	}

	@Override
	public void deleteProductList(String[] productId) {
		 try {
			 conn = ConnectionFactory.getInstance().getConnection();
	            st=conn.createStatement();   
	            int Id = 0;
	            for (int i = 0; i < productId.length; i++) {
	                // 循环遍历集合中的元素，然后逐个删除
	                Id = Integer.parseInt(productId[i]);
	                String sql = "delete from product where id="+Id+"";
	               st.executeUpdate(sql);
	            }
	
	        } catch (SQLException e) {
	
	            e.printStackTrace();
	        } finally {
	            // 执行完关闭数据库
	        	DbUtils.closeQuietly(conn);
	        }
		
	}
	
	
}
	



