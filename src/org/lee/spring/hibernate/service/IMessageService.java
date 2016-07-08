package org.lee.spring.hibernate.service;

import java.util.List;

import org.lee.spring.hibernate.model.Message;
import org.lee.spring.hibernate.model.Pager;

public interface IMessageService {
	void add(Message msg);
	void delete(int id);
	Message load(int id);
	Pager<Message> find();
	List<Message> list();
	Pager<Message> listDesc();
}
