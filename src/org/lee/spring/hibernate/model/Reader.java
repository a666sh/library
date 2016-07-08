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
@Table(name="t_reader")
public class Reader {
	private int id;
	private String username;
	private String realName;
	private String sex;
	private String password;
	private Date createDate;
	private PersonType type;
	/**
	 * 当前借了多少本书
	 */
	private int curNo;
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Column(name="create_date")
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	@ManyToOne
	@JoinColumn(name="person_type_id")
	public PersonType getType() {
		return type;
	}
	public void setType(PersonType type) {
		this.type = type;
	}
	public int getCurNo() {
		return curNo;
	}
	public void setCurNo(int curNo) {
		this.curNo = curNo;
	}
	@Column(name="real_name")
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	
	
}
