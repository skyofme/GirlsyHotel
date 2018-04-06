package com.etc.dao.impl;

import java.util.List;

import com.etc.bean.Emp;
import com.etc.bean.PageBean;
import com.etc.dao.BaseDao;
import com.etc.dao.EmpDao;

public class EmpDaoImpl implements EmpDao {

	private BaseDao<Emp> sbdao;

	public BaseDao<Emp> getSbdao() {
		return sbdao;
	}

	public void setSbdao(BaseDao<Emp> sbdao) {
		this.sbdao = sbdao;
	}

	@Override
	public List<Emp> getAllEmp() {
		return sbdao.find("from Emp");
	}

	@Override
	public void updateOrAddEmp(Emp c) {
		sbdao.saveOrUpdate(c);
	}

	
	@Override
	public Emp getEmpById(int id) {
		return sbdao.get(Emp.class, id);
	}

	@Override
	public Emp doLogin(String tel, String pwd) {
		List<Emp> emps = sbdao.find("from Emp where empTel = ? and empPwd = ?", tel,pwd);
		return emps.size()>0?emps.get(0):null;
	}
	@Override
	public long getCount() {
		Long row = sbdao.count("select count(empid) from Emp");
		return row;
	}

	@Override
	public List<Emp> getAllByPage(PageBean pb) {
		List<Emp> elist = sbdao.find("from Emp order by empid", pb);
		return elist;
	}

	@Override
	public void deleteEmp(Emp emp) {
		sbdao.delete(emp);		
	}

	@Override
	public void AddEmp(Emp d) {
		sbdao.save(d);
		
	}

}
