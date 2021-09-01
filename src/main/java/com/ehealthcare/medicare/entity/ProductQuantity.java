package com.ehealthcare.medicare.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tbl_quantity")
public class ProductQuantity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer quantityId;
	private Integer availableQuantity;
	private Integer quantity;
	private Double price;
	private Date entryDate;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="productId",foreignKey=@ForeignKey(name="productId"))
	private Product product;

	
	public ProductQuantity() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public ProductQuantity(Integer quantityId, Integer availableQuantity, Integer quantity, Double price,
			Date entryDate, Product product) {
		super();
		this.quantityId = quantityId;
		this.availableQuantity = availableQuantity;
		this.quantity = quantity;
		this.price = price;
		this.entryDate = entryDate;
		this.product = product;
	}


	public Integer getQuantityId() {
		return quantityId;
	}

	public void setQuantityId(Integer quantityId) {
		this.quantityId = quantityId;
	}

	public Integer getAvailableQuantity() {
		return availableQuantity;
	}

	public void setAvailableQuantity(Integer availableQuantity) {
		this.availableQuantity = availableQuantity;
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

	public Date getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "ProductQuantity [quantityId=" + quantityId + ", availableQuantity=" + availableQuantity + ", quantity="
				+ quantity + ", price=" + price + ", entryDate=" + entryDate + ", product=" + product + "]";
	}
	
	
	
	
	
}
