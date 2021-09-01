package com.ehealthcare.medicare.dto.response;

import java.util.List;

import com.ehealthcare.medicare.entity.SignUp;

public class TransactionDetailsResponse {
	
	private List<ProductDetailsResponse> productDetailsResponse;
	private SignUp signUp;
	public List<ProductDetailsResponse> getProductDetailsResponse() {
		return productDetailsResponse;
	}
	public void setProductDetailsResponse(List<ProductDetailsResponse> productDetailsResponse) {
		this.productDetailsResponse = productDetailsResponse;
	}
	public SignUp getSignUp() {
		return signUp;
	}
	public void setSignUp(SignUp signUp) {
		this.signUp = signUp;
	}
	
	
	

}
