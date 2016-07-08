package org.lee.spring.hibernate.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.annotation.Resource;

import org.lee.spring.hibernate.dao.IBookDao;
import org.lee.spring.hibernate.dao.IBookTypeDao;
import org.lee.spring.hibernate.model.Book;
import org.lee.spring.hibernate.model.BookType;
import org.lee.spring.hibernate.model.LibException;
import org.lee.spring.hibernate.model.Pager;
import org.springframework.stereotype.Service;

@Service("bookService")
public class BookService implements IBookService {
	private IBookDao bookDao;
	private IBookTypeDao bookTypeDao;
	
	public IBookTypeDao getBookTypeDao() {
		return bookTypeDao;
	}
	
	@Resource
	public void setBookTypeDao(IBookTypeDao bookTypeDao) {
		this.bookTypeDao = bookTypeDao;
	}

	public IBookDao getBookDao() {
		return bookDao;
	}
	
	@Resource
	public void setBookDao(IBookDao bookDao) {
		this.bookDao = bookDao;
	}

	@Override
	public void add(Book b,int tid) {
		BookType bt=bookTypeDao.load(tid);
		b.setBooktype(bt);
		bookDao.add(b);
	}

	@Override
	public long getUseableCount(int bid) {
		return bookDao.getUseableCount(bid);
	}

	@Override
	public void delete(int id) {
		long count = bookDao.getUseableCount(id);
		if(count>0) throw new LibException("要删除的图书正在被借阅");
		bookDao.delete(id);
	}

	@Override
	public void update(Book b) {
		bookDao.update(b);
	}

	@Override
	public Book load(int id) {
		return bookDao.load(id);
	}

	@Override
	public List<Book> listAll() {
		return bookDao.list("select book from Book book left join fetch book.booktype");
	}

	@Override
	public Pager<Book> find() {
		return bookDao.find("select book from Book book left join fetch book.booktype order by book.id");
	}

	@Override
	public void addBookType(BookType bt) {
		bookTypeDao.add(bt);
	}

	@Override
	public void deleteBookType(int tid) {
		bookTypeDao.delete(tid);
	}

	@Override
	public void updateBookType(BookType bt) {
		bookTypeDao.update(bt);
	}

	@Override
	public BookType loadBookType(int tid) {
		return bookTypeDao.load(tid);
	}

	@Override
	public List<BookType> listBookType() {
		return bookTypeDao.list("from BookType");
	}

	@Override
	public long countBookByType(int tid) {
		return (long) bookTypeDao.queryByHql("select count(*) from Book b where b.booktype.id=?",tid);
	}

	@Override
	public void add(Book b) {
		bookDao.add(b);
	}

	@Override
	public void update(Book b, int tid) throws IllegalAccessException, InvocationTargetException {
		BookType bt=bookTypeDao.load(tid);
		b.setBooktype(bt);
		bookDao.update(b);
	}



}
