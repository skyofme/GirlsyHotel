package com.etc.dao.impl;

import java.util.List;
import java.util.Set;

import com.etc.bean.Emp;
import com.etc.bean.Ord;
import com.etc.bean.PageBean;
import com.etc.dao.BaseDao;
import com.etc.dao.OrdDao;

public class OrdDaoImpl implements OrdDao{


	private BaseDao<Ord> sbdao;

	public BaseDao<Ord> getSbdao() {
		return sbdao;
	}

	public void setSbdao(BaseDao<Ord> sbdao) {
		this.sbdao = sbdao;
	}

	@Override
	public List<Ord> getAllOrd() {
		return sbdao.find("from Ord");
	}

	@Override
	public void updateOrAddOrd(Ord c) {
		sbdao.saveOrUpdate(c);
	}

	@Override
	public void deleteOrd(int id) {
		sbdao.delete(sbdao.get(Ord.class, id));
	}

	@Override
	public Ord getOrdById(int id) {
		return sbdao.get(Ord.class, id);
	}
	
	@Override
	public long getCount() {
		Long row = sbdao.count("select count(ordId) from Ord");
		return row;
	}

	@Override
	public List<Ord> getAllByPage(PageBean pb) {
		List<Ord> elist = sbdao.find("from Ord order by ordId", pb);
		return elist;
	}

	@Override
	public List<Ord> getOrdByPage(PageBean pb,int cusId) {
		List<Ord> olist=sbdao.find("from Ord o where o.cus.cusId= ? order by ordId", pb,cusId);
		
		return olist;
	}
	@Override
	public List<Ord> getOrd(int cusId){
		List<Ord> olist=sbdao.find("from Ord o where o.cus.cusId= ? order by ordId", cusId);
		return olist;
	}

	@Override
	public void addOrd(Ord o) {
		// TODO Auto-generated method stub
		sbdao.save(o);
	}

}
