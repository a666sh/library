package org.lee.spring.hibernate.dao;


import org.lee.spring.hibernate.model.PersonType;
import org.springframework.stereotype.Repository;


@Repository("personTypeDao")
public class PersonTypeDao extends BaseDao<PersonType> implements IPersonTypeDao {

}
