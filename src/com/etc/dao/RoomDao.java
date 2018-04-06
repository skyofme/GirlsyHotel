package com.etc.dao;

import java.util.List;

import com.etc.bean.PageBean;
import com.etc.bean.Room;

public interface RoomDao {
	// 获取所有房间信息
	public List<Room> getAllRoom();

	// 修改或增加房间信息
	public void updateOrAddRoom(Room r);

	// 删除房间
	public void deleteRoom(int id);

	// 根据ID获取房间信息
	public Room getRoomById(int id);

	// 获取房间数量
	public long getCount();
	
	// 根据页码显示房间
	public List<Room> getAllByPage(PageBean pb);
	
	//根据房间类型显示房间
	public List<Room> getAllByType(String type, PageBean pb);
	
	//根据名字获取房间信息
	public Room getRoomByName(String type);
	//根据类型获取房间数量
	long getCountByType(String type);
	
	//根据类型获取在住房的数量
	long getFullCountByType(String type);
	
	public void AddRoom(Room r) ;
}
