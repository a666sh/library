package org.lee.spring.hibernate.action;

import javax.annotation.Resource;

import org.lee.spring.hibernate.model.Admin;
import org.lee.spring.hibernate.model.Reader;
import org.lee.spring.hibernate.service.IAdminService;
import org.lee.spring.hibernate.service.IReaderService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;



@SuppressWarnings("serial")
@Controller("loginAction")
@Scope("prototype")
public class LoginAction extends ActionSupport{
	private IAdminService adminService;
	private IReaderService readerService;
	private String username;
	private String password;
	
	public IAdminService getAdminService() {
		return adminService;
	}
	@Resource
	public void setAdminService(IAdminService adminService) {
		this.adminService = adminService;
	}
	public IReaderService getReaderService() {
		return readerService;
	}
	@Resource
	public void setReaderService(IReaderService readerService) {
		this.readerService = readerService;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	 public String loginInput() {
		 return "loginInput";
	 }
	 public String login() {
		 Admin a=adminService.login(username, password);
		 Reader r=readerService.login(username, password);
		 if(a==null&&r==null) {
			 return "bad";
		 }
		 if(a!=null) {
			 ActionContext.getContext().getSession().put("loginAdmin", a);
			 ActionContext.getContext().put("url", "/book_listBook.do");
		 }
		 if(r!=null) {
			 ActionContext.getContext().getSession().put("loginReader", r);
			 ActionContext.getContext().put("url", "/book_listBook.do");
		 }
		 return "login";
	 }
	 public String logOut() {
		 ActionContext.getContext().getSession().clear();
		 return "logOut";
	 }
}
