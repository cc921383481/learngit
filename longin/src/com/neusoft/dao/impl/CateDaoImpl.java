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

import com.neusoft.dao.CateDao;
import com.neusoft.dao.DaoException;
import com.neusoft.entity.Cate;
import com.neusoft.entity.PageModel;
import com.neusoft.utils.ConnectionFactory;

public class CateDaoImpl implements CateDao {
	Connection conn=null;
	QueryRunner qr=new QueryRunner();
	Cate cate=null;
	PreparedStatement pstmt = null;
    ResultSet rs = null;
    List<Cate> cateList=new ArrayList<Cate>();
    List<Cate>  childList=null;
	@Override
	public boolean addcate(Cate ca)throws DaoException {	
		 conn=ConnectionFactory.getInstance().getConnection();
		try {
			String sql="insert into cate(cname,pid) values(?,?)";		
			Object[] params= {ca.getCname(),ca.getPid()};
			int count=qr.update(conn, sql, params);
			if(count>0) {
				return true;
			    }
			}catch (SQLException e) {
				e.printStackTrace();
				throw new DaoException("���ʧ��",e);		
			}finally{
				DbUtils.closeQuietly(conn);			
			}		
		return false;
	}

	@Override
	public Cate getCate(int cid) throws DaoException {
		Connection conn = null;
		Cate c=new Cate();
		try {
			conn = ConnectionFactory.getInstance().getConnection();
			String sql = "select * from cate where cid=?";
			ResultSetHandler<Cate> rsh = new BeanHandler<Cate>(Cate.class);

			c= qr.query(conn, sql, rsh, cid);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DaoException("�鿴��Ʒʧ��", e);
		}
		return c;
	}
	@Override
	public List<Cate> checkCateList() {
		try {
			conn=ConnectionFactory.getInstance().getConnection();
			String sql="select cid,cname,pid from cate order by cid desc";
			ResultSetHandler<List<Cate>> rs= new BeanListHandler<Cate>(Cate.class);
		    
		    cateList = qr.query(conn,sql, rs);
		} catch (SQLException e) {
			e.printStackTrace();
		
		}finally{
			DbUtils.closeQuietly(conn);
		}
		
		return cateList;
	}
	@Override
	public boolean updateCate(Cate ca) {
		Connection conn=null;
		 try {
			conn=ConnectionFactory.getInstance().getConnection();
			String sql = "update cate set pid=?,cname=? where cid=?;";
			Object[] params={ca.getPid(),ca.getCname(),ca.getCid()};
			int count=qr.update (conn, sql, params);
			
			if(count>0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			 throw new DaoException("�޸���Ʒʧ��", e);
		}finally {
			DbUtils.closeQuietly(conn);
		}
		
		
		
		return false;
	}

	
	//ɾ������
		@Override
		public Cate rearchId(int cid) {
			try {
				conn=ConnectionFactory.getInstance().getConnection();
				String sql = "select * from cate where cid =?";
				ResultSetHandler<Cate> rs = new BeanHandler<>(Cate.class);
				Cate tb = null;
					tb = qr.query(conn, sql, rs, cid);
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
		//ɾ��������
		@Override
		public void delRegion(Integer cid) {
			try
			{
				conn=ConnectionFactory.getInstance().getConnection();
				//ConnectionFactory.beginTransaction(conn);
				Cate currentNode = rearchId(cid);
				recursionDelNode(conn,cid);
				//������ڵ���û���ӽڵ�
				if(currentNode.getPid()==0)
				{
					currentNode.setPid(0);
				}
				//�ύ����
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
		 * �ݹ�ɾ��
		 * @param conn
		 * @param cid
		 */
		private void recursionDelNode(Connection conn, Integer cid)throws SQLException {
			String sql ="select cid,cname,pid from cate where pid = ?";
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try{
				conn=ConnectionFactory.getInstance().getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, cid);
				rs = pstmt.executeQuery();
				while(rs.next()){
					if(0==rs.getInt("pid")){
						recursionDelNode(conn, rs.getInt("cid"));
					}
					delNode(conn,rs.getInt("cid"));
				}
				//ɾ������
				delNode(conn,cid);
			
			}finally{
				DbUtils.closeQuietly(rs);
				DbUtils.closeQuietly(pstmt);
			}
			
		}
		/**
		 * ɾ���ڵ�
		 * @param conn
		 * @param int1
		 */
		private void delNode(Connection conn, int cid)throws SQLException {
			String sql ="delete from cate where cid=?";
			PreparedStatement pstmt  = null;
			try{
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, cid);
				pstmt.executeUpdate();
			}finally{
				DbUtils.closeQuietly(pstmt);
			}
		}

		@Override
		public void deleteCate(int cid) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public PageModel<Cate> getPageModel(int pageNo, int pageSize) {

			PageModel<Cate> model=null;
			try {
				conn=ConnectionFactory.getInstance().getConnection();
			
			//׼��sql
			String totalcount_sql="select count(cid) from cate";
			//��ѯ�ܵļ�¼ ScalarHandler:��һ�е�һ�е�ֵ
			ResultSetHandler<Long> rsh=new ScalarHandler<>();
			
			Integer totalcount=qr.query(conn, totalcount_sql, rsh).intValue();
			if(totalcount>0){
				model=new PageModel<Cate>();
				model.setTotalcount(totalcount);
				//��ҳ��ѯ
				String sql="select cid,cname,pid from cate order by cid desc limit ?,?";
				Object[] params={(pageNo-1)*pageSize,pageSize};
				List<Cate> cates=qr.query(conn, sql, new BeanListHandler<Cate>(Cate.class),params);
				model.setDatas(cates);
			}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new DaoException("��ҳ��ѯ����",e);
			}finally{
				DbUtils.closeQuietly(conn);
			}
			return model;
		}


}
