package com.neusoft.entity;

import java.io.Serializable;

public class Rule implements Serializable{


	private static final long serialVersionUID = 3632051636385719499L;

	private Integer id;
	private Integer pid;
	private String size;
	private Product product;
	public Rule() {
		super();
	}
	public Rule(Integer id, Integer pid, String size) {
		super();
		this.id = id;
		this.pid = pid;
		this.size = size;
	}
	
	public Rule(Integer pid, String size) {
		super();
		this.pid = pid;
		this.size = size;
	}
	public Rule(Integer id, Integer pid, String size, Product product) {
		super();
		this.id = id;
		this.pid = pid;
		this.size = size;
		this.product = product;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	@Override
	public String toString() {
		return "Rule [id=" + id + ", pid=" + pid + ", size=" + size +"]";
	}
	
}
