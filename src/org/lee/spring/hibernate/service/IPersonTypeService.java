package org.lee.spring.hibernate.service;

import java.util.List;

import org.lee.spring.hibernate.model.PersonType;

public interface IPersonTypeService {
	void add(PersonType personType);
	void update(PersonType personType);
	void delete(int id);
	PersonType load(int id);
	List<PersonType> listAll();
}
