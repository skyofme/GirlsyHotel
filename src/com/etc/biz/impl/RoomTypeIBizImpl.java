package com.etc.biz.impl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.etc.bean.PageBean;
import com.etc.bean.RoomType;
import com.etc.biz.RoomTypeIBiz;
import com.etc.dao.RoomTypeDao;

public class RoomTypeIBizImpl implements RoomTypeIBiz{
	private RoomTypeDao rtdao;
	public RoomTypeDao getRtdao() {
		return rtdao;
	}

	public void setRtdao(RoomTypeDao rtdao) {
		this.rtdao = rtdao;
	}

	@Override
	public List<RoomType> getAllRoomType() {
		return rtdao.getAllRoomType();
	}

	@Override
	public void updateOrAddRoomType(RoomType s) {
		rtdao.updateOrAddRoomType(s);
	}

	

	@Override
	public RoomType getRoomTypeById(int id) {
		return rtdao.getRoomTypeById(id);
	}

	@Override
	public long getCount() {
		// TODO Auto-generated method stub
		return rtdao.getCount();
	}

	@Override
	public List<RoomType> getAllByPage(PageBean pb) {
		// TODO Auto-generated method stub
		return rtdao.getAllByPage(pb);
	}

	@Override
	public void addRoomType(RoomType roomtype) {
		rtdao.addRoomType(roomtype);
		
	}

	@Override
	public int getRtByMaxId() {
		return  rtdao.getRtByMaxId();
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
	



}
