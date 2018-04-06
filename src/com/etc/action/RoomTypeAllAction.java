package com.etc.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.etc.bean.Room;
import com.etc.bean.RoomType;
import com.etc.biz.RoomIBiz;
import com.etc.biz.RoomTypeIBiz;

public class RoomTypeAllAction {
	private int rmId; //unuse member
	
	private RoomTypeIBiz rtbiz;
	private RoomType rmtp;
	
	private RoomIBiz rbiz;
	private Room rm;
	
	// 提交后显示所有
	public String doAdd() {
		// 查询所有
		List<RoomType> rmtplist = rtbiz.getAllRoomType();
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("rmtplist", rmtplist);
		return "doadd";
	}
	
	//获取添加数据 并提交数据库
	public String add() {
		rm.setRmState("空房");
		rmtp = rtbiz.getRoomTypeById(rm.getRoomType().getRmTpId());
		rm.setRoomType(rmtp);
		rbiz.AddRoom(rm);
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("init1", "<script>function init1(){document.getElementById('allroomtype').click();}</script>");
		return "addSuccess";
	}
	
	/*//删除后显示所有
	public String del() {
		rbiz.deleteRoom(rm.getRmId());
		return "delSuccess";
	}*/

	
	// 显示原本数据
	public String doedit() {
		List<RoomType> rmtplist = rtbiz.getAllRoomType();
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("rmtplist", rmtplist);
		//roomtype = rtbiz.getRoomTypeByRmTpName(roomtype.getRmTpName());
		//roomtype = rm.getRoomType();
		rm = rbiz.getRoomById(rm.getRmId());
		rmtp = rm.getRoomType();
		System.out.println("before update : room"+rm);
		//System.out.println("roomtype"+rmtp);

		return "doedit";
	}
	
	// 获取修改数据 并提交数据库
	public String edit() {
		//rm = rbiz.getRoomById(rmId);
		System.out.println(rm);
		rmtp = rtbiz.getRoomTypeById(rm.getRoomType().getRmTpId());
		rm.setRoomType(rmtp);
		//rbiz.dolog();
		rbiz.updateOrAddRoom(rm);
		System.out.println("after update : room : "+rm);
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("init1", "<script>function init1(){document.getElementById('allroomtype').click();}</script>");
		return "editSuccess";
	}

	public RoomTypeIBiz getRtbiz() {
		return rtbiz;
	}
	public void setRtbiz(RoomTypeIBiz rtbiz) {
		this.rtbiz = rtbiz;
	}
	public RoomType getRoomtype() {
		return rmtp;
	}
	public void setRoomtype(RoomType rmtp) {
		this.rmtp = rmtp;
	}
	public RoomIBiz getRbiz() {
		return rbiz;
	}
	public void setRbiz(RoomIBiz rbiz) {
		this.rbiz = rbiz;
	} 
	public Room getRm() {
		return rm;
	}
	public void setRm(Room rm) {
		this.rm = rm;
	}

	public RoomType getRmtp() {
		return rmtp;
	}

	public void setRmtp(RoomType rmtp) {
		this.rmtp = rmtp;
	}

	public int getRmId() {
		return rmId;
	}

	public void setRmId(int rmId) {
		this.rmId = rmId;
	}
}
