package com.etc.bean;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Cus {
	private int cusId;// 顾客id
	private String cusName;// 顾客姓名
	private String cusCid;// 顾客身份证
	/*
	 * private Set<Ord> olist=new HashSet<Ord>(); public Set<Ord> getOlist() {
	 * return olist; }
	 * 
	 * public void setOlist(Set<Ord> olist) { this.olist = olist; }
	 */

	public Cus(String cusName, String cusCid) {
		super();
		this.cusName = cusName;
		this.cusCid = cusCid;
	}

	public Cus() {
		super();
	}

	public int getCusId() {
		return cusId;
	}

	public void setCusId(int cusId) {
		this.cusId = cusId;
	}

	public String getCusName() {
		return cusName;
	}

	public void setCusName(String cusName) {
		this.cusName = cusName;
	}

	public String getCusCid() {
		return cusCid;
	}

	public void setCusCid(String cusCid) {
		this.cusCid = cusCid;
	}

	@Override
	public String toString() {
		return "Cus [cusId=" + cusId + ", cusName=" + cusName + ", cusCid=" + cusCid + "]";
	}

	/*
	 * @Override public String toString() { return "Cus [cusId=" + cusId +
	 * ", cusName=" + cusName + ", cusCid=" + cusCid + ", olist=" + olist.size() +
	 * "]"; }
	 */

}
