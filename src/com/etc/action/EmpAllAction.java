package com.etc.action;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import com.etc.bean.Dep;
import com.etc.bean.Emp;
import com.etc.biz.DepIBiz;
import com.etc.biz.EmpIBiz;
import com.opensymphony.xwork2.ActionSupport;

public class EmpAllAction extends ActionSupport{
	private int empId;
	private EmpIBiz ebiz;
	private DepIBiz dbiz;
	private Emp emp;

	public DepIBiz getDbiz() {
		return dbiz;
	}

	public void setDbiz(DepIBiz dbiz) {
		this.dbiz = dbiz;
	}

	public Emp getEmp() {
		return emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

	public EmpIBiz getEbiz() {
		return ebiz;
	}

	public void setEbiz(EmpIBiz ebiz) {
		this.ebiz = ebiz;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}
	//删除员工
	public String doDel() {
		Emp emp1=new Emp();
		emp1.setEmpId(empId);
		//生成日志
		ebiz.doLog("删除", ebiz.getEmpById(empId));
		ebiz.delStudent(emp1);
		return "Success";
	}

	public String doedit() {
		// 查询所有部门
		List<Dep> deplist = dbiz.getAllDep();
		emp=ebiz.getEmpById(empId);
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("deplist", deplist);
		return "doedit";
	}
	public String edit() {
		Dep dep=dbiz.getDepById(emp.getDep().getDepId());
		emp.setDep(dep);
		//生成日志
		ebiz.doLog("修改", emp);
		ebiz.updateOrAddEmp(emp);
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("init1", "<script>function init1(){document.getElementById('allemp').click();}</script>");
		return "editSuccess";
	}
	public String doAdd() {
		// 查询所有部门
		List<Dep> deplist = dbiz.getAllDep();
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("deplist", deplist);
		return "doadd";
	}
	public String add() {
		Dep dep=dbiz.getDepById(emp.getDep().getDepId());
		emp.setDep(dep);
		//生成日志
		ebiz.doLog("增加", emp);
		ebiz.AddEmp(emp);
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("init1", "<script>function init1(){document.getElementById('allemp').click();}</script>");
		return "addSuccess";
	}
}
