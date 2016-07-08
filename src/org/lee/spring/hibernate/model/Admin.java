package org.lee.spring.hibernate.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="t_admin")
public class Admin {
	private int id;
	private String username;
	private String password;
	private String relname;
	private String address;
	private String tel;
	/**
	 * 代表该管理员的权限
	 * 0代表拥有所有权限
	 * 1代表拥有书籍入库出库权限
	 * 2代表拥有管理借阅的权限
	 * ...
	 */
	private int status;
	private PersonType type;
	
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRelname() {
		return relname;
	}
	public void setRelname(String relname) {
		this.relname = relname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@ManyToOne
	@JoinColumn(name="person_type_id")
	public PersonType getType() {
		return type;
	}
	public void setType(PersonType type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Admin [id=" + id + ", username=" + username + ", password=" + password + ", relname=" + relname
				+ ", address=" + address + ", tel=" + tel + ", type=" + type + "]";
	}
	
	
}
