package com.etc.dao.impl;

import java.util.List;

import com.etc.bean.Emp;
import com.etc.bean.PageBean;
import com.etc.bean.RoomType;
import com.etc.dao.BaseDao;
import com.etc.dao.RoomTypeDao;

public class RoomTypeDaoImpl implements RoomTypeDao{


	private BaseDao<RoomType> sbdao;

	public BaseDao<RoomType> getSbdao() {
		return sbdao;
	}

	public void setSbdao(BaseDao<RoomType> sbdao) {
		this.sbdao = sbdao;
	}

	@Override
	public List<RoomType> getAllRoomType() {
		return sbdao.find("from RoomType");
	}

	@Override
	public void updateOrAddRoomType(RoomType s) {
		sbdao.saveOrUpdate(s);
	}

	@Override
	public RoomType getRoomTypeById(int id) {
		return sbdao.get(RoomType.class, id);
	}

	@Override
	public long getCount() {
		Long row = sbdao.count("select count(rmTpId) from RoomType");
		return row;
	}
	
	@Override
	public List<RoomType> getAllByPage(PageBean pb) {
		List<RoomType> rtlist = sbdao.find("from RoomType order by rmTpId", pb);
		return rtlist;
	}

	public RoomType doLogin(String string, String string2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addRoomType(RoomType s) {
		sbdao.save(s);
	}

	@Override
	public int getRtByMaxId() {
		return sbdao.maxid("SELECT MAX(rmTpId) FROM RoomType");
	}

	
	

}
