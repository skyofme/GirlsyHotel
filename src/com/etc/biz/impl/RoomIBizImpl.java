package com.etc.biz.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.etc.bean.PageBean;
import com.etc.bean.Room;
import com.etc.biz.RoomIBiz;
import com.etc.dao.RoomDao;

public class RoomIBizImpl implements RoomIBiz{
	private RoomDao rdao;
	
	public RoomDao getRdao() {
		return rdao;
	}

	public void setRdao(RoomDao rdao) {
		this.rdao = rdao;
	}

	@Override
	public List<Room> getAllRoom() {
		return rdao.getAllRoom();
	}

	@Override
	public void updateOrAddRoom(Room r) {
		rdao.updateOrAddRoom(r);
	}

	@Override
	public void deleteRoom(int id) {
		rdao.deleteRoom(id);
	}

	@Override
	public Room getRoomById(int id) {
		return rdao.getRoomById(id);
	}
	
	@Override
	public Room getRoomByName(String name) {
		return rdao.getRoomByName(name);
	}

	@Override
	public long getCount() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		if(!"true".equals(session.getAttribute("roomtypeFlag"))) {
			return rdao.getCount();
		} else {
			return rdao.getCountByType((String) session.getAttribute("roomType"));
		}
		
	}

	@Override
	public List<Room> getAllByPage(PageBean pb) {
		return rdao.getAllByPage(pb);
	}

	@Override
	public List<Room> getAllByType(String type, PageBean pb) {
		HttpSession session = ServletActionContext.getRequest().getSession();
		if(!"true".equals(session.getAttribute("roomtypeFlag"))) {
			return rdao.getAllByPage(pb);
		} else {
			return rdao.getAllByType(type, pb);
		}
	}

	@Override
	public long getCountByType(String type) {
		return rdao.getCountByType(type);
	}

	@Override
	public void getOrdPageAndSendSess(int start, int pageSize, String type) {
		HttpSession session = ServletActionContext.getRequest().getSession();
		if(type.equals("所有房间")) {
 			session.removeAttribute("roomtypeFlag");
		} else {
			session.setAttribute("roomtypeFlag", "true");
			session.setAttribute("roomType", type);
		}
		// 根据总记录数 计算总页码	
		long row = getCount();
		// 总页码
		long totalPage = (long) Math.ceil(row / (pageSize * 1.0));
		
		if (start >= totalPage) {
			start = (int) totalPage;
		} else if (start <= 1) {
			start = 1;
		}
		
		PageBean pb = new PageBean(start, pageSize);
		
		List<Room> olist = getAllByType(type,pb);
		session.setAttribute("rlist", olist);
		session.setAttribute("startrr", start);
		
	}

	@Override
	public long getFullCountByType(String type) {
		
		return rdao.getFullCountByType(type);
	}

	@Override
	public void AddRoom(Room r) {
		rdao.AddRoom(r);
		
	}

	

}
