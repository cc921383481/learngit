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

import com.neusoft.dao.AddressDao;
import com.neusoft.dao.DaoException;
import com.neusoft.entity.Address;
import com.neusoft.entity.PageModel;
import com.neusoft.utils.ConnectionFactory;

public class AddressDaoImpl implements AddressDao {
	Connection conn=null;
	QueryRunner qr=new QueryRunner();
	Address address=null;
	PreparedStatement pstmt = null;
    ResultSet rs = null;
    List<Address> addressList=new ArrayList<Address>();
	@Override
	public List<Address> getAddressList() {
		// SELECT a1.id,a1.name,a2.name FROM address AS a1 LEFT JOIN address AS  a2 ON a2.parentid =a1.id;
		try {
			 conn=ConnectionFactory.getInstance().getConnection();
			String sql="SELECT * FROM address";
			ResultSetHandler<List<Address>> rs = new BeanListHandler<Address>(Address.class);
			addressList= qr.query(conn, sql ,rs);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				DbUtils.closeQuietly(conn);
			}
			return addressList;
	}

	@Override
	public boolean addAddress(Address address) throws DaoException {
		try {
			 conn=ConnectionFactory.getInstance().getConnection();
			String sql="insert into address(name,parentid) values(?,?)";
			int	count=qr.update(conn, sql,address.getName(),address.getParentid() );
			if(count>0){
				return true;
			}
		}catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("添加分类出错。。。");
		}finally{
			DbUtils.closeQuietly(conn);
		}
		return false;
	}

	@Override
	public boolean deleteAddress(int id) throws DaoException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateAddress(Address address) throws DaoException {
		try {
			 conn=ConnectionFactory.getInstance().getConnection();
			String sql = "update (address AS a1 right JOIN address AS  a2 ON a2.parentid =a1.id) set a2.name=?,a1.name=? where a2.id=?";
			int count = qr.update(conn, sql, address.getName(),address.getParentid(),address.getId());
			if(count>0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public Address getAddress(Integer id) throws DaoException {
		try {
			 conn=ConnectionFactory.getInstance().getConnection();
			String sql = "SELECT a2.id id,a1.name shname,a2.name sname  FROM (address AS a1 right JOIN address AS  a2 ON a2.parentid =a1.id) where a2.id = ?";
			ResultSetHandler<Address> rsh = new BeanHandler<Address>(Address.class);
			address=(Address)qr.query(conn, sql,rsh,id);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return address;
	}

	@Override
	public PageModel<Address> getPageModel(int pageNo, int pageSize) throws DaoException {
		PageModel<Address> model=null;
		try {
			 conn=ConnectionFactory.getInstance().getConnection();
		
		//准备sql
		String totalcount_sql="select count(id) from address ";
		//查询总的记录 ScalarHandler:第一行第一列的值
		ResultSetHandler<Long> rsh=new ScalarHandler<>();
		
		Integer totalcount=qr.query(conn, totalcount_sql, rsh).intValue();
		if(totalcount>0){
			model=new PageModel<Address>();
			model.setTotalcount(totalcount);
			//分页查询
			String sql="SELECT a2.id id,a1.name shname,a2.name sname  FROM address AS a1 right JOIN address AS  a2 ON a2.parentid =a1.id order by id desc limit ?,?";
			Object[] params={(pageNo-1)*pageSize,pageSize};
			List<Address> addresss=qr.query(conn, sql, new BeanListHandler<Address>(Address.class),params);
			
			model.setDatas(addresss);
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DaoException("分页查询出错",e);
		}finally{
			DbUtils.closeQuietly(conn);
		}
		return model;
	}
	
	    //删除分类
		@Override
		public Address rearchId(int id) {
			try {
				 conn=ConnectionFactory.getInstance().getConnection();
				String sql = "select * from address where id =?";
				ResultSetHandler<Address> rs = new BeanHandler<>(Address.class);
				Address tb = null;
					tb = qr.query(conn, sql, rs, id);
					if(tb!=null)
					{
						return tb;
					}
				} catch (SQLException e) {
					e.printStackTrace();
				} finally
				{
					DbUtils.closeQuietly(conn);
				}
			return null;
		}
		//删除主方法
		@Override
		public void delRegion(Integer id) {
			try
			{
				 conn=ConnectionFactory.getInstance().getConnection();
				//ConnectionFactory.beginTransaction(conn);
				Address currentNode = rearchId(id);
				recursionDelNode(conn,id);
				//如果父节点下没有子节点
				if(currentNode.getParentid()==0)
				{
					currentNode.setParentid(0);
				}
				//提交事务
				//ConnectionFactory.commitTransaction(conn);
			}catch(Exception e)
			{
				e.printStackTrace();
				//ConnectionFactory.rollbackTransaction(conn);
			}finally
			{
				//ConnectionFactory.resetConnection(conn);
				DbUtils.closeQuietly(conn);
			}
		}
		/**
		 * 递归删除
		 * @param conn
		 * @param cid
		 */
		private void recursionDelNode(Connection conn, Integer id)throws SQLException {
			String sql ="select id,name,parentid from address where parentid = ?";
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try{
				 conn=ConnectionFactory.getInstance().getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, id);
				rs = pstmt.executeQuery();
				while(rs.next()){
					if(0==rs.getInt("parentid")){
						recursionDelNode(conn, rs.getInt("id"));
					}
					delNode(conn,rs.getInt("id"));
				}
				//删除自身
				delNode(conn,id);
			
			}finally{
				DbUtils.closeQuietly(rs);
				DbUtils.closeQuietly(pstmt);
			}
			
		}
		/**
		 * 删除节点
		 * @param conn
		 * @param int1
		 */
		private void delNode(Connection conn, int id)throws SQLException {
			String sql ="delete from address where id=?";
			PreparedStatement pstmt  = null;
			try{
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, id);
				pstmt.executeUpdate();
			}finally{
				DbUtils.closeQuietly(pstmt);
			}
		}
	

}
