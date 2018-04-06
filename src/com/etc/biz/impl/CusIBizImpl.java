package com.etc.biz.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.etc.aop.LogAssi;
import com.etc.bean.Cus;
import com.etc.bean.Emp;
import com.etc.bean.Ord;
import com.etc.bean.PageBean;
import com.etc.biz.CusIBiz;
import com.etc.dao.CusDao;

public class CusIBizImpl implements CusIBiz{
	private CusDao cdao;
	private LogAssi la;
	public CusDao getCdao() {
		return cdao;
	}

	public void setCdao(CusDao cdao) {
		this.cdao = cdao;
	}

	@Override
	public List<Cus> getAllCus() {
		return cdao.getAllCus();
	}

	@Override
	public void updateOrAddCus(Cus c) {
		cdao.updateOrAddCus(c);
	}

	@Override
	public void deleteCus(int id) {
		cdao.deleteCus(id);
		
	}

	@Override
	public Cus getCusById(int id) {
		return cdao.getCusById(id);
	}

	@Override
	public long getCount() {
		return cdao.getCount();
	}

	@Override
	public List<Cus> getAllByPage(PageBean pb) {
		return cdao.getAllByPage(pb);
	}

	@Override
	public Cus getCusByName(String name) {
		return cdao.getCusByName(name);
	}
	@Override
	public Cus getCusByCid(String cid) {
		return cdao.getCusByCid(cid);
	}

	public LogAssi getLa() {
		return la;
	}

	public void setLa(LogAssi la) {
		this.la = la;
	}

	@Override
	public void doLog(String op, Cus c) {
		String context = "";
		String cusCid = c.getCusCid();
		int cusId = c.getCusId();
		String cusName = c.getCusName();
		HttpSession session = ServletActionContext.getRequest().getSession();
		Emp e = (Emp) session.getAttribute("login");
		context = "把[客户]【"+op+"】了：[客户姓名]是"+cusName+"，[身份证]是"+cusCid
					+"，[客户编号]是"+cusId;
		la.logAssi(e.getEmpId(), context);
	}

}
