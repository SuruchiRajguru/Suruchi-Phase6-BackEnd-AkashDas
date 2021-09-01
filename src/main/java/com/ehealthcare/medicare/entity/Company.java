package com.ehealthcare.medicare.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_company")
public class Company {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer companyId;
	private String companyName;
	
	public Company() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Company(Integer companyId, String companyName) {
		super();
		this.companyId = companyId;
		this.companyName = companyName;
	}
	
	
	public Integer getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	@Override
	public String toString() {
		return "Company [companyId=" + companyId + ", companyName=" + companyName + "]";
	}
	
	
	
	
}
