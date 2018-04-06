package com.etc.bean;

public class Log {
	private int logId;// 日志id
	private Emp emp;// 执行操作的员工
	private String ope;// 操作
	private String opeTime;// 操作时间

	public Log(Emp emp, String ope, String opeTime) {
		super();
		this.emp = emp;
		this.ope = ope;
		this.opeTime = opeTime;
	}

	public Log() {
		super();
	}

	public int getLogId() {
		return logId;
	}

	public void setLogId(int logId) {
		this.logId = logId;
	}

	public Emp getEmp() {
		return emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

	public String getOpe() {
		return ope;
	}

	public void setOpe(String ope) {
		this.ope = ope;
	}

	public String getOpeTime() {
		return opeTime;
	}

	public void setOpeTime(String opeTime) {
		this.opeTime = opeTime;
	}

}
