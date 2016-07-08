package org.lee.spring.hibernate.action;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.lee.spring.hibernate.model.Book;
import org.lee.spring.hibernate.model.LibAuth;
import org.lee.spring.hibernate.model.LibException;
import org.lee.spring.hibernate.model.Pager;
import org.lee.spring.hibernate.model.PersonType;
import org.lee.spring.hibernate.model.Reader;
import org.lee.spring.hibernate.model.ReaderBook;
import org.lee.spring.hibernate.service.IBookService;
import org.lee.spring.hibernate.service.IPersonTypeService;
import org.lee.spring.hibernate.service.IReaderService;
import org.lee.spring.hibernate.util.ActionUtil;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sun.org.apache.commons.beanutils.BeanUtils;

@SuppressWarnings("serial")
@Controller("readerAction")
@Scope("prototype")
public class ReaderAction extends ActionSupport implements ModelDriven<Reader>{

	private IReaderService readerService;
	private IPersonTypeService personTypeService;
	private IBookService bookService;
	private Reader reader;
	private int bid;
	private int tid;
	private int rbid;
	
	
	public int getRbid() {
		return rbid;
	}
	public void setRbid(int rbid) {
		this.rbid = rbid;
	}
	public IBookService getBookService() {
		return bookService;
	}
	@Resource
	public void setBookService(IBookService bookService) {
		this.bookService = bookService;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public IPersonTypeService getPersonTypeService() {
		return personTypeService;
	}

	@Resource
	public void setPersonTypeService(IPersonTypeService personTypeService) {
		this.personTypeService = personTypeService;
	}

	public IReaderService getReaderService() {
		return readerService;
	}
	
	@Resource
	public void setReaderService(IReaderService readerService) {
		this.readerService = readerService;
	}

	public Reader getReader() {
		return reader;
	}

	public void setReader(Reader reader) {
		this.reader = reader;
	}
	
	public String addInput() {
		List<PersonType> ps=personTypeService.listAll();
		ActionContext.getContext().put("ps", ps);
		return SUCCESS;
	}
	public String show() throws IllegalAccessException, InvocationTargetException {
		Reader r=readerService.load(reader.getId());
		BeanUtils.copyProperties(reader, r);
		return SUCCESS;
	}
	@LibAuth(ActionUtil.AUTH_READER)
	public String showSelf() throws IllegalAccessException, InvocationTargetException {
		Reader r=(Reader) ActionContext.getContext().getSession().get("loginReader");
		BeanUtils.copyProperties(reader, r);
		List<ReaderBook> rbs=readerService.getReaderBookByRidDesc(r.getId());
		ActionContext.getContext().put("rbs", rbs);
		return SUCCESS;
	}
	@LibAuth(ActionUtil.AUTH_READER)
	public String updateSelfInput() throws IllegalAccessException, InvocationTargetException {
		Reader r=(Reader) ActionContext.getContext().getSession().get("loginReader");
		BeanUtils.copyProperties(reader, r);
		List<PersonType> ps=personTypeService.listAll();
		ActionContext.getContext().put("ps", ps);
		return SUCCESS;
	}
	@LibAuth(ActionUtil.AUTH_READER)
	public String updateSelf() throws IllegalAccessException, InvocationTargetException {
		Reader r=(Reader) ActionContext.getContext().getSession().get("loginReader");
		r.setRealName(reader.getRealName());
		r.setPassword(reader.getPassword());
		r.setSex(reader.getSex());
		readerService.update(r);
		ActionContext.getContext().put("loginReader", r);
		ActionUtil.RedirectURL("/reader_showSelf.do");
		return ActionUtil.REDIRECT;
	}
	public String add() {
		Reader r=new Reader();
		r.setCreateDate(new Date());
		r.setCurNo(0);
		System.out.println(reader.getPassword());
		r.setPassword(reader.getPassword());
		r.setSex(reader.getSex());
		r.setUsername(reader.getUsername());
		r.setRealName(reader.getRealName());
		readerService.add(r, tid);
		ActionContext.getContext().put("url", "/reader_findReader.action");
		return ActionUtil.REDIRECT;
	}
	
	public void validateAdd() {
		if(reader.getUsername()==null||"".equals(reader.getUsername().trim())) {
			this.addFieldError("username", "用户名不能为空且格式应由字母或数字组成");
		}
		if(reader.getPassword()==null||"".equals(reader.getPassword().trim())) {
			this.addFieldError("password", "读者密码不能为空");
		}
		if(reader.getRealName()==null||"".equals(reader.getRealName().trim())) {
			this.addFieldError("readName", "读者姓名不能为空");
		}
		if(reader.getSex()==null||"".equals(reader.getSex().trim())) {
			this.addFieldError("sex", "必须选择一个性别");
		}
		if(tid==0) {
			this.addFieldError("tid", "必须选择一个类型");
		}
		if(this.hasFieldErrors()) {
			addInput();
		}
	}
	
	public void validateUpdate() {
		if(reader.getUsername()==null||"".equals(reader.getUsername().trim())) {
			this.addFieldError("username", "用户名不能为空且格式应由字母或数字组成");
		}
		if(reader.getPassword()==null||"".equals(reader.getPassword().trim())) {
			this.addFieldError("password", "读者密码不能为空");
		}
		if(reader.getRealName()==null||"".equals(reader.getRealName().trim())) {
			this.addFieldError("readName", "读者姓名不能为空");
		}
		if(reader.getSex()==null||"".equals(reader.getSex().trim())) {
			this.addFieldError("sex", "必须选择一个性别");
		}
		if(tid==0) {
			this.addFieldError("tid", "必须选择一个类型");
		}
		if(this.hasFieldErrors()) {
			addInput();
		}
	}
	
	public void validateUpdateSelf() throws IllegalAccessException, InvocationTargetException {
		if(reader.getPassword()==null||"".equals(reader.getPassword().trim())) {
			this.addFieldError("password", "读者密码不能为空");
		}
		if(reader.getRealName()==null||"".equals(reader.getRealName().trim())) {
			this.addFieldError("readName", "读者姓名不能为空");
		}
		if(reader.getSex()==null||"".equals(reader.getSex().trim())) {
			this.addFieldError("sex", "必须选择一个性别");
		}
		if(this.hasFieldErrors()) {
			updateSelfInput();
		}
	}
	
	public String findReader() {
		ActionContext.getContext().put("readers", readerService.find());
		return SUCCESS;
	}
	
	public String updateInput() {
		Reader r=readerService.load(reader.getId());
		reader.setUsername(r.getUsername());
		reader.setPassword(r.getPassword());
		reader.setSex(r.getSex());
		reader.setType(r.getType());
		reader.setCreateDate(r.getCreateDate());
		reader.setId(r.getId());
		reader.setCreateDate(r.getCreateDate());
		reader.setRealName(r.getRealName());
		this.addInput();
		return SUCCESS;
	}
	
	public String update() {
		Reader r=readerService.load(reader.getId());
		r.setUsername(reader.getUsername());
		r.setPassword(reader.getPassword());
		r.setSex(reader.getSex());
		r.setRealName(reader.getRealName());
		r.setType(personTypeService.load(tid));
		readerService.update(r);
		ActionContext.getContext().put("url", "/reader_findReader.do");
		return ActionUtil.REDIRECT;
	}
	
	public String delete() {
		long number=readerService.getReaderBookCount(reader.getId());
		if(number>0) throw new LibException("被删除的读者还有未完成的借阅单");
		readerService.delete(reader.getId());
		ActionContext.getContext().put("url", "/reader_findReader.action");
		return ActionUtil.REDIRECT;
	}
	public String listReaderBook() {
		Pager<ReaderBook> rbs=readerService.listReaderBook();
		ActionContext.getContext().put("pagers", rbs);
		return SUCCESS;
	}
	public String addReaderBookInput() {
		return SUCCESS;
	}
	public String addReaderBookShow() throws IllegalAccessException, InvocationTargetException {
		if(reader.getId()==0) throw new LibException("要办理借阅的用户不存在");
		if(bid==0) throw new LibException("要借阅的书籍不存在");
		Reader r=readerService.load(reader.getId());
		BeanUtils.copyProperties(reader, r);
		Book b = bookService.load(bid);
		if(b==null) throw new LibException("要借阅的书籍不存在");
		ActionContext.getContext().put("b", b);
		return SUCCESS;
	}
	public String addReaderBook() {
		readerService.addReaderBook(reader.getId(), bid);
		ActionUtil.RedirectURL("/reader_listReaderBook.do");
		return ActionUtil.REDIRECT;
	}
	public String receiveReaderBookInput() {
		return SUCCESS;
	}
	public String receiveReaderBookShow() {
		if(reader.getId()==0) throw new LibException("要办理还书的用户不存在");
		if(bid==0) throw new LibException("书籍不存在");
		Pager<ReaderBook> rbs=readerService.listReaderBookByrb(reader.getId(), bid, 0);
		ActionContext.getContext().put("pagers", rbs);
		return SUCCESS;
	}
	public String updateReaderBookById() {
		readerService.receiveReaderBook(rbid);
		ActionUtil.RedirectURL("/reader_receiveReaderBookShow.do?id="+reader.getId()+"&"+"bid="+String.valueOf(bid));
		return ActionUtil.REDIRECT;
	}
	@Override
	public Reader getModel() {
		if(reader==null) reader=new Reader();
		return reader;
	}
	
}
