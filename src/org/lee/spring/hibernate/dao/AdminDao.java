package org.lee.spring.hibernate.dao;


import org.lee.spring.hibernate.model.Admin;
import org.springframework.stereotype.Repository;

@Repository("adminDao")
public class AdminDao extends BaseDao<Admin> implements IAdminDao {

	
}
