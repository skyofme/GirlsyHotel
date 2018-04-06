package com.etc.biz;

import java.io.IOException;
import java.util.List;

import com.etc.bean.Cus;
import com.etc.bean.Ord;
import com.etc.bean.PageBean;
import com.etc.bean.Room;

public interface OrdIBiz {
		//获取所有订单信息
		public List<Ord> getAllOrd();
		//修改或增加订单信息
		public void updateOrAddOrd(Ord o);
		//删除订单
		public void deleteOrd(int id);
		//根据ID获取订单信息
		public Ord getOrdById(int id);
		//获取订单总数量
		public long getCount();
		//分页查询员工
		public List<Ord> getAllByPage(PageBean pb);
		//分页查询客户id为？的订单详情
		public List<Ord> getOrdByPage(PageBean pb,int cusId);
		//通过JSP修改订单
		public Ord updateOrd(Ord o );
		//查询客户id为？的订单详情
		public List<Ord> getOrd(int cusId);
		//分页查询并发送相应的session
		public void getOrdPageAndSendSess(int start,int pagesize);
		//调用AJAX方法
		public void doAJAX(String json) throws IOException;
		//生成日志
		public void doLog(String op,Ord o);
		//增加订单
		public void addOrd(Ord o,Room r,Cus c);
		

}
