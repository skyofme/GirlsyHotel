package com.etc.dao.impl;

import java.util.List;

import com.etc.bean.Auth;
import com.etc.bean.Cus;
import com.etc.dao.AuthDao;
import com.etc.dao.BaseDao;

public class AuthDaoImpl implements AuthDao{

	private BaseDao<Auth> sbdao;
	
	@Override
	public List<Auth> getAllAuth() {
		// TODO Auto-generated method stub
		return sbdao.find("from Auth");
	}

	public BaseDao<Auth> getSbdao() {
		return sbdao;
	}

	public void setSbdao(BaseDao<Auth> sbdao) {
		this.sbdao = sbdao;
	}

}
