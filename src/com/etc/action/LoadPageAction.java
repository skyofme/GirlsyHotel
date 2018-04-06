package com.etc.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class LoadPageAction extends ActionSupport{
	private String ask;
	
	public String getAsk() {
		return ask;
	}

	public void setAsk(String ask) {
		this.ask = ask;
	}

	@Override
	public String execute() throws Exception {
		System.out.println(this.getAsk());
		if(this.getAsk().trim().equals("loginOut")) {
			HttpSession session = ServletActionContext.getRequest().getSession();
			session.removeAttribute("login");
			return "gologin";
		}
		return this.getAsk();
	}
}
