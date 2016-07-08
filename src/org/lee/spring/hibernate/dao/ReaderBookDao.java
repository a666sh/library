package org.lee.spring.hibernate.dao;


import org.lee.spring.hibernate.model.ReaderBook;
import org.springframework.stereotype.Repository;

@Repository("readerBookDao")
public class ReaderBookDao extends BaseDao<ReaderBook> implements IReaderBookDao {

	
}
