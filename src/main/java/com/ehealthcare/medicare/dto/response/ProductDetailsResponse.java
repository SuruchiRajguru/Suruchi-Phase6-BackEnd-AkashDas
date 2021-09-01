package com.ehealthcare.medicare.dto.response;

public class ProductDetailsResponse {

	private Integer productId;
	private String imgUrl;
	private String productName;
	private String categoryName;
	private String companyName;
	private String longDescription;		
	private String shortDescription;
	private Integer availabeQuantity;
	private Double price;
	private Integer categoryId;
	private Integer companyId;
	private Integer quantityId;
	
	public ProductDetailsResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductDetailsResponse(Integer productId, String imgUrl, String productName, String categoryName,
			String companyName, String longDescription, String shortDescription, Integer availabeQuantity, Double price,
			Integer categoryId, Integer companyId, Integer quantityId) {
		super();
		this.productId = productId;
		this.imgUrl = imgUrl;
		this.productName = productName;
		this.categoryName = categoryName;
		this.companyName = companyName;
		this.longDescription = longDescription;
		this.shortDescription = shortDescription;
		this.availabeQuantity = availabeQuantity;
		this.price = price;
		this.categoryId = categoryId;
		this.companyId = companyId;
		this.quantityId = quantityId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
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

	public Integer getAvailabeQuantity() {
		return availabeQuantity;
	}

	public void setAvailabeQuantity(Integer availabeQuantity) {
		this.availabeQuantity = availabeQuantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
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

	public Integer getQuantityId() {
		return quantityId;
	}

	public void setQuantityId(Integer quantityId) {
		this.quantityId = quantityId;
	}

	@Override
	public String toString() {
		return "ProductDetailsResponse [productId=" + productId + ", imgUrl=" + imgUrl + ", productName=" + productName
				+ ", categoryName=" + categoryName + ", companyName=" + companyName + ", longDescription="
				+ longDescription + ", shortDescription=" + shortDescription + ", availabeQuantity=" + availabeQuantity
				+ ", price=" + price + ", categoryId=" + categoryId + ", companyId=" + companyId + ", quantityId="
				+ quantityId + "]";
	}
	
	
	
}
