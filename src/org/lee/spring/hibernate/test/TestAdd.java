package org.lee.spring.hibernate.test;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.lee.spring.hibernate.model.Admin;
import org.lee.spring.hibernate.model.Book;
import org.lee.spring.hibernate.model.BookType;
import org.lee.spring.hibernate.model.Pager;
import org.lee.spring.hibernate.model.Reader;
import org.lee.spring.hibernate.model.ReaderBook;
import org.lee.spring.hibernate.service.IAdminService;
import org.lee.spring.hibernate.service.IBookService;
import org.lee.spring.hibernate.service.IPersonTypeService;
import org.lee.spring.hibernate.service.IReaderService;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/beans.xml"})
public class TestAdd {
	@Resource
	private IReaderService readerService;
	@Resource
	private IPersonTypeService personTypeService;
	@Resource
	private IBookService bookService;
	@Resource
	private IAdminService adminService;
	@Test
	public void add() {
		for(int i=0;i<=20;i++) {
			Reader reader=new Reader();
			reader.setSex("男");
			reader.setPassword("123");
			reader.setCreateDate(new Date());
			reader.setType(personTypeService.load(1));
			reader.setUsername("dashan");
			reader.setCurNo(0);
			readerService.add(reader);
		}
	}
	@Test
	public void addBook() {
		readerService.addReaderBook(24, 1);
	}
	@Test
	public void test01() {
		Book b=new Book();
		BookType bt=new BookType();
		bt.setId(1);
		bt.setName("文学类");
		b.setAuthor("涨到怕");
		b.setBookNo(20);
		b.setIsbn("654564546545");
		b.setBooktype(bt);
		b.setName("校长日记");
		b.setPrice(523.3);
		b.setPublisher("好人出版社");
		b.setStatus(0);
		bookService.add(b);
	}
	
	@Test
	public void testLogin() {
		Admin a=adminService.login("admin", "123");
		System.out.println(a);
		System.out.println(a==null);
	}
	@Test
	public void testLoginReader() {
		Reader r=readerService.login("zhangsan", "222");
		System.out.println(r==null);
	}
	@Test
	public void testReaderBook() {
		Pager<ReaderBook> rbs=readerService.listReaderBook();
		for(ReaderBook rb:rbs.getDatas()) {
			System.out.println(rb.getPayMoney());
		}
	}
	@Test
	public void testResource() {
		System.out.println(TestAdd.class.getClassLoader().getResource(""));
	}
}
