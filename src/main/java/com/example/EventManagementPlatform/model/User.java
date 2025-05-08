package com.example.EventManagementPlatform.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User implements UserDetails {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name ="UserId")
	private long userId;
	
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
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
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
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public User(long userId, String name, String userName, String email, String pass, String role, String status) {
		super();
		this.userId = userId;
		this.name = name;
		this.userName = userName;
		this.email = email;
		this.pass = pass;
		this.role = role;
		this.status = status;
	}
	public User() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "User [id=" + userId + ", name=" + name + ", userName=" + userName + ", pass=" + pass + ", email=" + email
				+ ", role=" + role + "]";
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> listRole = new ArrayList<GrantedAuthority>();
		listRole.add(new SimpleGrantedAuthority(this.role));
		return listRole;
	}

	@Override
	public String getPassword() {
		return pass;
	}

	@Override
	public String getUsername() {
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		if (pass.isEmpty() || userName.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean isEnabled() {
		if (pass.isEmpty() || userName.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}
}