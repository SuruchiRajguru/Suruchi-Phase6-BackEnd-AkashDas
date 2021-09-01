package com.ehealthcare.medicare.dto.response;

public class ProductResponse {
	
	private String productId;
	private String productName;
	private String imgUrl;
	private String longDescription;
	private String shortDescription;
	private String categoryName;
	private String companyName;
	
	public ProductResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductResponse(String productId, String productName, String imgUrl, String longDescription,
			String shortDescription, String categoryName, String companyName) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.imgUrl = imgUrl;
		this.longDescription = longDescription;
		this.shortDescription = shortDescription;
		this.categoryName = categoryName;
		this.companyName = companyName;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
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
		return "ProductResponse [productId=" + productId + ", productName=" + productName + ", imgUrl=" + imgUrl
				+ ", longDescription=" + longDescription + ", shortDescription=" + shortDescription + ", categoryName="
				+ categoryName + ", companyName=" + companyName + "]";
	}
	
	

}
