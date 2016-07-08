package org.lee.spring.hibernate.service;

import javax.annotation.Resource;

import org.lee.spring.hibernate.dao.IAdminDao;
import org.lee.spring.hibernate.model.Admin;
import org.lee.spring.hibernate.model.Pager;
import org.springframework.stereotype.Service;

@Service("adminService")
public class AdminService implements IAdminService {
	private IAdminDao adminDao;
	
	
	public IAdminDao getAdminDao() {
		return adminDao;
	}
	@Resource
	public void setAdminDao(IAdminDao adminDao) {
		this.adminDao = adminDao;
	}

	@Override
	public void add(Admin admin) {
		adminDao.add(admin);
	}

	@Override
	public void update(Admin admin) {
		adminDao.update(admin);
	}

	@Override
	public void delete(int id) {
		adminDao.delete(id);
	}

	@Override
	public Admin load(int id) {
		return adminDao.load(id);
	}

	@Override
	public Pager<Admin> find() {
		return adminDao.find("select admin from Admin admin left join fetch admin.type where admin.status!=5 order by admin.id");
	}
	@Override
	public Pager<Admin> findBeStop() {
		return adminDao.find("select admin from Admin admin left join fetch admin.type where admin.status=5 order by admin.id");
	}
	@Override
	public Admin login(String username, String password) {
		Admin a=(Admin) adminDao.queryByHql("select a from Admin a where a.username=? and a.password=?",new Object[]{username,password});
		return a;
	}

}
