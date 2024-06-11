package com.bike.on.rent.dto;

public class UserUpdateDTO {
	
	private String email;
	private String newName;
	private String newPhoneNo;
	private String newPassword;
	public UserUpdateDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserUpdateDTO(String email, String newName, String newPhoneNo, String newPassword) {
		this.email = email;
		this.newName = newName;
		this.newPhoneNo = newPhoneNo;
		this.newPassword = newPassword;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNewName() {
		return newName;
	}
	public void setNewName(String newName) {
		this.newName = newName;
	}
	public String getNewPhoneNo() {
		return newPhoneNo;
	}
	public void setNewPhoneNo(String newPhoneNo) {
		this.newPhoneNo = newPhoneNo;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	@Override
	public String toString() {
		return "UserUpdateDTO [email=" + email + ", newName=" + newName + ", newPhoneNo=" + newPhoneNo
				+ ", newPassword=" + newPassword + "]";
	}
	
	

}
