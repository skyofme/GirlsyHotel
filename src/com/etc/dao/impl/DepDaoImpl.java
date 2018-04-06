package com.etc.dao.impl;

import java.util.List;

import com.etc.bean.Dep;
import com.etc.dao.BaseDao;
import com.etc.dao.DepDao;

public class DepDaoImpl implements DepDao {

	private BaseDao<Dep> sbdao;

	public BaseDao<Dep> getSbdao() {
		return sbdao;
	}

	public void setSbdao(BaseDao<Dep> sbdao) {
		this.sbdao = sbdao;
	}

	@Override
	public List<Dep> getAllDep() {
		return sbdao.find("from Dep");
	}

	@Override
	public void updateOrAddDep(Dep c) {
		sbdao.saveOrUpdate(c);
	}

	@Override
	public void deleteDep(int id) {
		sbdao.delete(sbdao.get(Dep.class, id));
	}

	@Override
	public Dep getDepById(int id) {
		return sbdao.get(Dep.class, id);
	}

}
