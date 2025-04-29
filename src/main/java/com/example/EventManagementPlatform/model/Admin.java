package com.example.EventManagementPlatform.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Admin {
	
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name ="adminId")
	private long adminId;
	
	private String name;
	private String userName;
	private String email;
	private String pass;
	private String role;
	private String status;
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public long getAdminId() {
		return adminId;
	}
	public void setAdminId(long adminId) {
		this.adminId = adminId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
	public Admin(long adminId, String name, String userName, String email, String pass, String role, String status) {
		super();
		this.adminId = adminId;
		this.name = name;
		this.userName = userName;
		this.email = email;
		this.pass = pass;
		this.role = role;
		this.status = status;
	}
	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", name=" + name + ", userName=" + userName + ", email=" + email
				+ ", pass=" + pass + ", role=" + role + ", status=" + status + "]";
	}
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}	
}