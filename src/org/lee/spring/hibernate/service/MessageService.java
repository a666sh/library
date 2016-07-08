package org.lee.spring.hibernate.service;

import java.util.List;

import javax.annotation.Resource;

import org.lee.spring.hibernate.dao.IMessageDao;
import org.lee.spring.hibernate.dao.MessageDao;
import org.lee.spring.hibernate.model.Message;
import org.lee.spring.hibernate.model.Pager;
import org.springframework.stereotype.Service;

@Service("messageService")
public class MessageService implements IMessageService{
	
	private IMessageDao messageDao;

	public IMessageDao getMessageDao() {
		return messageDao;
	}
	@Resource
	public void setMessageDao(MessageDao messageDao) {
		this.messageDao = messageDao;
	}
	@Override
	public void add(Message msg) {
		messageDao.add(msg);
	}
	@Override
	public void delete(int id) {
		messageDao.delete(id);
	}
	@Override
	public Message load(int id) {
		return messageDao.load(id);
	}
	@Override
	public Pager<Message> find() {
		return messageDao.find("select msg from Message msg");
	}
	@Override
	public List<Message> list() {
		return messageDao.list("select msg from Message msg");
	}
	@Override
	public Pager<Message> listDesc() {
		return messageDao.find("select msg from Message msg order by msg.commitDate desc");
	}
	
}
