package com.etc.biz.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.etc.aop.LogAssi;
import com.etc.bean.Emp;
import com.etc.bean.Ord;
import com.etc.bean.PageBean;
import com.etc.biz.EmpIBiz;
import com.etc.dao.EmpDao;

public class EmpIBizImpl implements EmpIBiz {
	private EmpDao edao;
	private LogAssi la;

	public EmpDao getEdao() {
		return edao;
	}

	public void setEdao(EmpDao edao) {
		this.edao = edao;
	}

	@Override
	public List<Emp> getAllEmp() {
		return edao.getAllEmp();
	}

	@Override
	public void updateOrAddEmp(Emp d) {
		edao.updateOrAddEmp(d);
	}


	@Override
	public Emp getEmpById(int id) {
		return edao.getEmpById(id);
	}

	@Override
	public long getCount() {
		return edao.getCount();
	}

	@Override
	public List<Emp> getAllByPage(PageBean pb) {
		return edao.getAllByPage(pb);
	}


	@Override
	public void delStudent(Emp emp) {
		edao.deleteEmp(emp);
		
	}


	@Override
	public Emp doLogin(String tel, String pwd) {
		// TODO Auto-generated method stub
		return edao.doLogin(tel, pwd);
	}

	@Override
	public boolean checkOldPwd(String oldPwd) {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		Emp emp = (Emp) session.getAttribute("login");
		if(emp.getEmpPwd().equals(oldPwd)) {
			return true;
		}
		return false;
	}

	@Override
	public void changePwd(String pwd) {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		Emp emp = (Emp) session.getAttribute("login");
		emp.setEmpPwd(pwd);
		edao.updateOrAddEmp(emp);
	}

	public LogAssi getLa() {
		return la;
	}

	public void setLa(LogAssi la) {
		this.la = la;
	}

	@Override
	public void doLog(String op, Emp e) {
		String context = "";
		int depId = e.getDep().getDepId();
		String depName = e.getDep().getDepName();
		String date = e.getEmpDate()+"";
		int id = e.getEmpId();
		String name = e.getEmpName();
		String sal = e.getEmpSal()+"元";
		String tel = e.getEmpTel();
		HttpSession session = ServletActionContext.getRequest().getSession();
		Emp ee = (Emp) session.getAttribute("login");
		context = "把[员工]【"+op+"】了：[员工号]为"+id+",[员工姓名]是"+name+"，[工资]是"+sal
					+"，[电话]是"+tel+"，[入职日期]为"+date+"，[所属部门]为"+depName+"，[部门编号]是"+depId;
		la.logAssi(ee.getEmpId(), context);
	}

	@Override
	public void AddEmp(Emp d) {
		edao.AddEmp(d);
		
	}

}
