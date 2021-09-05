package com.ehealthcare.medicare.dto.response;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailsResponse {
	
	private Integer orderId;
	private Integer userId;
	private String userConcatName;
	private Integer productId;
	private String productName;
	private String longDescription;
	private String shortDescription;
	private String imgUrl;
	private Integer categoryId;
	private Integer companyId;
	private String categoryName;
	private String companyName;
	private Integer quantityId;
	private Double price;
	private Integer transactionId;
	private String bankName;
	private Long cardNumber;
	private LocalDateTime dateOfTrans;
	private String modeOfTransaction;
	private String nameOnCard;
	private Double transactionAmount;
	

}
