package com.etc.bean;

public class Room {
	private int rmId; 
	private String rmName; 
	private double rmPrice; 
	private RoomType roomType; 
	private String rmState; 

	public Room(String rmName, double rmPrice, RoomType roomType, String rmState) {
		super();
		this.rmName = rmName;
		this.rmPrice = rmPrice;
		this.roomType = roomType;
		this.rmState = rmState;
	}

	public Room() {
		super();
	}

	public int getRmId() {
		return rmId;
	}

	public void setRmId(int rmId) {
		this.rmId = rmId;
	}

	public String getRmName() {
		return rmName;
	}

	public void setRmName(String rmName) {
		this.rmName = rmName;
	}

	public double getRmPrice() {
		return rmPrice;
	}

	public void setRmPrice(double rmPrice) {
		this.rmPrice = rmPrice;
	}

	public RoomType getRoomType() {
		return roomType;
	}

	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}

	public String getRmState() {
		return rmState;
	}

	public void setRmState(String rmState) {
		this.rmState = rmState;
	}

	@Override
	public String toString() {
		return "Room [rmId=" + rmId + ", rmName=" + rmName + ", rmPrice=" + rmPrice + ", roomType=" + roomType
				+ ", rmState=" + rmState + "]";
	}

	
	
}
