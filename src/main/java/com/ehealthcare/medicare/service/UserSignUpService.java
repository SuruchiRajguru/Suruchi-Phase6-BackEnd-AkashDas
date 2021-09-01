package com.ehealthcare.medicare.service;

import java.util.List;

import com.ehealthcare.medicare.entity.SignUp;

public interface UserSignUpService {
	List<SignUp> getAllSignUp();
	
	SignUp saveSignUp(SignUp signUp);
	
	SignUp getUserSignUpById(Integer user_id);
	
	boolean deleteUser(Integer user_id);
}
