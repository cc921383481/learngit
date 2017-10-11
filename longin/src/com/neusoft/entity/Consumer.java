package com.neusoft.entity;

import java.io.Serializable;

public class Consumer implements Serializable{

	private static final long serialVersionUID = -3149040892887310059L;

	private Integer id;
	private String loginname;//买家用户名
	private String password;//密码
	private long registertime;//注册时间
	private long lastlogintime;//最后登录时间
	private String ip;//ip地址
	
	private String nickname;//用户昵称
	private Double money;//订单金额
	private long lasttime;//最近消费时间
	public Consumer() {
		super();
	}
	public Consumer(Integer id, String loginname, String password, long registertime, long lastlogintime,
			String ip, String nickname, Double money, long lasttime) {
		super();
		this.id = id;
		this.loginname = loginname;
		this.password = password;
		this.registertime = registertime;
		this.lastlogintime = lastlogintime;
		this.ip = ip;
		this.nickname = nickname;
		this.money = money;
		this.lasttime = lasttime;
	}
	public Consumer(String loginname, String password, long registertime, long lastlogintime, String ip,
			String nickname, Double money, long lasttime) {
		super();
		this.loginname = loginname;
		this.password = password;
		this.registertime = registertime;
		this.lastlogintime = lastlogintime;
		this.ip = ip;
		this.nickname = nickname;
		this.money = money;
		this.lasttime = lasttime;
	}
	
	public Consumer(String loginname, String password, long registertime, long lastlogintime, String ip) {
		super();
		this.loginname = loginname;
		this.password = password;
		this.registertime = registertime;
		this.lastlogintime = lastlogintime;
		this.ip = ip;
	}
	
	public Consumer(String loginname, String password) {
		super();
		this.loginname = loginname;
		this.password = password;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getRegistertime() {
		return registertime;
	}
	public void setRegistertime(long registertime) {
		this.registertime = registertime;
	}
	public long getLastlogintime() {
		return lastlogintime;
	}
	public void setLastlogintime(long lastlogintime) {
		this.lastlogintime = lastlogintime;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Double getMoney() {
		return money;
	}
	public void setMoney(Double money) {
		this.money = money;
	}
	public long getLasttime() {
		return lasttime;
	}
	public void setLasttime(long lasttime) {
		this.lasttime = lasttime;
	}
	@Override
	public String toString() {
		return "Consumer [id=" + id + ", loginname=" + loginname + ", password=" + password + ", registertime="
				+ registertime + ", lastlogintime=" + lastlogintime + ", ip=" + ip + ", nickname=" + nickname
				+ ", money=" + money + ", lasttime=" + lasttime + "]";
	}
}
