package com.etc.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport{
	private String logout;
	
	public String getLogout() {
		return logout;
	}

	public void setLogout(String logout) {
		this.logout = logout;
	}

	@Override
	public String execute() throws Exception {
		if(this.getLogout().trim().equals("loginOut")) {
			HttpSession session = ServletActionContext.getRequest().getSession();
			session.removeAttribute("login");
			return "success";
		}
		return "false";
	}
}
