package com.etc.biz;

import java.util.List;

import com.etc.bean.Log;
import com.etc.bean.PageBean;

public interface LogIBiz {
		//获取所有日志信息
		public List<Log> getAllLog();
		//修改或增加日志信息
		public void updateOrAddLog(Log s);
		//删除日志
		public void deleteLog(int id);
		//根据ID获取日志信息
		public Log getLogById(int id);
		//获取日志总数量
		public long getCount();
		//分页查询日志
		public List<Log> getAllByPage(PageBean pb);
		//分页查询单个员工日志
		public List<Log> getIdByPage(PageBean pb,int empId);
}
