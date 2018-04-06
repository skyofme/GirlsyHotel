package com.etc.biz;

import java.util.List;

import com.etc.bean.Ord;
import com.etc.bean.PageBean;
import com.etc.bean.Room;

public interface RoomIBiz {
		//获取所有房间信息
		public List<Room> getAllRoom();
		//修改或增加房间信息
		public void updateOrAddRoom(Room r);
		//增加房间信息
	    public void AddRoom(Room r);
		//删除房间
		public void deleteRoom(int id);
		//根据ID获取房间信息
		public Room getRoomById(int id);
		//获取房间数量
		public long getCount();
		//根据页码显示房间
		public List<Room> getAllByPage(PageBean pb);
		//根据类型分页显示房间
		public List<Room> getAllByType(String type, PageBean pb);
		//根据名字获取房间信息
		public Room getRoomByName(String name);
		//根据房间类型获取房间数量
		public long getCountByType(String type);
		//分页查询并发送相应的session
		public void getOrdPageAndSendSess(int start,int pagesize,String type);
		//根据类型获取在住房的数量
		long getFullCountByType(String type);
}
