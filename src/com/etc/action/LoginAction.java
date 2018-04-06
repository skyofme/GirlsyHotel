package com.etc.action;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.etc.bean.Auth;
import com.etc.bean.Emp;
import com.etc.biz.AuthIBiz;
import com.etc.biz.impl.EmpIBizImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Emp emp;
	private EmpIBizImpl ebi;
	private String tel;
	private String pwd;
	private AuthIBiz ab;

	public EmpIBizImpl getEbi() {
		return ebi;
	}

	public void setEbi(EmpIBizImpl ebi) {
		this.ebi = ebi;
	}

	@Override
	public String execute() throws Exception {
		return SUCCESS;

	}

	public String doLogin() throws Exception {
		Map<String, Object> session = ActionContext.getContext().getSession();
		//移除session
		List<Auth> authAllList =  ab.getAllAuth();
		for (Auth auth : authAllList) {
			System.out.println(auth.getAuthName());
			session.remove(auth.getAuthName());
		}
		Emp user = ebi.doLogin(tel, pwd);
		if (null!=user) {
			// 如果登录成功 将用户对象存入key值为login的session中
			Set<Auth> authList = user.getDep().getAuthlist();
			//把所有权限放到session里面
			for (Auth auth : authList) {
				System.out.println(auth.getAuthName());
				session.put(auth.getAuthName(), "true");
			}
			session.put("login", user);
			tel = null;
			pwd = null;
			session.remove("msg");
			session.remove("info");
			return SUCCESS;
		} else {
			session.put("msg", "用户名或密码错误！");
			return INPUT;
		}
	}

	public Emp getEmp() {
		return emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public AuthIBiz getAb() {
		return ab;
	}

	public void setAb(AuthIBiz ab) {
		this.ab = ab;
	}
}
