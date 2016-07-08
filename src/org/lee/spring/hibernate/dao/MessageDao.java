package org.lee.spring.hibernate.dao;

import org.lee.spring.hibernate.model.Message;
import org.springframework.stereotype.Repository;

@Repository("messageDao")
public class MessageDao extends BaseDao<Message> implements IMessageDao {

}
