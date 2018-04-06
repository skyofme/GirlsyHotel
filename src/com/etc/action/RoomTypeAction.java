package com.etc.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.etc.bean.Cus;
import com.etc.bean.PageBean;
import com.etc.bean.Room;
import com.etc.bean.RoomType;
import com.etc.biz.RoomIBiz;
import com.etc.biz.RoomTypeIBiz;
import com.opensymphony.xwork2.ActionSupport;

//@SuppressWarnings("unused")
public class RoomTypeAction extends ActionSupport{
	
	private int start;
	private int pageSize;
	private int rmTpId; 
	
	private RoomTypeIBiz rtbiz;
	private RoomType roomtype;
	
	private RoomIBiz rbiz;
	private Room rm;
	
	// 查找所有房间类型，并切割图片地址。
	public String showAll() {
		String[] src = null;
		List<RoomType> allrmtp = rtbiz.getAllRoomType();
		System.out.println("111111"+allrmtp);
		//植入代码
		for(RoomType rt:allrmtp) {
			src=rt.getRmTpPic().split(" ");
			rt.setRmTpPic(src[0]);
			System.out.println(rt.getRmTpPic());
		}
		System.out.println(allrmtp);
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("allrmtp", allrmtp);
		session.setAttribute("src", src);		
		return "showAll";
	}
	
	public String updateOrAdd() throws IOException {
		//获取编辑房间类型组件中的图片路径并写入数据库，上传图片到服务器
		String[] src = null;
		RoomType rt=rtbiz.getRoomTypeById(rmTpId);
		rt.setRmTpName(rt.getRmTpName());
		rt.setRmTpInitPrice(rt.getRmTpInitPrice());
		String json = JSON.toJSONString(rt);
		rtbiz.doAJAX(json);
		return null;
	}
	public String doupdate() throws IOException{
		RoomType rt =  rtbiz.getRoomTypeById(roomtype.getRmTpId());
		rt.setRmTpName(roomtype.getRmTpName());
		rt.setRmTpInitPrice(roomtype.getRmTpInitPrice());
	    System.out.println("======="+rt);	
		rtbiz.updateOrAddRoomType(rt);
		String[] src = null;
		src=rt.getRmTpPic().split(" ");
		rt.setRmTpPic(src[0]);
		String json = JSON.toJSONString(rt);
		rtbiz.doAJAX(json);
		return null;
	}
	
	//查询所有房间
	public String pageAll() throws Exception {
		System.out.println("进入该方法");
		// 根据总记录数 计算总页码
		long row = rbiz.getCount();
		// 总页码
		long totalPage = (long) Math.ceil(row / (pageSize * 1.0));
		if (start <= 1) {
			start = 1;
		} else if (start >= totalPage) {
			start = (int) totalPage;
		}
		PageBean pb = new PageBean(start, pageSize);
		HttpSession session = ServletActionContext.getRequest().getSession();
		//session.setAttribute("init1", "<script>function init1(){document.getElementById('allroomtype').click();}</script>");
		List<Room> rtlist = rbiz.getAllByPage(pb);
		System.out.println(rtlist.size());
		for (Room room : rtlist) {
			System.out.println(room);
		}
		session.setAttribute("rtlist", rtlist);
		return "a";
	}

	public Room getRm() {
		return rm;
	}
	public void setRm(Room rm) {
		this.rm = rm;
	}
	
	public int getRmTpId() {
		return rmTpId;
	}
	public void setRmTpId(int rmTpId) {
		this.rmTpId = rmTpId;
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
	public RoomTypeIBiz getRtbiz() {
		return rtbiz;
	}
	public void setRtbiz(RoomTypeIBiz rtbiz) {
		this.rtbiz = rtbiz;
	}
	public RoomType getRoomtype() {
		return roomtype;
	}
	public void setRoomtype(RoomType roomtype) {
		this.roomtype = roomtype;
	}

	public RoomIBiz getRbiz() {
		return rbiz;
	}

	public void setRbiz(RoomIBiz rbiz) {
		this.rbiz = rbiz;
	}
}