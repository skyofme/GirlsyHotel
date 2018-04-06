package com.etc.action;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.etc.bean.Cus;
import com.etc.aop.LogAssi;
import com.etc.bean.Ord;
import com.etc.bean.Room;
import com.etc.biz.impl.CusIBizImpl;
import com.etc.biz.impl.OrdIBizImpl;
import com.etc.biz.impl.RoomIBizImpl;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;

public class OrdAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private OrdIBizImpl obi;
	private RoomIBizImpl rbi;
	private CusIBizImpl cbi;
	private String ordId;
	private String first;
	private int start;// 第几页
	private int pageSize=7;// 显示的记录
	private LogAssi logAssi;
	private Ord ord;

	
	//入住订单添加
	public String addOne() throws IOException {
		HttpSession session = ServletActionContext.getRequest().getSession();
		//判断是否有权限
		if(!"true".equals(session.getAttribute("addOrd")))
			return "gotoindex";
		
		Cus c = cbi.getCusByCid(ord.getCus().getCusCid());
		if(null==c) {
			c = new Cus();
			c.setCusCid(ord.getCus().getCusCid());
			c.setCusName(ord.getCus().getCusName());
			cbi.updateOrAddCus(c);
		}
		Room r = rbi.getRoomByName(ord.getRoom().getRmName());
		obi.addOrd(ord,r,c);
		ord = obi.getOrdById(ord.getOrdId());
		obi.doLog("增加", ord);
		String json = JSON.toJSONString("");
		obi.doAJAX(json);
		return null;
	}

	public String getAll() throws Exception {
		
		HttpSession session = ServletActionContext.getRequest().getSession();
		//判断是否有权限
		if(!"true".equals(session.getAttribute("selectOrd")))
			return "gotoindex";
		//分页方法
		obi.getOrdPageAndSendSess(start, pageSize);
		return "getAll";
	
	}
	
	public String update() throws IOException {
		HttpSession session = ServletActionContext.getRequest().getSession();
		//判断是否有权限
		if(!"true".equals(session.getAttribute("updateOrd")))
			return "gotoindex";
		Ord o = obi.updateOrd(ord);
		obi.doLog("修改", o);
		Gson g = new Gson();
		//将对象转换为json格式字符串
		String json = g.toJson(o);
		obi.doAJAX(json);
		return null;
	}
	
	public String getOne() throws IOException {
		HttpSession session = ServletActionContext.getRequest().getSession();
		//判断是否有权限
		if(!"true".equals(session.getAttribute("selectOrd")))
			return "gotoindex";
		
		Ord o = obi.getOrdById(Integer.parseInt(ordId));
		o.setTotalDay(o.getTotalDay());
		o.setTotalPrice(o.getTotalPrice());
		String json = JSON.toJSONString(o);
		obi.doAJAX(json);
		return null;
	} 
	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public OrdIBizImpl getObi() {
		return obi;
	}

	public void setObi(OrdIBizImpl obi) {
		this.obi = obi;
	}

	public Ord getOrd() {
		return ord;
	}

	public void setOrd(Ord ord) {
		this.ord = ord;
	}

	public RoomIBizImpl getRbi() {
		return rbi;
	}

	public void setRbi(RoomIBizImpl rbi) {
		this.rbi = rbi;
	}

	public String getOrdId() {
		return ordId;
	}

	public void setOrdId(String ordId) {
		this.ordId = ordId;
	}

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public CusIBizImpl getCbi() {
		return cbi;
	}

	public void setCbi(CusIBizImpl cbi) {
		this.cbi = cbi;
	}

	public LogAssi getLogAssi() {
		return logAssi;
	}

	public void setLogAssi(LogAssi logAssi) {
		this.logAssi = logAssi;
	}

	
}
