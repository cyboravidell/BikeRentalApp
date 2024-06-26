package com.bike.on.rent.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity  //It treats table to the Model class in the database with the help of JPA
@Table(name = "user_table")
public class User {
	@Id  // It is used for creating primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)  // It is used for setting the auto-inc value for a column
	private Long userId;
	private String name;
	@Column(nullable = false, unique = true)
	private String email;
	private String phoneNo;
	private String password;
	private String role;
	
	public User(String name, String email, String phoneNo, String password, String role) {
		
		this.name = name;
		this.email = email;
		this.phoneNo = phoneNo;
		this.password = password;
		this.role = role;
	}

	public User() {
		super();
	
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", email=" + email + ", phoneNo=" + phoneNo + ", password="
				+ password + ", role=" + role + "]";
	}


}
