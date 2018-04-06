package com.etc.test;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.etc.bean.Ord;
import com.etc.biz.impl.EmpIBizImpl;
import com.etc.biz.impl.OrdIBizImpl;
import com.etc.dao.impl.OrdDaoImpl;

public class OrdTest {
	@Test
	public void test1() {
		ClassPathXmlApplicationContext cpxc = new ClassPathXmlApplicationContext("classpath:conf/services.xml");
		OrdDaoImpl dbi = cpxc.getBean("ordDaoImpl", OrdDaoImpl.class);
//		Ord o = dbi.getOrdById(1);
		long count=dbi.getCount();
		System.out.println(count);
//		System.out.println(o.getOrdId()+o.getCus().getCusName());
	}
	
	@Test
	public void test2() {
		ClassPathXmlApplicationContext cpxc = new ClassPathXmlApplicationContext("classpath:conf/services.xml");
		ClassPathXmlApplicationContext cpxc1 = new ClassPathXmlApplicationContext("classpath:conf/services_base.xml");
		//HttpSession session = cpxc.getBean("sessionFactory", HttpSession.class);
		//EmpIBizImpl ebi = cpxc.getBean("emplBizImpl", EmpIBizImpl.class);
		//HttpSession session = ServletActionContext.getRequest().getSession();
		//session.setAttribute("login", ebi.getEmpById(1));
		OrdIBizImpl dbi = cpxc.getBean("ordBizImpl", OrdIBizImpl.class);
		Ord o = dbi.getOrdById(1);
		dbi.doLog("修改", o);
	}
	
	
}
