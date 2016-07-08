package org.lee.spring.hibernate.dao;


import org.lee.spring.hibernate.model.Reader;
import org.springframework.stereotype.Repository;

@Repository("readerDao")
public class ReaderDao extends BaseDao<Reader> implements IReaderDao {

	@Override
	public long getNumberByType(int personTypeId) {
		String hql="select count(*) from Reader r where r.type.id=?";
		return (long) this.getSession().createQuery(hql).setParameter(0, personTypeId).uniqueResult();
	}


}
