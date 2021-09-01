package com.ehealthcare.medicare.dto.request;

import java.util.Date;

public class ProductQuantityRequest {
	
	private Integer productId;
	private Integer quantity;
	private Double price;
	private String entryDate;
	public ProductQuantityRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public ProductQuantityRequest(Integer productId, Integer quantity, Double price, String entryDate) {
		super();
		this.productId = productId;
		this.quantity = quantity;
		this.price = price;
		this.entryDate = entryDate;
	}


	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getEntryDate() {
		return entryDate;
	}
	public void setEntryDate(String entryDate) {
		this.entryDate = entryDate;
	}
	@Override
	public String toString() {
		return "ProductQuantityRequest [productId=" + productId + ", quantity=" + quantity + ", price=" + price
				+ ", entryDate=" + entryDate + "]";
	}
	
	
	
}
