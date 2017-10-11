package com.neusoft.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.neusoft.dao.OrderinfoDao;

import com.neusoft.entity.Orderinfo;
import com.neusoft.entity.PageModel;
import com.neusoft.utils.ConnectionFactory;

public class OrderinfoDaoImpl implements OrderinfoDao {
	Connection conn=null;
	QueryRunner qr=new QueryRunner();
	PreparedStatement pstmt = null;
    ResultSet rs = null;
	
	@Override
	public PageModel<Orderinfo> getPageModel(int pageNo, int pageSize) {
		PageModel<Orderinfo> model=null;
		Connection conn=null;
		try{
			conn = ConnectionFactory.getInstance().getConnection();
			String totalcount_sql="select count(orderid) from product_orderinfo";
			
			ResultSetHandler<Long> rsh=new ScalarHandler<Long>();
			
			Integer totalcount=qr.query(conn,totalcount_sql,rsh).intValue();
			
			if(totalcount>0) {
				//分页查询
				
				model=new PageModel<Orderinfo>();
				model.setTotalcount(totalcount);
				
				String sql=" select ss.id id,ss.orderno orderno,ss.orderstatus orderstatus,ss.paystatus paystatus,ss.ordertime ordertime,ss.paytime paytime,ss.mask mask,ss.name cname,ss.addr addr,ss.phone phone,p.id p_id,p.pname p_pname,p.cid p_cid,p.pno p_pno,p.pic p_pic,p.price p_price,p.pdetail p_pdetail\r\n" + 
						"from\r\n" + 
						"(\r\n" + 
						"select o.id,o.orderno,o.orderstatus,o.paystatus,o.ordertime,o.paytime,o.mask,ca.name,ca.addr,ca.phone\r\n" + 
						"from orderinfo o\r\n" + 
						"join consumer_addr ca\r\n" + 
						"where o.addrinfo=ca.id  \r\n" + 
						" ) ss\r\n" + 
						" join product_orderinfo po\r\n" + 
						"join product p\r\n" + 
						" where po.orderid=ss.id and po.productid=p.id\r\n" + 
						"LIMIT ?,?";
				ResultSetHandler<List<Orderinfo>> rsh01=new BeanListHandler<Orderinfo>(Orderinfo.class);
				Object[] params= {(pageNo-1)*pageSize,pageSize};
				List<Orderinfo> orders=qr.query(conn,sql,rsh01,params);
				//将pid新添加的为null的添加到集合里
				for(int i=0;i<orders.size();i++) {
					if(orders.get(i).getOrderstatus()==1) {
						orders.get(i).setOrderstatusname("待支付");
					}
					if(orders.get(i).getOrderstatus()==2) {
						orders.get(i).setOrderstatusname("已付款");
					}
					if(orders.get(i).getOrderstatus()==3) {
						orders.get(i).setOrderstatusname("已发货");
					}
					if(orders.get(i).getOrderstatus()==4) {
						orders.get(i).setOrderstatusname("已完成");
					}
				}
				model.setDatas(orders);
			}
			

		}catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			DbUtils.closeQuietly(conn);
		}
		return model;
	}

	@Override
	public PageModel<Orderinfo> getPageModelStatus(int pageNo, int pageSize, int searchType) {
		PageModel<Orderinfo> model=null;
		
		try{
			conn = ConnectionFactory.getInstance().getConnection();
			String totalcount_sql="select count(id)\r\n" + 
					"from product_orderinfo po\r\n" + 
					"join orderinfo o\r\n" + 
					"where po.orderid=o.id and orderstatus=?";
		
			ResultSetHandler<Long> rsh=new ScalarHandler<Long>();
			
			Integer totalcount=qr.query(conn,totalcount_sql,rsh,searchType).intValue();
			
			if(totalcount>0) {
				//分页查询
				
				model=new PageModel<Orderinfo>();
				model.setTotalcount(totalcount);
				
				String sql=" select ss.id id,ss.orderno orderno,ss.orderstatus orderstatus,ss.paystatus paystatus,ss.ordertime ordertime,ss.paytime paytime,ss.mask mask,ss.name name,ss.addr addr,ss.phone phone,p.id p_id,p.pname p_pname,p.cid p_cid,p.pno p_pno,p.pic p_pic,p.price p_price,p.pdetail p_pdetail\r\n" + 
						"from\r\n" + 
						"(\r\n" + 
						"select o.id,o.orderno,o.orderstatus,o.paystatus,o.ordertime,o.paytime,o.mask,ca.name,ca.addr,ca.phone\r\n" + 
						"from orderinfo o\r\n" + 
						"inner join consumer_addr ca\r\n" + 
						"on o.addrinfo=ca.id  \r\n" + 
						" ) ss\r\n" + 
						" join product_orderinfo po\r\n" + 
						"join product p\r\n" + 
						" on po.orderid=ss.id and po.productid=p.id and ss.orderstatus=?\r\n" + 
						"LIMIT ?,?";
//				String sql="select ss.id id,ss.orderno orderno,ss.orderstatus orderstatus,ss.paystatus paystatus,ss.ordertime ordertime,ss.paytime paytime,ss.mask mask,ss.name name,ss.addr addr,ss.phone phone,p.id p_id,p.pname p_pname,p.cid p_cid,p.pno p_pno,p.pic p_pic,p.price p_price,p.pdetail p_pdetail from(select o.id,o.orderno,o.orderstatus,o.paystatus,o.ordertime,o.paytime,o.mask,ca.name,ca.addr,ca.phone from orderinfo o join consumer_addr ca where o.addrinfo=ca.id) ss join product_orderinfo po join product p where po.orderid=ss.id and po.productid=p.id limit ?,?";
				ResultSetHandler<List<Orderinfo>> rsh01=new BeanListHandler<Orderinfo>(Orderinfo.class);
				Object[] params= {searchType,(pageNo-1)*pageSize,pageSize};
				List<Orderinfo> orders=qr.query(conn,sql,rsh01,params);
				//将pid新添加的为null的添加到集合里
				for(int i=0;i<orders.size();i++) {
					if(orders.get(i).getOrderstatus()==1) {
						orders.get(i).setOrderstatusname("待支付");
					}
					if(orders.get(i).getOrderstatus()==2) {
						orders.get(i).setOrderstatusname("已付款");
					}
					if(orders.get(i).getOrderstatus()==3) {
						orders.get(i).setOrderstatusname("已发货");
					}
					if(orders.get(i).getOrderstatus()==4) {
						orders.get(i).setOrderstatusname("已完成");
					}
				}
				model.setDatas(orders);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			DbUtils.closeQuietly(conn);
		}
		return model;
	}

	
}
