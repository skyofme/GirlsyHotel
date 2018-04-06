package com.etc.bean;

import java.math.BigDecimal;
import java.sql.Date;
import java.text.DecimalFormat;

public class Ord {
	private int ordId;
	private Cus cus;
	private Room room;
	private Date inDate;// 订住时间
	private Date outDate;// 退房时间
	private String ordState;// 订单状态
	private double rmDayPrice;// 房间当日价格
	private int totalDay;// 入住天数 不是表属性 计算得到
	private Double totalPrice;// 总价 不是表属性 计算得到

	public Ord(Cus cus, Room room, Date inDate, Date outDate, String ordState, double rmDayPrice) {
		super();
		this.cus = cus;
		this.room = room;
		this.inDate = inDate;
		this.outDate = outDate;
		this.ordState = ordState;
		this.setRmDayPrice(rmDayPrice);
	}

	public Ord(int ordId, Cus cus, Room room, Date inDate, Date outDate, String ordState, double rmDayPrice,
			int totalDay, Double totalPrice) {
		super();
		this.ordId = ordId;
		this.cus = cus;
		this.room = room;
		this.inDate = inDate;
		this.outDate = outDate;
		this.ordState = ordState;
		this.rmDayPrice = rmDayPrice;
		this.totalDay = totalDay;
		this.totalPrice = totalPrice;
	}

	public Ord() {
		super();
	}

	public int getTotalDay() {
		int d = (int) ((this.getOutDate().getTime() - this.getInDate().getTime()) / 1000 / 60 / 60 / 24);
		return d;
	}

	public void setTotalDay(int totalDay) {
		this.totalDay = totalDay;
	}

	public Double getTotalPrice() {
		int d = (int) ((this.getOutDate().getTime() - this.getInDate().getTime()) / 1000 / 60 / 60 / 24);
		double p = d * this.getRmDayPrice();
		DecimalFormat df = new DecimalFormat("#.00");
		Double tp = Double.parseDouble(df.format(p));
		return tp;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getOrdId() {
		return ordId;
	}

	public void setOrdId(int ordId) {
		this.ordId = ordId;
	}

	public Cus getCus() {
		return cus;
	}

	public void setCus(Cus cus) {
		this.cus = cus;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Date getInDate() {
		return inDate;
	}

	public void setInDate(Date inDate) {
		this.inDate = inDate;
	}

	public Date getOutDate() {
		return outDate;
	}

	public void setOutDate(Date outDate) {
		this.outDate = outDate;
	}

	public String getOrdState() {
		return ordState;
	}

	public void setOrdState(String ordState) {
		this.ordState = ordState;
	}

	public double getRmDayPrice() {
		return rmDayPrice;
	}

	public void setRmDayPrice(double rmDayPrice) {
		this.rmDayPrice = rmDayPrice;
	}

	@Override
	public String toString() {
		return "Ord [ordId=" + ordId + ", cus=" + cus + ", room=" + room + ", inDate=" + inDate + ", outDate=" + outDate
				+ ", ordState=" + ordState + ", rmDayPrice=" + rmDayPrice + ", totalDay=" + totalDay + ", totalPrice="
				+ totalPrice + "]";
	}

}
