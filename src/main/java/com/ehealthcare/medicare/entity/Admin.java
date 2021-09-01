package com.ehealthcare.medicare.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_admin")
public class Admin {
	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String adminName;
	private String password;
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Admin(String adminName, String password) {
		super();
		this.adminName = adminName;
		this.password = password;
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
	@Override
	public String toString() {
		return "Admin [adminName=" + adminName + ", password=" + password + "]";
	}
	
	
	
}
