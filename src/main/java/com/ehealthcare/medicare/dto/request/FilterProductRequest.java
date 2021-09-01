package com.ehealthcare.medicare.dto.request;

public class FilterProductRequest {
	
	private String categoryName;
	private String companyName;
	
	public FilterProductRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FilterProductRequest(String categoryName, String companyName) {
		super();
		this.categoryName = categoryName;
		this.companyName = companyName;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	@Override
	public String toString() {
		return "FilterProductRequest [categoryName=" + categoryName + ", companyName=" + companyName + "]";
	}

	
	

}
