package org.lee.spring.hibernate.action;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.beanutils.BeanUtils;
import org.lee.spring.hibernate.model.Book;
import org.lee.spring.hibernate.model.BookType;
import org.lee.spring.hibernate.model.LibAuth;
import org.lee.spring.hibernate.model.LibException;
import org.lee.spring.hibernate.model.Pager;
import org.lee.spring.hibernate.service.IBookService;
import org.lee.spring.hibernate.util.ActionUtil;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
@Controller("bookAction")
@Scope("prototype")
public class BookAction extends ActionSupport implements ModelDriven<Book>{
	private Book book;
	private IBookService bookService;
	private int tid;
	private String type;
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}



	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public IBookService getBookService() {
		return bookService;
	}
	
	@Resource
	public void setBookService(IBookService bookService) {
		this.bookService = bookService;
	}

	@Override
	public Book getModel() {
		if(book==null) book=new Book();
		return book;
	}
	

	public String addTypeInput() {
		return SUCCESS;
	}
	
	public String addType() {
		BookType bt=new BookType();
		bt.setName(type);
		bookService.addBookType(bt);
		ActionUtil.RedirectURL("/book_listType.action");
		return ActionUtil.REDIRECT;
	}
	public String deleteType() {
		long countBook = bookService.countBookByType(tid);
		if(countBook>0) {
			throw new LibException("要删除的类型还存在图书，请先确认后再删除!");
		}
		bookService.deleteBookType(tid);
		ActionUtil.RedirectURL("/book_listType.action");
		return ActionUtil.REDIRECT;
	}
	@LibAuth(ActionUtil.AUTH_BOOK)
	public String listType() {
		List<BookType> bts=bookService.listBookType();
		ActionContext.getContext().put("bts", bts);
		return SUCCESS;
	}
	public String updateTypeInput() {
		BookType bt=bookService.loadBookType(tid);
		tid=bt.getId();
		type=bt.getName();
		return SUCCESS;
	}
	public String updateType() {
		System.out.println(tid);
		BookType bt=bookService.loadBookType(tid);
		bt.setName(type);
		bookService.updateBookType(bt);
		ActionUtil.RedirectURL("/book_listType.action");
		return ActionUtil.REDIRECT;
	}
	public void validateAddType() {
		if(ActionUtil.isEmpty(type)) this.addFieldError("type", "图书类型不能为空");
	}
	
	@LibAuth(ActionUtil.AUTH_READER)
	public String listBook() {
		Pager<Book> bs=bookService.find();
		ActionContext.getContext().put("bs", bs);
		return SUCCESS;
	}
	@LibAuth(ActionUtil.AUTH_READER)
	public String showBook() {
		Book b=bookService.load(book.getId());
		long count=bookService.getUseableCount(book.getId());
		book.setAuthor(b.getAuthor());
		book.setBookNo(b.getBookNo());
		book.setBooktype(b.getBooktype());
		book.setId(b.getId());
		book.setIsbn(b.getIsbn());
		book.setName(b.getName());
		book.setPrice(b.getPrice());
		book.setPublisher(b.getPublisher());
		book.setStatus(b.getStatus());
		ActionContext.getContext().put("count", count);
		return SUCCESS;
	}
	@LibAuth(ActionUtil.AUTH_BOOK)
	public String addBookInput() {
		List<BookType> bts=bookService.listBookType();
		ActionContext.getContext().put("bts",bts);
		return SUCCESS;
	}
	@LibAuth(ActionUtil.AUTH_BOOK)
	public String validateAddBook() {
		if(book.getAuthor()==null||"".equals(book.getAuthor().trim())) 
			this.addFieldError("author", "图书作者名不能为空");
		if(book.getName()==null||"".equals(book.getName().trim())) 
			this.addFieldError("name", "图书名不能为空");
		if(book.getPublisher()==null||"".equals(book.getPublisher().trim())) 
			this.addFieldError("publisher", "图书出版社不能为空");
		if(book.getIsbn()==null||"".equals(book.getIsbn().trim())) 
			this.addFieldError("isbn", "ISBN不能为空");
		if(book.getBookNo()==0) 
			this.addFieldError("bookNo", "图书数量必须为整数");
		if(book.getPrice()==0)
			this.addFieldError("price", "图书价格必须为数字格式");
		if(tid==0)
			this.addFieldError("tid", "请选择相应的图书类型");
		if(this.hasFieldErrors())
			addBookInput();
		return SUCCESS;
	}
	@LibAuth(ActionUtil.AUTH_BOOK)
	public String addBook() throws IllegalAccessException, InvocationTargetException {
		Book b=new Book();
		BeanUtils.copyProperties(b, book);
		bookService.add(b,tid);
		ActionUtil.RedirectURL("/book_listBook.do");
		return ActionUtil.REDIRECT;
	}
	@LibAuth(ActionUtil.AUTH_BOOK)
	public String deleteBook() {
		bookService.delete(book.getId());
		ActionUtil.RedirectURL("/book_listBook.do");
		return ActionUtil.REDIRECT;
	}
	@LibAuth(ActionUtil.AUTH_BOOK)
	public String updateBookInput() throws IllegalAccessException, InvocationTargetException {
		Book b=bookService.load(book.getId());
		BeanUtils.copyProperties(book, b);
		tid=b.getBooktype().getId();
		List<BookType> bts=bookService.listBookType();
		ActionContext.getContext().put("bts",bts);
		ActionUtil.RedirectURL("/book_listBook.do");
		return SUCCESS;
	}
	@LibAuth(ActionUtil.AUTH_BOOK)
	public String updateBook() throws IllegalAccessException, InvocationTargetException {
		Book b=bookService.load(book.getId());
		b.setAuthor(book.getAuthor());
		b.setBookNo(book.getBookNo());
		b.setIsbn(book.getIsbn());
		b.setName(book.getName());
		b.setPrice(book.getPrice());
		b.setPublisher(book.getPublisher());
		b.setStatus(book.getStatus());
		b.setBooktype(bookService.loadBookType(tid));
		bookService.update(b);
		ActionUtil.RedirectURL("/book_listBook.do");
		return ActionUtil.REDIRECT;
	}
	@LibAuth(ActionUtil.AUTH_BOOK)
	public String validateUpdateBook() throws IllegalAccessException, InvocationTargetException {
		if(book.getAuthor()==null||"".equals(book.getAuthor().trim())) 
			this.addFieldError("author", "图书作者名不能为空");
		if(book.getName()==null||"".equals(book.getName().trim())) 
			this.addFieldError("name", "图书名不能为空");
		if(book.getPublisher()==null||"".equals(book.getPublisher().trim())) 
			this.addFieldError("publisher", "图书出版社不能为空");
		if(book.getIsbn()==null||"".equals(book.getIsbn().trim())) 
			this.addFieldError("isbn", "ISBN不能为空");
		if(book.getBookNo()==0) 
			this.addFieldError("bookNo", "图书数量必须为整数");
		if(book.getPrice()==0)
			this.addFieldError("price", "图书价格必须为数字格式");
		if(tid==0)
			this.addFieldError("tid", "请选择相应的图书类型");
		if(this.hasFieldErrors())
			updateBookInput();
		return SUCCESS;
	}
}
