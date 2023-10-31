package com.myweb.entity;

import java.util.List;


//1�Զ�
public class Ftype {
	private Integer tid;
	private String tname;
	private List<Food> foodList;
		
	public List<Food> getFoodList() {
		return foodList;
	}
	public void setFoodList(List<Food> foodList) {
		this.foodList = foodList;
	}
	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	@Override
	public String toString() {
		return "Ftype [tid=" + tid + ", tname=" + tname + "]";
	}
	public Ftype(Integer tid, String tname) {
		super();
		this.tid = tid;
		this.tname = tname;
	}
	public Ftype() {
		super();
	}
	
}
