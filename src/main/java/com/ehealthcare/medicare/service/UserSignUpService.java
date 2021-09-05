package com.ehealthcare.medicare.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ehealthcare.medicare.dto.request.LoginRequest;
import com.ehealthcare.medicare.dto.response.ResponseDTO;
import com.ehealthcare.medicare.entity.SignUp;

public interface UserSignUpService {
	List<SignUp> getAllSignUp();
	
	Boolean saveSignUp(SignUp signUp);
	
	SignUp getUserSignUpById(Integer user_id);
	
	boolean deleteUser(Integer user_id);

	ResponseEntity<ResponseDTO> validateLogin(LoginRequest loginRequest);
}
