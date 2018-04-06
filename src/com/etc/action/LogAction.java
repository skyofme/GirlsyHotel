package com.etc.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.etc.bean.Emp;
import com.etc.bean.Log;
import com.etc.bean.PageBean;
import com.etc.biz.LogIBiz;
import com.opensymphony.xwork2.ActionSupport;

public class LogAction extends ActionSupport{
	private Emp emp;
	private Log log;
	private LogIBiz lbiz;
	private int start;// 第几页
	private int pageSize;// 显示的记录
	
	public Log getLog() {
		return log;
	}
	public void setLog(Log log) {
		this.log = log;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public Emp getEmp() {
		return emp;
	}
	public void setEmp(Emp emp) {
		this.emp = emp;
	}
	public LogIBiz getLbiz() {
		return lbiz;
	}
	public void setLbiz(LogIBiz lbiz) {
		this.lbiz = lbiz;
	}
	public String getAll() {
		// 根据总记录数 计算总页码				
		long row = lbiz.getCount();
		// 总页码
		long totalPage = (long) Math.ceil(row / (pageSize * 1.0));
		if (start <= 1) {
			start = 1;
		} else if (start >= totalPage) {
			start = (int) totalPage;
		}
		PageBean pb = new PageBean(start, pageSize);
		HttpSession session = ServletActionContext.getRequest().getSession();
		List<Log> llist=lbiz.getAllByPage(pb);
		session.setAttribute("llist", llist);
		return "logAll";
		
	}
	public String getAllId() {
		// 根据总记录数 计算总页码				
		long row = lbiz.getCount();
		// 总页码
		long totalPage = (long) Math.ceil(row / (pageSize * 1.0));
		if (start <= 1) {
			start = 1;
		} else if (start >= totalPage) {
			start = (int) totalPage;
		}
		PageBean pb = new PageBean(start, pageSize);
		HttpSession session = ServletActionContext.getRequest().getSession();
		Emp e = (Emp)session.getAttribute("login");
		int empId=e.getEmpId();	
		List<Log> llist=lbiz.getIdByPage(pb, empId);
		session.setAttribute("llist", llist);
		return "logAllbyId";
		
	}
	
}
