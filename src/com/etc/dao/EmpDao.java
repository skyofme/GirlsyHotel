package com.etc.dao;

import java.util.List;

import com.etc.bean.Emp;
import com.etc.bean.PageBean;

public interface EmpDao {
	//获取所有员工信息
	public List<Emp> getAllEmp();
	//修改或增加员工信息
	public void updateOrAddEmp(Emp d);
	//删除员工
	public void deleteEmp(Emp emp);
	//根据ID获取员工信息
	public Emp getEmpById(int id);
	//判断是否满足登录条件
	public Emp doLogin(String tel,String pwd);
	//获取员工总数量
	public long getCount();
	//分页查询员工
	public List<Emp> getAllByPage(PageBean pb);
	//增加员工信息
    public void AddEmp(Emp d);
}
