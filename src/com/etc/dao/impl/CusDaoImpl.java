package com.etc.dao.impl;

import java.util.List;

import com.etc.bean.Cus;
import com.etc.bean.Emp;
import com.etc.bean.PageBean;
import com.etc.bean.Room;
import com.etc.dao.BaseDao;
import com.etc.dao.CusDao;

public class CusDaoImpl implements CusDao {
	private BaseDao<Cus> sbdao;

	public BaseDao<Cus> getSbdao() {
		return sbdao;
	}

	public void setSbdao(BaseDao<Cus> sbdao) {
		this.sbdao = sbdao;
	}

	@Override
	public List<Cus> getAllCus() {
		return sbdao.find("from Cus");
	}

	@Override
	public void updateOrAddCus(Cus c) {
		sbdao.saveOrUpdate(c);
	}

	@Override
	public void deleteCus(int id) {
		sbdao.delete(sbdao.get(Cus.class, id));
	}

	@Override
	public Cus getCusById(int id) {
		return sbdao.get(Cus.class, id);
	}

	@Override
	public long getCount() {
		Long row = sbdao.count("select count(cusId) from Cus");
		return row;
	}

	@Override
	public List<Cus> getAllByPage(PageBean pb) {
		List<Cus> clist = sbdao.find("from Cus order by cusId", pb);
		return clist;
	}
	
	@Override
	public Cus getCusByName(String name) {
		return sbdao.get("from Cus where cusName = ?", name);
	}
	
	@Override
	public Cus getCusByCid(String name) {
		return sbdao.get("from Cus where cusCid = ?", name);
	}
}
