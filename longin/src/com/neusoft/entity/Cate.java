package com.neusoft.entity;

import java.io.Serializable;
import java.util.List;

public class Cate implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5245375642801391271L;
	
	

	private int cid;  
	private String cname;//类别名称
	private int pid;
	private List<Cate> childList; //子类的集合，包括cid,cname,pid
	
	public Cate(){
		
	}

	public Cate(int cid, String cname, int pid, List<Cate> childList) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.pid = pid;
		this.childList = childList;
	}

	public Cate(int cid, String cname, int pid) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.pid = pid;
	}
	
	public Cate(String cname, int pid) {
		super();
		this.cname = cname;
		this.pid = pid;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public List<Cate> getChildList() {
		return childList;
	}

	public void setChildList(List<Cate> childList) {
		this.childList = childList;
	}

	@Override
	public String toString() {
		return "Cate [cid=" + cid + ", cname=" + cname + ", pid=" + pid + ", childList=" + childList + "]";
	}
    
	
	
	
}
