package com.etc.dao;

import java.util.List;
import java.util.Set;

import com.etc.bean.Emp;
import com.etc.bean.Ord;
import com.etc.bean.PageBean;

public interface OrdDao {
	//获取所有订单信息
	public List<Ord> getAllOrd();
	//修改或增加订单信息
	public void updateOrAddOrd(Ord o);
	//删除订单
	public void deleteOrd(int id);
	//根据ID获取订单信息
	public Ord getOrdById(int id);
	//获取订单总数量
	public long getCount();
	//分页查询订单
	public List<Ord> getAllByPage(PageBean pb);
	//分页查询客户id为？的订单详情
	public List<Ord> getOrdByPage(PageBean pb,int cusId);
	//查询客户id为？的订单详情
	public List<Ord> getOrd(int cusId);
	//增加订单
	public void addOrd(Ord o);
}
