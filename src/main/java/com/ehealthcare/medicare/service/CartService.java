package com.ehealthcare.medicare.service;

import org.springframework.http.ResponseEntity;

import com.ehealthcare.medicare.dto.request.CartRequest;
import com.ehealthcare.medicare.dto.response.ResponseDTO;

public interface CartService {
	
	boolean saveCartItemByUserId(CartRequest cartRequest);

	ResponseEntity<ResponseDTO> getAllCarItemtByUserId(Integer userId);

	ResponseEntity<ResponseDTO> getAllCarItem();

	boolean removeCartItem(Integer id);

	boolean updateCartStatus(Integer id);

	ResponseEntity<ResponseDTO> getAllCheckOutItemByUserId(Integer userId);

}
