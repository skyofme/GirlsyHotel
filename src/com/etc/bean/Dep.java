package com.etc.bean;

import java.util.HashSet;
import java.util.Set;

public class Dep {
	private int depId;
	private String depName;
	Set<Emp> emplist = new HashSet<>();
	private Set<Auth> authlist = new HashSet<>();

	public Set<Emp> getEmplist() {
		return emplist;
	}

	public void setEmplist(Set<Emp> emplist) {
		this.emplist = emplist;
	}

	public Dep() {
		super();
	}

	public Dep(String depName) {
		super();
		this.depName = depName;
	}

	public int getDepId() {
		return depId;
	}

	public void setDepId(int depId) {
		this.depId = depId;
	}

	public String getDepName() {
		return depName;
	}

	public void setDepName(String depName) {
		this.depName = depName;
	}

	public Set<Auth> getAuthlist() {
		return authlist;
	}

	public void setAuthlist(Set<Auth> authlist) {
		this.authlist = authlist;
	}

}
