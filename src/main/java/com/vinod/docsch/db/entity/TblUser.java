package com.vinod.docsch.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;





// Generated Nov 29, 2013 12:59:05 PM by Hibernate Tools 4.0.0

/**
 * TblUser generated by hbm2java
 */

@Entity
@Table(name="tbl_user")
public class TblUser implements java.io.Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "userId")
	private Long userId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="age")
	private int age;
	
	@Column(name="sex")
	private char sex;
	
	@Column(name="mobile")
	private String mobile;
	
	@Column(name="phone")
	private String phone;
	
	@Column(name="address")
	private String address;
	
	@Column(name="isActive")
	private Short isActive;
	
	@Column(name="userName")
	private String userName;
	
	@Column(name="password")
	private String password;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinTable(name="tbl_user_role",
	joinColumns = {@JoinColumn(name="userId", referencedColumnName="userId")},
	inverseJoinColumns = {@JoinColumn(name="roleId", referencedColumnName="roleId")}
)
	private TblRole tblRole;

	public TblUser() {
	}

	public TblUser(String name, int age, char sex, String mobile, String address) {
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.mobile = mobile;
		this.address = address;
	}

	public TblUser(String name, int age, char sex, String mobile, String phone,
			String address, Short isActive, String userName, String password,
			TblRole tblRole) {
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.mobile = mobile;
		this.phone = phone;
		this.address = address;
		this.isActive = isActive;
		this.userName = userName;
		this.password = password;
		this.tblRole = tblRole;
	}

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public char getSex() {
		return this.sex;
	}

	public void setSex(char sex) {
		this.sex = sex;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Short getIsActive() {
		return this.isActive;
	}

	public void setIsActive(Short isActive) {
		this.isActive = isActive;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public TblRole getTblRole() {
		return this.tblRole;
	}

	public void setTblUserRole(TblRole tblRole) {
		this.tblRole = tblRole;
	}

}
