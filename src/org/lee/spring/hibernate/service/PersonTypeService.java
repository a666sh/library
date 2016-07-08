package org.lee.spring.hibernate.service;

import java.util.List;

import javax.annotation.Resource;

import org.lee.spring.hibernate.dao.IPersonTypeDao;
import org.lee.spring.hibernate.dao.IReaderDao;
import org.lee.spring.hibernate.model.LibException;
import org.lee.spring.hibernate.model.PersonType;
import org.springframework.stereotype.Service;


@Service("personTypeService")
public class PersonTypeService implements IPersonTypeService {
	
	private IPersonTypeDao personTypeDao;
	private IReaderDao readerDao;
	
	
	public IReaderDao getReaderDao() {
		return readerDao;
	}
	@Resource
	public void setReaderDao(IReaderDao readerDao) {
		this.readerDao = readerDao;
	}

	public IPersonTypeDao getPersonTypeDao() {
		return personTypeDao;
	}
	
	@Resource
	public void setPersonTypeDao(IPersonTypeDao personTypeDao) {
		this.personTypeDao = personTypeDao;
	}

	@Override
	public void add(PersonType personType) {
		personTypeDao.add(personType);
	}

	@Override
	public void update(PersonType personType) {
		personTypeDao.update(personType);
	}

	@Override
	public void delete(int id) {
		long count=readerDao.getNumberByType(id);
		long count2=(long) personTypeDao.queryByHql("select count(*) from Admin admin where admin.type.id=?",id);
		if(count>0||count2>0) throw new LibException("要删除的读者类型中还有读者存在");
		personTypeDao.delete(id);
	}

	@Override
	public PersonType load(int id) {
		PersonType personType=personTypeDao.load(id);
		return personType;
	}

	@Override
	public List<PersonType> listAll() {
		List<PersonType> list=personTypeDao.list("select personType from PersonType personType");
		return list;
	}

}
