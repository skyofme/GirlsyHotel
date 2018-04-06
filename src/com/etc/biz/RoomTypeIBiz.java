package com.etc.biz;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.etc.bean.PageBean;
import com.etc.bean.Room;
import com.etc.bean.RoomType;



public interface RoomTypeIBiz {
	    //获取所有房间类型信息
		public List<RoomType> getAllRoomType();
		//修改或增加房间类型信息
		public void updateOrAddRoomType(RoomType s);
		//删除房间类型
//		public void deleteRoomType(int id);
		//根据ID获取房间类型信息
		public RoomType getRoomTypeById(int id);
		//查询房间总数
		public long getCount();
		//分页
		public List<RoomType> getAllByPage(PageBean pb);
		//增加房间类型
		public void addRoomType(RoomType roomtype);
		//先查出最大roomtypeid的房间
		public int getRtByMaxId();
		public void doAJAX(String json) throws IOException;
}
