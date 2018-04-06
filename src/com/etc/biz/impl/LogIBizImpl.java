package com.etc.biz.impl;

import java.util.List;

import com.etc.bean.Log;
import com.etc.bean.PageBean;
import com.etc.biz.LogIBiz;
import com.etc.dao.LogDao;

public class LogIBizImpl implements LogIBiz{
	private LogDao ldao;
	public LogDao getLdao() {
		return ldao;
	}

	public void setLdao(LogDao ldao) {
		this.ldao = ldao;
	}

	@Override
	public List<Log> getAllLog() {
		return ldao.getAllLog();
	}

	@Override
	public void updateOrAddLog(Log s) {
		ldao.updateOrAddLog(s);
	}

	@Override
	public void deleteLog(int id) {
		ldao.deleteLog(id);
	}

	@Override
	public Log getLogById(int id) {
		return ldao.getLogById(id);
	}

	@Override
	public long getCount() {
		return ldao.getCount();
	}

	@Override
	public List<Log> getAllByPage(PageBean pb) {
		return ldao.getAllByPage(pb);
	}

	@Override
	public List<Log> getIdByPage(PageBean pb, int empId) {
		return ldao.getIdByPage(pb, empId);
	}

}
