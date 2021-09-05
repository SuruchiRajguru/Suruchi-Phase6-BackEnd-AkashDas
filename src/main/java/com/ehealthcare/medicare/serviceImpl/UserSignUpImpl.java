package com.ehealthcare.medicare.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ehealthcare.medicare.dto.request.LoginRequest;
import com.ehealthcare.medicare.dto.response.LoginResponse;
import com.ehealthcare.medicare.dto.response.ResponseDTO;
import com.ehealthcare.medicare.entity.SignUp;
import com.ehealthcare.medicare.repository.SignUpRepository;
import com.ehealthcare.medicare.service.UserSignUpService;
import com.ehealthcare.medicare.util.CommonUtils;

@Service

public class UserSignUpImpl implements UserSignUpService{
	
	@Autowired
	private SignUpRepository signUpRepository;
	
	@Autowired
	private CommonUtils commonUtils;

	@Override
	public List<SignUp> getAllSignUp() {
		List<SignUp> signUp=signUpRepository.findAll();
		// TODO Auto-generated method stub
		return signUp;
	}
	
	  @Override
	  public Boolean saveSignUp(SignUp signUp) 
	  { 
		  try
		  { 
			  signUpRepository.save(signUp);
			  return true;
			   
		  }
		  catch(Exception e)
		  {
			  return false; 
			  
		  } 
	  
	  }

	@Override
	public SignUp getUserSignUpById(Integer user_id) {
		// TODO Auto-generated method stub
		return signUpRepository.findById(user_id).get();
	}
	
	public boolean deleteUser(Integer id)
	{
		signUpRepository.deleteById(id);
		return true;
		
	}

	@Override
	public ResponseEntity<ResponseDTO> validateLogin(LoginRequest loginRequest) {
		SignUp user = signUpRepository.findByEmailIdAndPassword(loginRequest.getEmailId(), loginRequest.getPassword());
		LoginResponse loginResponse = new LoginResponse();
		try{
			loginResponse.setUserId(user.getUser_id());

			loginResponse.setEmailId(user.getEmailId());
			loginResponse.setMobileNo(user.getMobileNo());
			loginResponse.setUserName(user.getUserName());
			loginResponse.setFirstName(user.getFirstName());
			loginResponse.setLastName(user.getLastName());
			return commonUtils.generateResponse("Success",loginResponse , HttpStatus.OK);
		}catch(Exception e) {
			return commonUtils.generateResponse("Invalid",loginResponse , HttpStatus.OK);
		}
	}

	}
