package com.neusoft.entity;

import java.io.Serializable;

public class ConsumerInfo implements Serializable{


	private static final long serialVersionUID = -2017029711683402159L;

	
	private Integer id;
	private Integer aid;//����ʺ�id������account_consumer���е�id
	private String nickname;//�û��ǳ�
	private Double money;//�������
	private String lasttime;//�������ʱ��
	public ConsumerInfo() {
		super();
	}
	public ConsumerInfo(Integer id, Integer aid, String nickname, Double money, String lasttime) {
		super();
		this.id = id;
		this.aid = aid;
		this.nickname = nickname;
		this.money = money;
		this.lasttime = lasttime;
	}
	public ConsumerInfo(Integer aid, String nickname, Double money, String lasttime) {
		super();
		this.aid = aid;
		this.nickname = nickname;
		this.money = money;
		this.lasttime = lasttime;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getAid() {
		return aid;
	}
	public void setAid(Integer aid) {
		this.aid = aid;
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
	public String getLasttime() {
		return lasttime;
	}
	public void setLasttime(String lasttime) {
		this.lasttime = lasttime;
	}
	@Override
	public String toString() {
		return "ConsumerInfo [id=" + id + ", aid=" + aid + ", nickname=" + nickname + ", money=" + money + ", lasttime="
				+ lasttime + "]";
	}
}
