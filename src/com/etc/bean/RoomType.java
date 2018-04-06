package com.etc.bean;

import java.util.List;

public class RoomType {
	private int rmTpId;// 房间类型id
	private String rmTpName;// 房间类型
	private double rmTpInitPrice;// 房间初始价格
	private String rmTpPic;// 房间图片
	private Room room;
	public RoomType(String rmTpName, double rmTpInitPrice, String rmTpPic) {
		super();
		this.rmTpName = rmTpName;
		this.rmTpInitPrice = rmTpInitPrice;
		this.rmTpPic = rmTpPic;
	}
	public RoomType() {
		super();
	}
	public int getRmTpId() {
		return rmTpId;
	}
	public void setRmTpId(int rmTpId) {
		this.rmTpId = rmTpId;
	}
	public String getRmTpName() {
		return rmTpName;
	}
	public void setRmTpName(String rmTpName) {
		this.rmTpName = rmTpName;
	}
	public double getRmTpInitPrice() {
		return rmTpInitPrice;
	}
	public void setRmTpInitPrice(double rmTpInitPrice) {
		this.rmTpInitPrice = rmTpInitPrice;
	}
	public String getRmTpPic() {
		return rmTpPic;
	}
	public void setRmTpPic(String rmTpPic) {
		this.rmTpPic = rmTpPic;
	}

	@Override
	public String toString() {
		return "RoomType [rmTpId=" + rmTpId + ", rmTpName=" + rmTpName + ", rmTpInitPrice=" + rmTpInitPrice
				+ ", rmTpPic=" + rmTpPic + "]";
	}

	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
	public RoomType getRoomType() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

	
	
}
