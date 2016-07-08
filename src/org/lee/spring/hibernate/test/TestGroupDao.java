package org.lee.spring.hibernate.test;



import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.lee.spring.hibernate.dao.IAdminDao;
import org.lee.spring.hibernate.dao.IBookTypeDao;
import org.lee.spring.hibernate.dao.IPersonTypeDao;
import org.lee.spring.hibernate.model.Admin;
import org.lee.spring.hibernate.model.BookType;
import org.lee.spring.hibernate.model.PersonType;
import org.lee.spring.hibernate.service.IPersonTypeService;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/beans.xml"})
public class TestGroupDao {
	
	@Resource
	private IAdminDao adminDao;
	
	@Resource
	private IPersonTypeDao personTypeDao;
	
	@Resource
	private IBookTypeDao bookTypeDao;
	
	@Resource
	private IPersonTypeService personTypeService;
	@Test
	public void test01() {
		PersonType t=new PersonType();
		t.setName("本科生");
		t.setMaxNo(5);
		t.setDate(20);
		personTypeDao.add(t);
	}
	@Test
	public void test02() {
		Admin admin=new Admin();
		admin.setUsername("admin");
		admin.setPassword("123");
		admin.setAddress("广东省广州市番禺区");
		admin.setRelname("张大炮");
		admin.setTel("110");
		admin.setType(personTypeDao.load(1));
		adminDao.add(admin);
	}
	@Test
	public void test03() {
		Admin admin=adminDao.load(1);
		System.out.println(admin);
	}
	@Test
	public void testBooktype() {
		BookType t=new BookType();
		t.setName("文学类");
		bookTypeDao.add(t);
	}
	@Test
	public void testPersonTypeService() {
		PersonType t=new PersonType();
		t.setName("研究生");
		t.setMaxNo(7);
		t.setDate(30);
		personTypeService.add(t);
	}
}
