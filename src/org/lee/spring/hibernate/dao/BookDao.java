package org.lee.spring.hibernate.dao;


import org.lee.spring.hibernate.model.Book;
import org.springframework.stereotype.Repository;

@Repository("bookDao")
public class BookDao extends BaseDao<Book> implements IBookDao {

	@Override
	public long getUseableCount(int bid) {
		long count=(long)this.queryByHql("select count(*) from ReaderBook rb where rb.book.id=? and rb.status=0",bid);
		return count;
	}
	@Override
	public Book load(int id) {
		return (Book) this.getSession().get(Book.class, id);
	}
}
