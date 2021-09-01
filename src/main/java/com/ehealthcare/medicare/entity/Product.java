package com.ehealthcare.medicare.entity;

import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;


//@Getter
//@Setter
//@NoArgsConstructor
//@Accessors(chain=true)


@Entity
@Table(name="tbl_product")
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer productId;
	private String productName;
	private String imgUrl;
	private String longDescription;
	private String shortDescription;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="categoryId",foreignKey=@ForeignKey(name="categoryId"))
	private Category category;
	
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="companyId",foreignKey=@ForeignKey(name="companyId"))
	private Company company;
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(Integer productId, String productName, String imgUrl, String longDescription,
			String shortDescription, Category category, Company company) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.imgUrl = imgUrl;
		this.longDescription = longDescription;
		this.shortDescription = shortDescription;
		this.category = category;
		this.company = company;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", imgUrl=" + imgUrl
				+ ", longDescription=" + longDescription + ", shortDescription=" + shortDescription + ", category="
				+ category + ", company=" + company + "]";
	}

	
}
