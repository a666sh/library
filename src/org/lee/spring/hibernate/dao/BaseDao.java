package org.lee.spring.hibernate.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.lee.spring.hibernate.model.Pager;
import org.lee.spring.hibernate.model.SystemContext;


@SuppressWarnings("unchecked")
public class BaseDao<T> implements IBaseDao<T> {
	
	private SessionFactory sessionFactory;
	private Class<T> clz;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	protected Session getSession() {
		//获取session，不使用openSession,getCurrenSession才能被spring管理
		return sessionFactory.getCurrentSession();
	}
	private Class<T> getClazz() {
		if(clz==null) {
			clz = ((Class<T>)
					(((ParameterizedType)(this.getClass().getGenericSuperclass())).getActualTypeArguments()[0]));
		}
		return clz;
	}
	@Override
	public void add(T t) {
		getSession().save(t);
	}

	@Override
	public void update(T t) {
		getSession().update(t);
	}

	@Override
	public void delete(int id) {
		getSession().delete(this.load(id));
	}

	@Override
	public T load(int id) {
		T t=(T) getSession().load(getClazz(), id);
		return t;
	}

	@Override
	public List<T> list(String hql, Object[] args) {
		Query q=getSession().createQuery(hql);
		if(args!=null) {
			for(int i=0;i<args.length;i++) {
				q.setParameter(i, args[i]);
			}
		}
		List<T> list=q.list();
		return list;
	}

	@Override
	public List<T> list(String hql, Object arg) {
		return this.list(hql, new Object[]{arg});
	}

	@Override
	public List<T> list(String hql) {
		return this.list(hql, null);	
	}

	@Override
	public Pager<T> find(String hql, Object[] args) {
		Pager<T> pages = new Pager<T>();
		int pageOffset = SystemContext.getPageOffset();
		int pageSize = SystemContext.getPageSize();
		Query q = this.getSession().createQuery(hql);
		Query cq = this.getSession().createQuery(getCountHql(hql));
		if(args!=null) {
			int index = 0;
			for(Object arg:args) {
				q.setParameter(index, arg);
				cq.setParameter(index, arg);
				index++;
			}
		}
		long totalRecord = (Long)cq.uniqueResult();
		q.setFirstResult(pageOffset);
		q.setMaxResults(pageSize);
		List<T> datas = q.list();
		pages.setDatas(datas);
		pages.setPageOffset(pageOffset);
		pages.setPageSize(pageSize);
		pages.setTotalRecord(totalRecord);
		return pages;
	}
	private String getCountHql(String hql) {
		//1、获取from前面的字符串
		String f = hql.substring(0, hql.indexOf("from"));
		//2、将from前面的字符串替换为select count(*) 
		if(f.equals("")) {
			hql = "select count(*) "+hql;
		} else {
			hql = hql.replace(f, "select count(*) ");
		}
		//3、将fetch替换为""，因为抓取查询不能使用count(*)
		hql = hql.replace("fetch"," ");
		return hql;
	}

	@Override
	public Pager<T> find(String hql, Object arg) {
		return this.find(hql, new Object[]{arg});
	}

	@Override
	public Pager<T> find(String hql) {
		return this.find(hql, null);
	}
	private Query setParamterQuery(String hql,Object[] args) {
		Query q = this.getSession().createQuery(hql);
		if(args!=null) {
			for(int i=0;i<args.length;i++) {
				q.setParameter(i, args[i]);
			}
		}
		return q;
	}
	@Override
	public Object queryByHql(String hql, Object[] args) {
		Query q=this.setParamterQuery(hql, args);
		return q.uniqueResult();
	}

	@Override
	public Object queryByHql(String hql, Object arg) {
		return this.queryByHql(hql, new Object[]{arg});
	}

	@Override
	public Object queryByHql(String hql) {
		return this.queryByHql(hql, null);
	}


	@Override
	public List<Object> listObj(String hql, Object[] args) {
		Query q=this.setParamterQuery(hql, args);
		return q.list();
	}

	@Override
	public List<Object> listObj(String hql, Object arg) {
		return this.listObj(hql, new Object[]{arg});
	}

	@Override
	public List<Object> listObj(String hql) {
		return this.listObj(hql, null);
	}

	@Override
	public Pager<Object> findObj(String hql, Object[] args) {
		Pager<Object> pages = new Pager<Object>();
		int pageOffset = SystemContext.getPageOffset();
		int pageSize = SystemContext.getPageSize();
		Query q = this.getSession().createQuery(hql);
		Query cq = this.getSession().createQuery(getCountHql(hql));
		if(args!=null) {
			int index = 0;
			for(Object arg:args) {
				q.setParameter(index, arg);
				cq.setParameter(index, arg);
				index++;
			}
		}
		long totalRecord = (Long)cq.uniqueResult();
		q.setFirstResult(pageOffset);
		q.setMaxResults(pageSize);
		List<Object> datas = q.list();
		pages.setDatas(datas);
		pages.setPageOffset(pageOffset);
		pages.setPageSize(pageSize);
		pages.setTotalRecord(totalRecord);
		return pages;
	}

	@Override
	public Pager<Object> findObj(String hql, Object arg) {
		return this.findObj(hql, new Object[]{arg});
	}

	@Override
	public Pager<Object> findObj(String hql) {
		return this.findObj(hql,null);
	}

}
