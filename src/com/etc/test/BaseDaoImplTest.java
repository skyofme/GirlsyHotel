package com.etc.test;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.etc.bean.PageBean;
import com.etc.bean.Room;
import com.etc.bean.RoomType;
import com.etc.dao.impl.BaseDaoImpl;
import com.etc.dao.impl.RoomDaoImpl;
import com.etc.dao.impl.RoomTypeDaoImpl;

class BaseDaoImplTest {
	//BaseDaoImpl bdi = new BaseDaoImpl();
	ApplicationContext context = new ClassPathXmlApplicationContext("classpath:conf/services.xml");
	BaseDaoImpl<RoomType> bdi = context.getBean("baseDaoImpl", BaseDaoImpl.class);
	RoomTypeDaoImpl bean = context.getBean("roomTypeDaoImpl",RoomTypeDaoImpl.class);
	
	BaseDaoImpl<Room> rbdi = context.getBean("baseDaoImpl", BaseDaoImpl.class);
	RoomDaoImpl rbean = context.getBean("roomDaoImpl",RoomDaoImpl.class);
	
	@Test
	void testFindStringObjectArray() {
		/*List<RoomType> find = bdi.find("from RoomType");
		System.out.println(find);*/
		
		//String hql = "from Room as r, RoomType as rt where rt.rmtpName = ?";
		String hql = "from Room where  Room.roomType.rmTpName=?";
		//List<Room> list = rbdi.find("from Room r where  r.roomType.rmTpName=?", "单人标间");
		List<Room> list = rbdi.find(hql, "单人标间");
		
		System.out.println(list.get(0).getRmName());
		
	}
	@Test
	void testGetSessionFactory() {
		SessionFactory sessionFactory = bdi.getSessionFactory();
		System.out.println(sessionFactory);
	}

	@Test
	void testSetSessionFactory() {
		SessionFactory sessionFactory = bdi.getSessionFactory();
		System.out.println(sessionFactory);
	}

	@Test
	void testSave() {
		RoomType roomType = new RoomType("123", 324, "321");
		bdi.save(roomType);
	}

	@Test
	void testDelete() {
		RoomType roomType = bdi.get(RoomType.class, 1);
		bdi.delete(roomType);
	}

	@Test
	void testUpdate() {
		RoomType roomType = bdi.get(RoomType.class, 2);
		roomType.setRmTpName("test");
		bdi.update(roomType);
	}

	@Test
	void testSaveOrUpdate() {
		RoomType roomType = bdi.get(RoomType.class, 2);
		roomType.setRmTpName("tset");
		bdi.update(roomType);
	}

	@Test
	void testMerge() {
		fail("Not yet implemented");
	}


	@Test
	void testFindStringListOfObject() {
		List<Object> list = new ArrayList<>();
		List<RoomType> find = bdi.find("from RoomType", list);
		System.out.println(find);
	}

	@Test
	void testFindStringPageBeanObjectArray() {
		List<RoomType> find = bdi.find("from RoomType", new PageBean(1,1));
		System.out.println(find);
	}

	@Test
	void testFindStringPageBeanListOfObject() {
		List<Object> list = new ArrayList<>();
		List<RoomType> find = bdi.find("from RoomType", new PageBean(1,1), list);
		System.out.println(find);
	}

	@Test
	void testGetClassOfTSerializable() {
		RoomType roomType = bdi.get(RoomType.class, 8);
		System.out.println(roomType);
	}

	@Test
	void testGetStringObjectArray() {
		RoomType roomType = bdi.get("from RoomType");
		System.out.println(roomType);
	}

	@Test
	void testGetStringListOfObject() {
		List<Object> list = new ArrayList<>();
		RoomType roomType = bdi.get("from RoomType", list);
		System.out.println(roomType);
	}

	@Test
	void testCountStringObjectArray() {
		//uniqueResult()...
		//query did not return a unique result
		Long count = bdi.count("select count(rmtpId) from RoomType");
		System.out.println(count);
	}

	@Test
	void testCountStringListOfObject() {
		List<Object> list = new ArrayList<>();
		Long count = bdi.count("select count(rmtpId) from RoomType");
		System.out.println(count);
	}

	@Test
	void testExecuteHqlStringObjectArray() {
		//not supported for select queries[from com.etc.bean.RoomType]
		Integer executeHql = bdi.executeHql("N\'select * from RoomType");
		System.out.println(executeHql);
	}

	@Test
	void testExecuteHqlStringListOfObject() {
		//同上
	}

	@Test
	void testExecuteSqlStringObjectArray() {
		//....
	}

	@Test
	void testExecuteSqlStringListOfObject() {
		//同上
	}

}
