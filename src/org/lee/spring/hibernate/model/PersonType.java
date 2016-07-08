package org.lee.spring.hibernate.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_person_type")
public class PersonType {
	@Override
	public String toString() {
		return "PersonType [id=" + id + ", name=" + name + ", date=" + date + ", maxNo=" + maxNo + "]";
	}
	private int id;
	private String name;
	/**
	 * 该类型人员可借书的时间长短
	 */
	private int date;
	/**
	 * 该类型人员可以借阅多少本书
	 */
	private int maxNo;
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMaxNo() {
		return maxNo;
	}
	public void setMaxNo(int maxNo) {
		this.maxNo = maxNo;
	}
	public int getDate() {
		return date;
	}
	public void setDate(int date) {
		this.date = date;
	}

}
