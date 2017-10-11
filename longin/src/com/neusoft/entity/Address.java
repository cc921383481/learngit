package com.neusoft.entity;

import java.io.Serializable;

public class Address implements Serializable{
	
	private static final long serialVersionUID = -1677310025772007019L;
	private Integer id;
	private String name;
	private Integer parentid;
	
	private String shname;
	private String sname;
	
	public Address() {
		super();
	}
	
	public Address(Integer id, String shname, String sname) {
		super();
		this.id = id;
		this.shname = shname;
		this.sname = sname;
	}

	public Address(Integer id, String name, Integer parentid) {
		super();
		this.id = id;
		this.name = name;
		this.parentid = parentid;
	}
	public Address(String name, Integer parentid) {
		super();
		this.name = name;
		this.parentid = parentid;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getParentid() {
		return parentid;
	}

	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}

	public String getShname() {
		return shname;
	}

	public void setShname(String shname) {
		this.shname = shname;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", shname=" + shname + ", sname=" + sname + "]";
	}
	
}

