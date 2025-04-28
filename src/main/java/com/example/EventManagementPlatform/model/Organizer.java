package com.example.EventManagementPlatform.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Organizer {
	
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name ="OrgId")
	private long orgId;
	
	private String orgName;
	private String orgEmail;
	private String orgPass;
	private String eventName;
	private String role;
	
	public long getOrgId() {
		return orgId;
	}
	public void setOrgId(long orgId) {
		this.orgId = orgId;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getOrgEmail() {
		return orgEmail;
	}
	public void setOrgEmail(String orgEmail) {
		this.orgEmail = orgEmail;
	}
	public String getOrgPass() {
		return orgPass;
	}
	public void setOrgPass(String orgPass) {
		this.orgPass = orgPass;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	@Override
	public String toString() {
		return "Organizer [orgId=" + orgId + ", orgName=" + orgName + ", orgEmail=" + orgEmail + ", orgPass=" + orgPass
				+ ", eventName=" + eventName + ", role=" + role + "]";
	}
	
	public Organizer(long orgId, String orgName, String orgEmail, String orgPass, String eventName, String role) {
		super();
		this.orgId = orgId;
		this.orgName = orgName;
		this.orgEmail = orgEmail;
		this.orgPass = orgPass;
		this.eventName = eventName;
		this.role = role;
	}
	
	public Organizer() {
		super();
		// TODO Auto-generated constructor stub
	}
}