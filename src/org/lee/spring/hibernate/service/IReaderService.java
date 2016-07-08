package org.lee.spring.hibernate.service;

import java.util.List;

import org.lee.spring.hibernate.model.Pager;
import org.lee.spring.hibernate.model.Reader;
import org.lee.spring.hibernate.model.ReaderBook;

public interface IReaderService {
	void add(Reader reader);
	void add(Reader rader,int tid);
	void update(Reader reader);
	void delete(int id);
	Reader load(int id);
	Pager<Reader> find();
	List<Reader> listAll();
	/**
	 * 列表所有的借阅信息
	 * @return
	 */
	Pager<ReaderBook> listReaderBook();
	/**
	 * 通过读者id和状态查找借阅信息
	 * @param rid
	 * @return
	 */
	Pager<ReaderBook> listReaderBookByrId(int rid,int status);
	/**
	 * 通过书籍id和状态查找借阅信息
	 * @param bid
	 * @return
	 */
	Pager<ReaderBook> listReaderBookBybId(int bid,int status);
	Pager<ReaderBook> listReaderBookByrb(int rid,int bid,Integer status);
	void addReaderBook(int rid,int bid);
	void deleteReaderBook(int rbid); 
	List<ReaderBook> getReaderBookByRid(int rid);
	long getReaderBookCount(int rid);
	Reader login(String username,String password);
	void receiveReaderBook(int rbid);
	List<ReaderBook> getReaderBookByRidDesc(int id);
}
