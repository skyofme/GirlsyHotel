package com.etc.bean;

import java.sql.Date;

public class Emp {
	private int empId;
	private String empName;
	private Dep dep;
	private int empAge;
	private Date empDate;// 员工入职时间
	private int empSal;// 员工工资
	private String empSex;
	private String empTel;
	private String empPwd;

	public Emp(int empId, String empName, Dep dep, int empAge, Date empDate, int empSal, String empSex, String empTel,
			String empPwd) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.dep = dep;
		this.empAge = empAge;
		this.empDate = empDate;
		this.empSal = empSal;
		this.empSex = empSex;
		this.empTel = empTel;
		this.empPwd = empPwd;
	}

	public Emp() {
		super();
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Dep getDep() {
		return dep;
	}

	public void setDep(Dep dep) {
		this.dep = dep;
	}

	public int getEmpAge() {
		return empAge;
	}

	public void setEmpAge(int empAge) {
		this.empAge = empAge;
	}

	public Date getEmpDate() {
		return empDate;
	}

	public void setEmpDate(Date empDate) {
		this.empDate = empDate;
	}

	public int getEmpSal() {
		return empSal;
	}

	public void setEmpSal(int empSal) {
		this.empSal = empSal;
	}

	public String getEmpSex() {
		return empSex;
	}

	public void setEmpSex(String empSex) {
		this.empSex = empSex;
	}

	public String getEmpTel() {
		return empTel;
	}

	public void setEmpTel(String empTel) {
		this.empTel = empTel;
	}

	public String getEmpPwd() {
		return empPwd;
	}

	public void setEmpPwd(String empPwd) {
		this.empPwd = empPwd;
	}

}
