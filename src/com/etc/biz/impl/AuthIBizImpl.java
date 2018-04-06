package com.etc.biz.impl;

import java.util.List;

import com.etc.bean.Auth;
import com.etc.biz.AuthIBiz;
import com.etc.dao.AuthDao;

public class AuthIBizImpl implements AuthIBiz{
	private AuthDao adi ;

	public AuthDao getAdi() {
		return adi;
	}

	public void setAdi(AuthDao adi) {
		this.adi = adi;
	}

	@Override
	public List<Auth> getAllAuth() {
		// TODO Auto-generated method stub
		return adi.getAllAuth();
	}
}
