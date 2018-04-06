package com.etc.biz;

import java.util.List;

import com.etc.bean.Emp;
import com.etc.bean.Ord;
import com.etc.bean.PageBean;

public interface EmpIBiz {

    //获取所有员工信息
	public List<Emp> getAllEmp();
	//修改或增加员工信息
	public void updateOrAddEmp(Emp d);
	//根据ID获取员工信息
	public Emp getEmpById(int id);
	//判断是否满足登录条件
	public Emp doLogin(String tel,String pwd);
	//获取员工总数
	public long getCount();
	//分页查询
	public List<Emp> getAllByPage(PageBean pb);
	//删除员工
	public void delStudent(Emp emp);
	//判断密码是否正确
	public boolean checkOldPwd(String oldPwd);
	//修改员工密码
	public void changePwd(String pwd);
	//生成日志
	public void doLog(String op,Emp e);
	//增加员工信息
	public void AddEmp(Emp d);
}
