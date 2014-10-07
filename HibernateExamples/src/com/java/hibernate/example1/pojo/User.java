package com.java.hibernate.example1.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity(name = "UserDetails")
public class User {
	@Id
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

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName
				+ ", password=" + password + ", email=" + email + ", dob="
				+ dob + "]";
	}

}
