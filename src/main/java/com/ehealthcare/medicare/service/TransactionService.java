package com.ehealthcare.medicare.service;

import org.springframework.http.ResponseEntity;

import com.ehealthcare.medicare.dto.request.TransactionDetailsRequest;
import com.ehealthcare.medicare.dto.response.ResponseDTO;

public interface TransactionService {
	
	Boolean saveTransaction(TransactionDetailsRequest transactionDetailsRequest);

	ResponseEntity<ResponseDTO> getAllOrderByUserId(Integer userId);

	ResponseEntity<ResponseDTO> getAllOrderDetails();

}
