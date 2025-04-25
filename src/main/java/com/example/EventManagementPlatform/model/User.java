package com.example.EventManagementPlatform.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class User {
	
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name ="Id")
	private long Id;
	
	private String name;
	private String email;
	private String pass;
	private String role;
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public long getId() {
		return Id;
	}
	public void setId(long id) {
		Id = id;
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
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public User(long id, String name, String email, String pass, String role) {
		super();
		Id = id;
		this.name = name;
		this.email = email;
		this.pass = pass;
		this.role = role;
	}
	@Override
	public String toString() {
		return "User [Id=" + Id + ", name=" + name + ", email=" + email + ", pass=" + pass + ", role=" + role + "]";
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
}