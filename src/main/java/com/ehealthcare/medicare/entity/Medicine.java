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

@Entity
@Table(name="tbl_medicine")
public class Medicine {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer medicineId;
	private String medicineName;
	private String imgUrl;
	private String longDescription;
	private String shortDescription;
	//@ManyToOne(cascade=CascadeType.ALL)
	//@JoinColumn(name="brandId", foreignKey=@ForeignKey(name="brandId"))
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="companyId",foreignKey=@ForeignKey(name="companyId"))
	private Company company;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="categoryId",foreignKey=@ForeignKey(name="categoryId"))
	private Category category;
	
	
	public Medicine() {
		super();
		
	}
	
	
	
	public Medicine(Integer medicineId, String medicineName, String imgUrl, String longDescription,
			String shortDescription, Company company, Category category) {
		super();
		this.medicineId = medicineId;
		this.medicineName = medicineName;
		this.imgUrl = imgUrl;
		this.longDescription = longDescription;
		this.shortDescription = shortDescription;
		this.company = company;
		this.category = category;
	}



	public Integer getMedicineId() {
		return medicineId;
	}
	public void setMedicineId(Integer medicineId) {
		this.medicineId = medicineId;
	}
	public String getMedicineName() {
		return medicineName;
	}
	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
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



	public Company getCompany() {
		return company;
	}



	public void setCompany(Company company) {
		this.company = company;
	}



	public Category getCategory() {
		return category;
	}



	public void setCategory(Category category) {
		this.category = category;
	}



	@Override
	public String toString() {
		return "Medicine [medicineId=" + medicineId + ", medicineName=" + medicineName + ", imgUrl=" + imgUrl
				+ ", longDescription=" + longDescription + ", shortDescription=" + shortDescription + ", company="
				+ company + ", category=" + category + "]";
	}
	
	
	
	
	
	
}
