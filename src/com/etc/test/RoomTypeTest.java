package com.etc.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.etc.bean.Emp;
import com.etc.bean.RoomType;
import com.etc.dao.impl.EmpDaoImpl;
import com.etc.dao.impl.RoomTypeDaoImpl;

	public class RoomTypeTest {
		public void test1() {
		ClassPathXmlApplicationContext cpxc = new ClassPathXmlApplicationContext("classpath:conf/services.xml");
		RoomTypeDaoImpl dbi = cpxc.getBean("roomTypeDaoImpl", RoomTypeDaoImpl.class);
		RoomType f = dbi.doLogin("17744445555", "123456");
		System.out.println(f.getRmTpId());
		}
		
}

