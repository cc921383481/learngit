package com.neusoft.entity;

import java.util.List;
/**
 * 分页实体类
 * @author Doe
 *
 * @param <T>
 */
public class PageModel<T> {
	private Integer totalcount;//总的记录数
	private List<T> datas;//当前数据
	private int totalPageSize;//总共页数
	private int pageNo;//当前第几页
	
	private int pageSize;// 每页上的条数
	
	public PageModel() {
		super();
	}
	public PageModel(Integer totalcount, List<T> datas) {
		super();
		this.totalcount = totalcount;
		this.datas = datas;
	}
	public Integer getTotalcount() {
		return totalcount;
	}
	public void setTotalcount(Integer totalcount) {
		this.totalcount = totalcount;
	}
	public List<T> getDatas() {
		return datas;
	}
	public void setDatas(List<T> datas) {
		this.datas = datas;
	}
	public int getTotalPageSize() {
		return totalPageSize;
	}
	public void setTotalPageSize(int totalPageSize) {
		this.totalPageSize = totalPageSize;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	
	
	
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	@Override
	public String toString() {
		return "PageModel [totalcount=" + totalcount + ", datas=" + datas + "]";
	}
	
}
