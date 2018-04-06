package com.etc.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.etc.bean.PageBean;
import com.etc.dao.BaseDao;

public class BaseDaoImpl<T> implements BaseDao<T> {
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getSession() {
		return sessionFactory.openSession();
	}

	@Override
	public Serializable save(T o) {
		Session session = this.getSession();
		Transaction tx = session.beginTransaction();
		Serializable serializable = session.save(o);
		tx.commit();
		session.close();
		return serializable;
	}

	@Override
	public void delete(T o) {
		Session session = this.getSession();
		Transaction tx = session.beginTransaction();
		session.delete(o);
		tx.commit();
		session.close();
	}

	@Override
	public void update(T o) {
		Session session = this.getSession();
		Transaction tx = session.beginTransaction();
		session.flush();
		session.update(o);
		tx.commit();
		session.close();

	}
	

	@Override
	public void saveOrUpdate(T o) {
		Session session = this.getSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(o);
		tx.commit();
		session.close();
	}

	@Override
	public void merge(T o) {
		Session session = this.getSession();
		Transaction tx = session.beginTransaction();
		session.merge(o);
		tx.commit();
		session.close();
	}

	@Override
	public List<T> find(String hql, Object... param) {
		Session session = this.getSession();
		Transaction tx = session.beginTransaction();
		Query q = session.createQuery(hql);
		if (param != null && param.length > 0) {
			for (int i = 0; i < param.length; i++) {
				q.setParameter(i, param[i]);
			}
		}
		List<T> list = q.list();
		tx.commit();
		session.close();
		return list;
	}

	@Override
	public List<T> find(String hql, List<Object> param) {
		Session session = this.getSession();
		Transaction tx = session.beginTransaction();
		Query q = session.createQuery(hql);
		if (param != null && param.size() > 0) {
			for (int i = 0; i < param.size(); i++) {
				q.setParameter(i, param.get(i));
			}
		}
		List<T> list = q.list();
		tx.commit();
		session.close();
		return list;
	}

	@Override
	public List<T> find(String hql, PageBean pageBean, Object... param) {
		Session session = this.getSession();
		Transaction tx = session.beginTransaction();
		Query q = session.createQuery(hql);
		if (param != null && param.length > 0) {
			for (int i = 0; i < param.length; i++) {
				q.setParameter(i, param[i]);
			}
		}
		List<T> list = q.setFirstResult(pageBean.getStart()).setMaxResults(pageBean.getPageSize()).list();
		tx.commit();
		session.close();
		return list;
	}

	@Override
	public List<T> find(String hql, PageBean pageBean, List<Object> param) {
		Session session = this.getSession();
		Transaction tx = session.beginTransaction();
		Query q = session.createQuery(hql);
		if (param != null && param.size() > 0) {
			for (int i = 0; i < param.size(); i++) {
				q.setParameter(i, param.get(i));
			}
		}
		List<T> list = q.setFirstResult(pageBean.getStart()).setMaxResults(pageBean.getPageSize()).list();
		tx.commit();
		session.close();
		return list;
	}

	@Override
	public T get(Class<T> c, Serializable id) {
		Session session = this.getSession();
		Transaction tx = session.beginTransaction();
		T t = session.get(c, id);
		tx.commit();
		session.close();
		return t;
	}

	@Override
	public T get(String hql, Object... param) {
		List<T> l = this.find(hql, param);
		if (l != null && l.size() > 0) {
			return l.get(0);
		} else {
			return null;
		}
	}

	@Override
	public T get(String hql, List<Object> param) {
		List<T> l = this.find(hql, param);
		if (l != null && l.size() > 0) {
			return l.get(0);
		} else {
			return null;
		}
	}

	@Override
	public Long count(String hql, Object... param) {
		Session session = this.getSession();
		Transaction tx = session.beginTransaction();
		Query q = session.createQuery(hql);
		if (param != null && param.length > 0) {
			for (int i = 0; i < param.length; i++) {
				q.setParameter(i, param[i]);
			}
		}
		Long l = (Long) q.uniqueResult();
		tx.commit();
		session.close();
		//return (long) q.list().size();
		return l;
	}
	@Override
	public int maxid(String hql, Object... param) {
		Session session = this.getSession();
		Transaction tx = session.beginTransaction();
		Query q = session.createQuery(hql);
		if (param != null && param.length > 0) {
			for (int i = 0; i < param.length; i++) {
				q.setParameter(i, param[i]);
			}
		}
		int l = (int) q.uniqueResult();
		tx.commit();
		session.close();
		//return (long) q.list().size();
		return l;
	}

	@Override
	public Long count(String hql, List<Object> param) {
		Session session = this.getSession();
		Transaction tx = session.beginTransaction();
		Query q = session.createQuery(hql);
		if (param != null && param.size() > 0) {
			for (int i = 0; i < param.size(); i++) {
				q.setParameter(i, param.get(i));
			}
		}
		Long l = (Long) q.uniqueResult();
		tx.commit();
		session.close();
		return l;
	}

	@Override
	public Integer executeHql(String hql, Object... param) {
		Session session = this.getSession();
		Transaction tx = session.beginTransaction();
		Query q = session.createQuery(hql);
		if (param != null && param.length > 0) {
			for (int i = 0; i < param.length; i++) {
				q.setParameter(i, param[i]);
			}
		}
		int row = q.executeUpdate();
		tx.commit();
		session.close();
		return row;
	}

	@Override
	public Integer executeHql(String hql, List<Object> param) {
		Session session = this.getSession();
		Transaction tx = session.beginTransaction();
		Query q = session.createQuery(hql);
		if (param != null && param.size() > 0) {
			for (int i = 0; i < param.size(); i++) {
				q.setParameter(i, param.get(i));
			}
		}
		int row = q.executeUpdate();
		tx.commit();
		session.close();
		return row;
	}

	@Override
	public Integer executeSql(String sql, Object... param) {
		Session session = this.getSession();
		Transaction tx = session.beginTransaction();
		Query q = session.createSQLQuery(sql);
		if (param != null && param.length > 0) {
			for (int i = 0; i < param.length; i++) {
				q.setParameter(i, param[i]);
			}
		}
		int row = q.executeUpdate();
		tx.commit();
		session.close();
		return row;
	}

	@Override
	public Integer executeSql(String sql, List<Object> param) {
		Session session = this.getSession();
		Transaction tx = session.beginTransaction();
		Query q = session.createSQLQuery(sql);
		if (param != null && param.size() > 0) {
			for (int i = 0; i < param.size(); i++) {
				q.setParameter(i, param.get(i));
			}
		}
		int row = q.executeUpdate();
		tx.commit();
		session.close();
		return row;
	}

}
