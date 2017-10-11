package com.neusoft.entity;

import java.io.Serializable;

public class Account  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6301075639694428811L;

	private int id;//主键
	private String username;//账号名
	private String password;//密码
	private String ip;//客户端Ip
	private long logindate;//最近登录时间
	
	
	
	
	
	public Account() {
		super();
	}
	public Account(String username, String password, String ip) {
		super();
		this.username = username;
		this.password = password;
		this.ip = ip;
	}
	public Account(String username, String password, String ip, long logindate) {
		super();
		this.username = username;
		this.password = password;
		this.ip = ip;
		this.logindate = logindate;
	}
	public Account(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	
	
	public long getLogindate() {
		return logindate;
	}
	public void setLogindate(long logindate) {
		this.logindate = logindate;
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", username=" + username + ", password=" + password + ", ip=" + ip + ", date="
				+ logindate + "]";
	}
	
	
	
	
	
	
	
}
