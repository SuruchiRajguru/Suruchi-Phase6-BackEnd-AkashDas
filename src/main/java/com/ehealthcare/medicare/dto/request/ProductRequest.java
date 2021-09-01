package com.ehealthcare.medicare.dto.request;

public class ProductRequest {

	private String productName;
	private String longDescription;
	private String shortDescription;
	private Integer categoryId;
	private Integer companyId;
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getLongDescription() {
		return longDescription;
	}
	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}
	public String getShortDescription() {
		return shortDescription;
	}
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public Integer getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}
	@Override
	public String toString() {
		return "ProductRequest [productName=" + productName + ", longDescription="
				+ longDescription + ", shortDescription=" + shortDescription + ", categoryId=" + categoryId
				+ ", companyId=" + companyId + "]";
	}
	
	
}
