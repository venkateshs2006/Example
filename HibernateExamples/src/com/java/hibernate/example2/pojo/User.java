package com.java.hibernate.example2.pojo;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity(name = "UserDetails")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "UID")
	private int userId;
	@Column(name = "UserName")
	private String userName;
	@Column(name = "Password")
	private String password;
	@Column(name = "Email")
	private String email;
	@Column(name = "DateOfBirth")
	@Temporal(TemporalType.DATE)
	private Date dob;
	@Embedded
	@AttributeOverrides({
			@AttributeOverride(name = "doorNo", column = @Column(name = "Home_Door_No")),
			@AttributeOverride(name = "street", column = @Column(name = "Home_Street")),
			@AttributeOverride(name = "city", column = @Column(name = "Home_City")),
			@AttributeOverride(name = "state", column = @Column(name = "Home_State")),
			@AttributeOverride(name = "country", column = @Column(name = "Home_Country")) })
	private Address homeAddress;
	@Embedded
	@AttributeOverrides({
			@AttributeOverride(name = "doorNo", column = @Column(name = "Office_Door_No")),
			@AttributeOverride(name = "street", column = @Column(name = "Office_Street")),
			@AttributeOverride(name = "city", column = @Column(name = "Office_City")),
			@AttributeOverride(name = "state", column = @Column(name = "Office_State")),
			@AttributeOverride(name = "country", column = @Column(name = "Office_Country")) })
	private Address officeAddress;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Address getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}

	public Address getOfficeAddress() {
		return officeAddress;
	}

	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName
				+ ", password=" + password + ", email=" + email + ", dob="
				+ dob + ", homeAddress=" + homeAddress + ", officeAddress="
				+ officeAddress + "]";
	}

}
