package org.lee.spring.hibernate.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.lee.spring.hibernate.model.Book;
import org.lee.spring.hibernate.model.BookType;
import org.lee.spring.hibernate.model.Pager;

public interface IBookService {
	void add(Book b,int tid);
	void add(Book b);
	void addBookType(BookType bt);
	void deleteBookType(int tid);
	void updateBookType(BookType bt);
	BookType loadBookType(int tid);
	List<BookType> listBookType();
	void delete(int id);
	void update(Book b);
	void update(Book b,int tid) throws IllegalAccessException, InvocationTargetException;
	Book load(int id);
	List<Book> listAll();
	Pager<Book> find();
	long getUseableCount(int bid);
	long countBookByType(int tid);
}
