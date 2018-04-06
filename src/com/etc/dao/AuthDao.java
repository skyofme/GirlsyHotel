package com.etc.dao;

import java.util.List;

import com.etc.bean.Auth;

public interface AuthDao {
	//查询所有权限
	public List<Auth> getAllAuth();
}
