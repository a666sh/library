package org.lee.spring.hibernate.dao;

import org.lee.spring.hibernate.model.Reader;

public interface IReaderDao extends IBaseDao<Reader>{
	long getNumberByType(int personTypeId);
}
