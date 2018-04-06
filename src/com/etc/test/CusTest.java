package com.etc.test;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.etc.bean.Cus;
import com.etc.bean.Ord;
import com.etc.dao.impl.BaseDaoImpl;
import com.etc.dao.impl.CusDaoImpl;


public class CusTest {
	@Test
	public void Test() {
		ClassPathXmlApplicationContext cpxc = new ClassPathXmlApplicationContext("classpath:conf/services_base.xml");
		BaseDaoImpl dbi = cpxc.getBean("baseDaoImpl", BaseDaoImpl.class);
		SessionFactory sf=dbi.getSessionFactory();
		Session session=sf.openSession();
		Cus cus=session.get(Cus.class, 1);
		System.out.println("+++++++++"+cus);
		/*Set<Ord> olist=cus.getOlist();
	    for (Ord ord : olist) {
			System.out.println("订单信息:"+olist);
		}*/
	}
}
