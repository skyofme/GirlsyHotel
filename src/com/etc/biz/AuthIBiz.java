package com.etc.biz;

import java.util.List;

import com.etc.bean.Auth;
import com.etc.dao.AuthDao;

public interface AuthIBiz {
	//查询所有权限
	public List<Auth> getAllAuth();
}
