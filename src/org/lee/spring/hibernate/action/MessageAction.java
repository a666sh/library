package org.lee.spring.hibernate.action;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import javax.annotation.Resource;

import org.lee.spring.hibernate.model.LibAuth;
import org.lee.spring.hibernate.model.Message;
import org.lee.spring.hibernate.model.Pager;
import org.lee.spring.hibernate.service.IMessageService;
import org.lee.spring.hibernate.util.ActionUtil;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
@Controller("messageAction")
@Scope("prototype")
public class MessageAction extends ActionSupport implements ModelDriven<Message> {
	private Message msg;
	private IMessageService messageService;

	public IMessageService getMessageService() {
		return messageService;
	}

	@Resource
	public void setMessageService(IMessageService messageService) {
		this.messageService = messageService;
	}

	public Message getMsg() {
		return msg;
	}

	public void setMsg(Message msg) {
		this.msg = msg;
	}

	@Override
	public Message getModel() {
		if (msg == null)
			msg = new Message();
		return msg;
	}
	@LibAuth(ActionUtil.AUTH_READER)
	public String addInput() {
		return SUCCESS;
	}
	@LibAuth(ActionUtil.AUTH_READER)
	public String add() {
		Message m=new Message();
		m.setContent(msg.getContent());
		m.setTitle(msg.getTitle());
		m.setCommitDate(new Date());
		m.setStatus(0);
		messageService.add(m);
		ActionUtil.RedirectURL("/message_list.do");
		return ActionUtil.REDIRECT;
	}
	@LibAuth(ActionUtil.AUTH_READER)
	public String list() {
		Pager<Message> msgs=messageService.listDesc();
		ActionContext.getContext().put("msgs", msgs);
		return SUCCESS;
	}
	@LibAuth(ActionUtil.AUTH_READER)
	public String show() throws IllegalAccessException, InvocationTargetException {
		Message m=messageService.load(msg.getId());
		ActionContext.getContext().put("m", m);
		return SUCCESS;
	}
}
