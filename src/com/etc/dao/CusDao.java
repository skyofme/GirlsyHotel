package com.etc.dao;

import java.util.List;

import com.etc.bean.Cus;
import com.etc.bean.Emp;
import com.etc.bean.PageBean;

public interface CusDao {
	//获取所有客户信息
	public List<Cus> getAllCus();
	//修改或增加客户信息
	public void updateOrAddCus(Cus c);
	//删除客户
	public void deleteCus(int id);
	//根据ID获取客户信息
	public Cus getCusById(int id);
	//获取用户总数量
	public long getCount();
	//分页查询用户
	public List<Cus> getAllByPage(PageBean pb);
	//根据名字获取客户信息
	public Cus getCusByName(String name);
	//根据身份证获取客户信息
	public Cus getCusByCid(String cid);

}
