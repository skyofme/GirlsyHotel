package com.etc.test;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.etc.bean.Emp;
import com.etc.dao.impl.BaseDaoImpl;
import com.etc.dao.impl.EmpDaoImpl;

public class EmpTest {
	@Test
	public void test1() {
		ClassPathXmlApplicationContext cpxc = new ClassPathXmlApplicationContext("classpath:conf/services.xml");
		EmpDaoImpl dbi = cpxc.getBean("empDaoImpl", EmpDaoImpl.class);
		Emp f = dbi.doLogin("17744445555", "123456");
		System.out.println(f.getEmpName());
	}
	
	@Test
	public void test2() {
		ClassPathXmlApplicationContext cpxc = new ClassPathXmlApplicationContext("classpath:conf/services.xml");
		BaseDaoImpl dbi = cpxc.getBean("baseDaoImpl", BaseDaoImpl.class);
		EmpDaoImpl db = cpxc.getBean("empDaoImpl", EmpDaoImpl.class);
		dbi.delete(db.getEmpById(6));
		
	}
	
}
