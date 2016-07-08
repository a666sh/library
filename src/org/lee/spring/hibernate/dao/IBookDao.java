package org.lee.spring.hibernate.dao;

import org.lee.spring.hibernate.model.Book;

public interface IBookDao extends IBaseDao<Book> {
	long getUseableCount(int bid);
}
