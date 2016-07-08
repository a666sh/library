package org.lee.spring.hibernate.service;

import org.lee.spring.hibernate.model.Admin;
import org.lee.spring.hibernate.model.Pager;

public interface IAdminService {
	void add(Admin admin);
	void update(Admin admin);
	void delete(int id);
	Admin load(int id);
	Pager<Admin> find();
	Pager<Admin> findBeStop();
	Admin login(String username,String password);
}
