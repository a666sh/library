package org.lee.spring.hibernate.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.lee.spring.hibernate.dao.IBookDao;
import org.lee.spring.hibernate.dao.IPersonTypeDao;
import org.lee.spring.hibernate.dao.IReaderBookDao;
import org.lee.spring.hibernate.dao.IReaderDao;
import org.lee.spring.hibernate.model.Book;
import org.lee.spring.hibernate.model.LibException;
import org.lee.spring.hibernate.model.Pager;
import org.lee.spring.hibernate.model.PersonType;
import org.lee.spring.hibernate.model.Reader;
import org.lee.spring.hibernate.model.ReaderBook;
import org.springframework.stereotype.Service;

@Service("readerService")
public class ReaderService implements IReaderService {
	private IReaderDao readerDao;
	private IReaderBookDao readerBookDao;
	private IBookDao bookDao;
	private IPersonTypeDao personTypeDao;
	

	public IPersonTypeDao getPersonTypeDao() {
		return personTypeDao;
	}

	@Resource
	public void setPersonTypeDao(IPersonTypeDao personTypeDao) {
		this.personTypeDao = personTypeDao;
	}

	public IBookDao getBookDao() {
		return bookDao;
	}
	
	@Resource
	public void setBookDao(IBookDao bookDao) {
		this.bookDao = bookDao;
	}

	public IReaderBookDao getReaderBookDao() {
		return readerBookDao;
	}
	
	@Resource
	public void setReaderBookDao(IReaderBookDao readerBookDao) {
		this.readerBookDao = readerBookDao;
	}
	
	public IReaderDao getReaderDao() {
		return readerDao;
	}
	
	@Resource
	public void setReaderDao(IReaderDao readerDao) {
		this.readerDao = readerDao;
	}

	@Override
	public void add(Reader reader) {
		long num1=(long) readerDao.queryByHql("select count(*) from Reader r where r.username=?",reader.getUsername());
		long num2=(long) readerDao.queryByHql("select count(*) from Admin r where r.username=?",reader.getUsername());
		if(num1>0||num2>0) {
			throw new LibException("要添加的用户用户名已经存在");
		}
		readerDao.add(reader);
	}

	@Override
	public void update(Reader reader) {
		readerDao.update(reader);
	}

	@Override
	public Reader load(int id) {
		return readerDao.load(id);
	}

	@Override
	public Pager<Reader> find() {
		return readerDao.find("from Reader r left join fetch r.type order by r.id");
	}

	@Override
	public List<Reader> listAll() {
		return readerDao.list("select reader from Reader reader");
	}
	@Override
	public void delete(int id) {
		readerDao.delete(id);
	}
	@Override
	public void addReaderBook(int rid, int bid) {
		Reader r=readerDao.load(rid);
		int max=r.getType().getMaxNo();
		int cur=r.getCurNo();
		if(cur>=max) {
			throw new LibException("要办理借书的用户已达到借书数量上限!");
		}
		Book b=bookDao.load(bid);
		ReaderBook rb=new ReaderBook();
		rb.setBook(b);
		rb.setReader(r);
		Date nowDate=new Date();
		rb.setStartDate(nowDate);
		long days=r.getType().getDate();
		long time=nowDate.getTime()+days*24*60*60*1000;
		Date endDate=new Date(time);
		rb.setEndDate(endDate);
		rb.setStatus(0);
		rb.setPayMoney(0);
		rb.setFineType(0);
		readerBookDao.add(rb);
		r.setCurNo(r.getCurNo()+1);
		readerDao.update(r);
		long bookCurNo=bookDao.getUseableCount(bid);
		if(bookCurNo==b.getBookNo()) {
			b.setStatus(1);
			bookDao.update(b);
		}
	}
	@Override
	public void deleteReaderBook(int rbid) {
		
	}

	@Override
	public List<ReaderBook> getReaderBookByRid(int rid) {
		String hql="select rb from ReaderBook rb where rb.reader.id=?";
		List<ReaderBook> rbs=readerBookDao.list(hql, rid);
		return rbs;
	}

	@Override
	public void add(Reader reader, int tid) {
		PersonType p=personTypeDao.load(tid);
		reader.setType(p);
		long num1=(long) readerDao.queryByHql("select count(*) from Reader r where r.username=?",reader.getUsername());
		long num2=(long) readerDao.queryByHql("select count(*) from Admin r where r.username=?",reader.getUsername());
		if(num1>0||num2>0) {
			throw new LibException("要添加的用户用户名已经存在");
		}
		readerDao.add(reader);
	}

	@Override
	public long getReaderBookCount(int rid) {
		String hql="select count(*) from ReaderBook rb where rb.reader.id=? and (rb.status=0 or rb.status=2)";
		long count=(long) readerBookDao.queryByHql(hql,rid);
		return count;
	}

	@Override
	public Reader login(String username, String password) {
		Reader r=(Reader) readerDao.queryByHql("select r from Reader r where username=? and password=?",new Object[]{username,password});
		return r;
	}

	@Override
	public Pager<ReaderBook> listReaderBook() {
		return readerBookDao.find("select rd from ReaderBook rd left join fetch rd.reader as r left join fetch rd.book as b left join fetch r.type left join fetch b.booktype order by rd.startDate desc");
	}

	@Override
	public Pager<ReaderBook> listReaderBookByrId(int rid, int status) {
		String hql="select rd from ReaderBook rd left join fetch rd.reader as r left join fetch rd.book as b left join fetch r.type left join fetch b.booktype where rd.reader.id=? and rd.status=? order by rd.startDate desc";
		return readerBookDao.find(hql, new Object[]{rid,status});
	}

	@Override
	public Pager<ReaderBook> listReaderBookBybId(int bid, int status) {
		String hql="select rd from ReaderBook rd left join fetch rd.reader as r left join fetch rd.book as b left join fetch r.type left join fetch b.booktype where rd.book.id=? and rd.status=? order by rd.startDate desc";
		return readerBookDao.find(hql, new Object[]{bid,status});
	}

	@Override
	public Pager<ReaderBook> listReaderBookByrb(int rid, int bid, Integer status) {
		String hql=null;
		if(status!=null) {
			hql="select rd from ReaderBook rd left join fetch rd.reader as r left join fetch rd.book as b left join fetch r.type left join fetch b.booktype where rd.reader.id=? and rd.book.id=? and rd.status=? order by rd.startDate desc";
			return readerBookDao.find(hql, new Object[]{rid,bid,status});
		} else {
			hql="select rd from ReaderBook rd left join fetch rd.reader as r left join fetch rd.book as b left join fetch r.type left join fetch b.booktype where rd.reader.id=? and rd.book.id=? order by rd.startDate desc";
		}
		return readerBookDao.find(hql, new Object[]{rid,bid});
	}

	@Override
	public void receiveReaderBook(int rbid) {
		ReaderBook rb=readerBookDao.load(rbid);
		rb.setStatus(1);
		rb.setReaDate(new Date());
		readerBookDao.update(rb);
		Reader r=rb.getReader();
		r.setCurNo(r.getCurNo()-1);
		readerDao.update(r);
		Book b=rb.getBook();
		if(b.getStatus()==1) {
			b.setStatus(0);
			bookDao.update(b);
		}
	}

	@Override
	public List<ReaderBook> getReaderBookByRidDesc(int id) {
		String hql="select rb from ReaderBook rb where rb.reader.id=? order by rb.startDate desc";
		List<ReaderBook> rbs=readerBookDao.list(hql, id);
		return rbs;
	}

	
	
}
