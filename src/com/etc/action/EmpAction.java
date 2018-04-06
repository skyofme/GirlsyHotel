package com.etc.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.etc.bean.Emp;
import com.etc.bean.PageBean;
import com.etc.biz.EmpIBiz;
import com.opensymphony.xwork2.ActionSupport;

public class EmpAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EmpIBiz ebiz;
	private String[] chkname;
	private int start;// 第几页
	private int pageSize;// 显示的记录

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

	public String[] getChkname() {
		return chkname;
	}

	public void setChkname(String[] chkname) {
		this.chkname = chkname;
	}
	public EmpIBiz getEbiz() {
		return ebiz;
	}

	public void setEbiz(EmpIBiz ebiz) {
		this.ebiz = ebiz;
	}

	public String pageAll() throws Exception {
		// 根据总记录数 计算总页码
		long row = ebiz.getCount();
		System.out.println("row:"+row);
		// 总页码
		long totalPage = (long) Math.ceil(row / (pageSize * 1.0));
		if (start <= 1) {
			start = 1;
		} else if (start >= totalPage) {
			start = (int) totalPage;
		}
		PageBean pb = new PageBean(start, pageSize);
		HttpSession session = ServletActionContext.getRequest().getSession();
		List<Emp> elist = ebiz.getAllByPage(pb);
		session.setAttribute("elist", elist);
		return "success";
	}
}
