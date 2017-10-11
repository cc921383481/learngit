package com.neusoft.entity;

import java.io.Serializable;

public class Order implements Serializable {

	private static final long serialVersionUID = -4477570870342479180L;
	private int id;
	private String orderno;//订单编号
	private int orderstatus;//订单状态     1:未付款 2:已付款 3:已发货 4:已完成
	private String orderstatusname;

	private int paystatus;//1:线上支付  2：货到付款
	private String paystatusname;
	
	private String ordertime;//下单时间
	private String paytime;//支付时间
	private String mask;//备注信息
	private String name;//收货人姓名
	private String addr;//收货人地址
	private long phone;//联系方式
	private int p_id;//商品的id
	private String p_pname;//商品名称
	private int p_cid;//商品类别
	private String p_pno;//商品编号
	private String p_pic;//商品图片
	private double p_price;//商品价格
	private String p_pdetail;//商品详情
	public String getOrderstatusname() {
		return orderstatusname;
	}
	public void setOrderstatusname(String orderstatusname) {
		this.orderstatusname = orderstatusname;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOrderno() {
		return orderno;
	}
	public void setOrderno(String orderno) {
		this.orderno = orderno;
	}
	public int getOrderstatus() {
		return orderstatus;
	}
	public void setOrderstatus(int orderstatus) {
		this.orderstatus = orderstatus;
	}
	public int getPaystatus() {
		return paystatus;
	}
	public void setPaystatus(int paystatus) {
		this.paystatus = paystatus;
	}
	public String getOrdertime() {
		return ordertime;
	}
	public void setOrdertime(String ordertime) {
		this.ordertime = ordertime;
	}
	public String getPaytime() {
		return paytime;
	}
	public void setPaytime(String paytime) {
		this.paytime = paytime;
	}
	public String getMask() {
		return mask;
	}
	public void setMask(String mask) {
		this.mask = mask;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public int getP_id() {
		return p_id;
	}
	public void setP_id(int p_id) {
		this.p_id = p_id;
	}
	public String getP_pname() {
		return p_pname;
	}
	public void setP_pname(String p_pname) {
		this.p_pname = p_pname;
	}
	public int getP_cid() {
		return p_cid;
	}
	public void setP_cid(int p_cid) {
		this.p_cid = p_cid;
	}
	public String getP_pno() {
		return p_pno;
	}
	public void setP_pno(String p_pno) {
		this.p_pno = p_pno;
	}
	public String getP_pic() {
		return p_pic;
	}
	public void setP_pic(String p_pic) {
		this.p_pic = p_pic;
	}
	public double getP_price() {
		return p_price;
	}
	public void setP_price(double p_price) {
		this.p_price = p_price;
	}
	public String getP_pdetail() {
		return p_pdetail;
	}
	public void setP_pdetail(String p_pdetail) {
		this.p_pdetail = p_pdetail;
	}
	
	public String getPaystatusname() {
		return paystatusname;
	}
	public void setPaystatusname(String paystatusname) {
		this.paystatusname = paystatusname;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", orderno=" + orderno + ", orderstatus=" + orderstatus + ", orderstatusname="
				+ orderstatusname + ", paystatus=" + paystatus + ", paystatusname=" + paystatusname + ", ordertime="
				+ ordertime + ", paytime=" + paytime + ", mask=" + mask + ", name=" + name + ", addr=" + addr
				+ ", phone=" + phone + ", p_id=" + p_id + ", p_pname=" + p_pname + ", p_cid=" + p_cid + ", p_pno="
				+ p_pno + ", p_pic=" + p_pic + ", p_price=" + p_price + ", p_pdetail=" + p_pdetail + "]";
	}
	
}
