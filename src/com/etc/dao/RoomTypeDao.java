package com.etc.dao;

import java.util.List;

import com.etc.bean.PageBean;
import com.etc.bean.RoomType;

public interface RoomTypeDao {
	//获取所有房间类型信息
	public List<RoomType> getAllRoomType();
	//修改或增加房间类型信息
	public void updateOrAddRoomType(RoomType s);

	//根据ID获取房间类型信息
	public RoomType getRoomTypeById(int id);
	//分页
	public List<RoomType> getAllByPage(PageBean pb);
	//总数
	public long getCount();
	//增加房间
	public void addRoomType(RoomType s);
	//获得最大ID的
	public int getRtByMaxId();
	
}
