package com.etc.biz.impl;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.etc.aop.LogAssi;
import com.etc.bean.Cus;
import com.etc.bean.Emp;
import com.etc.bean.Ord;
import com.etc.bean.PageBean;
import com.etc.bean.Room;
import com.etc.biz.OrdIBiz;
import com.etc.dao.OrdDao;
import com.etc.dao.RoomDao;

public class OrdIBizImpl implements OrdIBiz {
	private OrdDao odao;

	private RoomDao rdao;
	
	private LogAssi la;
	public RoomDao getRdao() {
		return rdao;
	}

	public void setRdao(RoomDao rdao) {
		this.rdao = rdao;
	}

	public OrdDao getOdao() {
		return odao;
	}

	public void setOdao(OrdDao odao) {
		this.odao = odao;
	}

	@Override
	public List<Ord> getAllOrd() {
		return odao.getAllOrd();
	}

	@Override
	public void updateOrAddOrd(Ord o) {	//添加或更新
		odao.updateOrAddOrd(o);
	}

	@Override
	public void deleteOrd(int id) {
		odao.deleteOrd(id);
	}

	@Override
	public Ord getOrdById(int id) {
		return odao.getOrdById(id);
	}

	@Override
	public long getCount() {
		// TODO Auto-generated method stub
		return odao.getCount();
	}

	@Override
	public List<Ord> getAllByPage(PageBean pb) {
		// TODO Auto-generated method stub
		return odao.getAllByPage(pb);
	}


	@Override
	public List<Ord> getOrdByPage(PageBean pb, int cusId) {
		return odao.getOrdByPage(pb, cusId);
	}


	@Override
	public Ord updateOrd(Ord ord) {
		Ord o = odao.getOrdById(ord.getOrdId());
		DecimalFormat df = new DecimalFormat("#.00");   
		Double tp = Double.parseDouble(df.format(ord.getRmDayPrice()));
		System.out.println(tp);
		o.setRmDayPrice(tp);
		o.setInDate(ord.getInDate());
		o.setOrdState(ord.getOrdState());
		o.setOutDate(ord.getOutDate());
		o.setTotalDay(o.getTotalDay());
		o.setTotalPrice(o.getTotalPrice());
		o.setRoom(rdao.getRoomByName(ord.getRoom().getRmName()));
		odao.updateOrAddOrd(o);
		return o;
	}


	@Override
	public List<Ord> getOrd(int cusId) {
		return odao.getOrd(cusId);
	}

	@Override
	public void getOrdPageAndSendSess(int start, int pageSize) {
		HttpSession session = ServletActionContext.getRequest().getSession();
		// 根据总记录数 计算总页码
		long row = odao.getCount();
		// 总页码
		long totalPage = (long) Math.ceil(row / (pageSize * 1.0));
		
		if (start >= totalPage) {
			start = (int) totalPage;
		} else if (start <= 1) {
			start = 1;
		}
		PageBean pb = new PageBean(start, pageSize);
		
		List<Ord> olist = odao.getAllByPage(pb);
		for (Ord o : olist) {
			o.setTotalDay(o.getTotalDay());
			o.setTotalPrice(o.getTotalPrice());
		}
		List<String> roomNameList = new ArrayList<>();
		for (Room r : rdao.getAllRoom()) {
			roomNameList.add(r.getRmName());
		}
		session.setAttribute("ordlist", olist);
		session.setAttribute("start", start);
		
		session.setAttribute("ordGetAllRoom", roomNameList);
	}

	@Override
	public void doAJAX(String json) throws IOException {
		// TODO Auto-generated method stub
		//ServletAPI 耦合的方式
		HttpServletResponse response = ServletActionContext.getResponse();
		//其中response.setContentType("application/json;charset=utf-8");是最重要的 
		response.setContentType("application/json;charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out = response.getWriter();
		out.write(json);
		out.flush();
		out.close();
	}

	@Override
	public void doLog(String op, Ord o) {
		String context = "";
		String ordId = o.getOrdId()+"号";
		String cusId = o.getCus().getCusId()+"号";
		String cusName = o.getCus().getCusName();
		String cusCid = o.getCus().getCusCid();
		String inDate = o.getInDate()+" ";
		String outDate = o.getOutDate()+" ";
		String rmName = o.getRoom().getRmName();
		String rmDayPrice = o.getRmDayPrice()+"元";
		String ordState = o.getOrdState();
		String totalDay = o.getTotalDay()+"天";
		String totalPrice = o.getTotalPrice()+"元";
		HttpSession session = ServletActionContext.getRequest().getSession();
		Emp e = (Emp) session.getAttribute("login");
		context = "把[订单]【"+op+"】了：[订单号]为"+ordId+",[入住的客户]是"+cusName+"，[身份证]是"+cusCid
					+"，[客户编号]是"+cusId+"，[入住日期]为"+inDate+"，[退房日期]为"+outDate+"，[房间号]是"+rmName+",[当日价格]为"
					+rmDayPrice+",[总天数]为"+totalDay+"，[总价格]为"+totalPrice+"，[订单状态]是"+ordState;
		la.logAssi(e.getEmpId(), context);
	}

	public LogAssi getLa() {
		return la;
	}

	public void setLa(LogAssi la) {
		this.la = la;
	}

	@Override
	public void addOrd(Ord ord,Room r,Cus c) {
		ord.setCus(c);
		ord.setOrdState("在住");
		r.setRmState("在住");
		rdao.updateOrAddRoom(r);
		ord.setRoom(r);
		ord.setTotalDay(ord.getTotalDay());
		ord.setTotalPrice(ord.getTotalPrice());
		odao.addOrd(ord);
	}

}
