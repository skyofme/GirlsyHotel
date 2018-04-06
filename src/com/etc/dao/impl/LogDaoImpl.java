package com.etc.dao.impl;

import java.util.List;

import com.etc.bean.Log;
import com.etc.bean.Ord;
import com.etc.bean.PageBean;
import com.etc.dao.BaseDao;
import com.etc.dao.LogDao;

public class LogDaoImpl implements LogDao{


	private BaseDao<Log> sbdao;

	public BaseDao<Log> getSbdao() {
		return sbdao;
	}

	public void setSbdao(BaseDao<Log> sbdao) {
		this.sbdao = sbdao;
	}

	@Override
	public List<Log> getAllLog() {
		return sbdao.find("from Log");
	}

	@Override
	public void updateOrAddLog(Log c) {
		sbdao.saveOrUpdate(c);
	}

	@Override
	public void deleteLog(int id) {
		sbdao.delete(sbdao.get(Log.class, id));
	}

	@Override
	public Log getLogById(int id) {
		return sbdao.get(Log.class, id);
	}

	@Override
	public long getCount() {
		Long row = sbdao.count("select count(logId) from Log");
		return row;
	}

	@Override
	public List<Log> getAllByPage(PageBean pb) {
		List<Log> llist = sbdao.find("from Log order by logId", pb);
		return llist;
	}

	@Override
	public List<Log> getIdByPage(PageBean pb, int empId) {
		List<Log> llist=sbdao.find("from Log l where l.emp.empId= ? order by logId", pb, empId);
		return llist;
	}

	


}
