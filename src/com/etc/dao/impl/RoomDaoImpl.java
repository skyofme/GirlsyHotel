package com.etc.dao.impl;

import java.util.List;

import com.etc.bean.PageBean;
import com.etc.bean.Room;
import com.etc.dao.BaseDao;
import com.etc.dao.RoomDao;

public class RoomDaoImpl implements RoomDao{


	private BaseDao<Room> sbdao;

	public BaseDao<Room> getSbdao() {
		return sbdao;
	}

	public void setSbdao(BaseDao<Room> sbdao) {
		this.sbdao = sbdao;
	}

	@Override
	public List<Room> getAllRoom() {
		return sbdao.find("from Room");
	}

	@Override
	public void updateOrAddRoom(Room c) {
		sbdao.saveOrUpdate(c);
	}

	@Override
	public void deleteRoom(int id) {
		sbdao.delete(sbdao.get(Room.class, id));
	}

	@Override
	public Room getRoomById(int id) {
		return sbdao.get(Room.class, id);
	}
	
	@Override
	public Room getRoomByName(String name) {
		return sbdao.get("from Room where rmName = ?", name);
	}

	@Override
	public long getCount() {
		return sbdao.count("select count(rmid) from Room ");
	}

	
	
	@Override
	public List<Room> getAllByPage(PageBean pb) {
		List<Room> list = sbdao.find("from Room order by rmId", pb);
		return list;
	}

	@Override
	public List<Room> getAllByType(String type, PageBean pb) {
		List<Room> list = sbdao.find("from Room r where  r.roomType.rmTpName=? order by rmId", pb, type);
		return list;
	}

	@Override
	public long getCountByType(String type) {
		return sbdao.count("select count(rmid) from Room r where  r.roomType.rmTpName=? ",type);
	}

	@Override
	public long getFullCountByType(String type) {
		return sbdao.count("select count(rmid) from Room r where  r.roomType.rmTpName=? and r.rmState='在住' ",type);
	}

	@Override
	public void AddRoom(Room r) {
		sbdao.save(r);
		
	}

}
