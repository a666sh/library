package org.lee.spring.hibernate.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="t_reader_book")
public class ReaderBook {
	private int id;
	private Reader reader;
	private Book book;
	/**
	 * 借书日期
	 */
	private Date startDate;
	/**
	 * 应还书日期
	 */
	private Date endDate;
	/**
	 * 实际还书日期
	 */
	private Date reaDate;
	/**
	 * 该借阅单状态
	 * 0表示还在正在借书时期
	 * 1表示已经正常归还书籍
	 * 2表示需赔偿损失并且尚未赔偿
	 * 3表示书籍归还已经赔偿
	 * 4表示书籍损坏或无法使用且已经赔偿
	 */
	private int status;
	/**
	 * 赔偿信息
	 * 	0表示不用赔偿
	 * 	1表示书籍超时赔偿
	 * 	2表示书籍损坏，需按书籍价格一定比例赔偿
	 */
	private int fineType;
	private double payMoney;
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@ManyToOne
	@JoinColumn(name="reader_id")
	public Reader getReader() {
		return reader;
	}
	public void setReader(Reader reader) {
		this.reader = reader;
	}
	@ManyToOne
	@JoinColumn(name="book_id")
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	@Column(name="start_date")
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	@Column(name="end_date")
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	@Column(name="real_date")
	public Date getReaDate() {
		return reaDate;
	}
	public void setReaDate(Date reaDate) {
		this.reaDate = reaDate;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Column(name="fine_type")
	public int getFineType() {
		return fineType;
	}
	public void setFineType(int fineType) {
		this.fineType = fineType;
	}
	@Column(name="pay_money")
	public double getPayMoney() {
		return payMoney;
	}
	public void setPayMoney(double payMoney) {
		this.payMoney = payMoney;
	}

	
}
