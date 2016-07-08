package org.lee.spring.hibernate.dao;

import java.util.List;

import org.lee.spring.hibernate.model.Pager;

public interface IBaseDao<T> {
	void add(T t);
	void update(T t);
	void delete(int id);
	T load(int id);
	List<T> list(String hql,Object[] args);
	List<T> list(String hql,Object arg);
	List<T> list(String hql);
	
	Pager<T> find(String hql,Object[] args);
	Pager<T> find(String hql,Object arg);
	Pager<T> find(String hql);
	
	Object queryByHql(String hql,Object[] args);
	Object queryByHql(String hql,Object arg);
	Object queryByHql(String hql);
	
	List<Object> listObj(String hql,Object[] args);
	List<Object> listObj(String hql,Object arg);
	List<Object> listObj(String hql);
	
	Pager<Object> findObj(String hql,Object[] args);
	Pager<Object> findObj(String hql,Object arg);
	Pager<Object> findObj(String hql);
}
