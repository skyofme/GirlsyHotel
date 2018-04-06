package com.etc.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.etc.bean.Emp;
import com.etc.biz.EmpIBiz;
import com.opensymphony.xwork2.ActionSupport;

public class ChangePwdAction extends ActionSupport{
	private String oldPwd;
	private String newPwd;
	private EmpIBiz eib;
	public String getOldPwd() {
		return oldPwd;
	}
	public void setOldPwd(String oldPwd) {
		this.oldPwd = oldPwd;
	}
	public String getNewPwd() {
		return newPwd;
	}
	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}
	public String checkPwd() throws IOException {
		boolean flag = eib.checkOldPwd(oldPwd);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json;charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out = response.getWriter();
		out.write(flag+"");
		out.flush();
		out.close();
		return null;
	}
	
	public String updatePwd() throws IOException {
		eib.changePwd(newPwd);
		return "success";
	}
	public EmpIBiz getEib() {
		return eib;
	}
	public void setEib(EmpIBiz eib) {
		this.eib = eib;
	}
}
