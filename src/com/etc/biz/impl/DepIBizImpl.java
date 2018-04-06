package com.etc.biz.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.etc.aop.LogAssi;
import com.etc.bean.Dep;
import com.etc.bean.Emp;
import com.etc.biz.DepIBiz;
import com.etc.dao.DepDao;

public class DepIBizImpl implements DepIBiz{
	private DepDao ddao;
	private LogAssi la;
	public DepDao getDdao() {
		return ddao;
	}

	public void setDdao(DepDao ddao) {
		this.ddao = ddao;
	}

	@Override
	public List<Dep> getAllDep() {
		return ddao.getAllDep();
	}

	@Override
	public void updateOrAddDep(Dep s) {
		ddao.updateOrAddDep(s);
	}

	@Override
	public void deleteDep(int id) {
		ddao.deleteDep(id);
	}

	@Override
	public Dep getDepById(int id) {
		return ddao.getDepById(id);
	}

	public LogAssi getLa() {
		return la;
	}

	public void setLa(LogAssi la) {
		this.la = la;
	}
	

}
