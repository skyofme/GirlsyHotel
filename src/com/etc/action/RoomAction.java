package com.etc.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.etc.bean.Room;
import com.etc.bean.RoomType;
import com.etc.biz.RoomIBiz;
import com.etc.biz.RoomTypeIBiz;
import com.opensymphony.xwork2.ActionSupport;

public class RoomAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Room room;

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	private RoomIBiz rbiz;
	private RoomTypeIBiz rtbiz;
	private int start;
	private int pageSize;
	private int page;
	private String first;
	
	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	private String type = "all";

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public RoomIBiz getRbiz() {
		return rbiz;
	}

	public void setRbiz(RoomIBiz rbiz) {
		this.rbiz = rbiz;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	
	public String getAll() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		if(first.equals("true")) {
			type="所有房间";
			start=1;
			List<RoomType> rt= rtbiz.getAllRoomType();
			List<String> rmmmTypeList = new ArrayList<String>();
			for (RoomType r : rt) {
				rmmmTypeList.add(r.getRmTpName());
			}
			session.setAttribute("rmmmTypeList", rmmmTypeList);
			session.removeAttribute("roomtypeFlag");
		}
		type = type.replace("\n","");
		type = type.replace("\t","");
		rbiz.getOrdPageAndSendSess(start, 5, type);
		return "query_success";
	}

	public RoomTypeIBiz getRtbiz() {
		return rtbiz;
	}

	public void setRtbiz(RoomTypeIBiz rtbiz) {
		this.rtbiz = rtbiz;
	}
}
