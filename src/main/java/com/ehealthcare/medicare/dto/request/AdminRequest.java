package com.ehealthcare.medicare.dto.request;

public class AdminRequest {
	private String adminName;
	private String password;
	
	
	public AdminRequest(String adminName, String password) {
		super();
		this.adminName = adminName;
		this.password = password;
	}
	public AdminRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
