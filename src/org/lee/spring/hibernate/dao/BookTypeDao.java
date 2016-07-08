package org.lee.spring.hibernate.dao;


import org.lee.spring.hibernate.model.BookType;
import org.springframework.stereotype.Repository;

@Repository("bookTypeDao")
public class BookTypeDao extends BaseDao<BookType> implements IBookTypeDao {

}
