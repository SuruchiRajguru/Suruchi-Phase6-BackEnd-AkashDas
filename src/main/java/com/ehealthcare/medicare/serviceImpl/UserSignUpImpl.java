package com.ehealthcare.medicare.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ehealthcare.medicare.entity.SignUp;
import com.ehealthcare.medicare.repository.SignUpRepository;
import com.ehealthcare.medicare.service.UserSignUpService;

@Service

public class UserSignUpImpl implements UserSignUpService{
	
	@Autowired
	private SignUpRepository signUpRepository;

	@Override
	public List<SignUp> getAllSignUp() {
		List<SignUp> signUp=signUpRepository.findAll();
		// TODO Auto-generated method stub
		return signUp;
	}
	
	  @Override
	  public SignUp saveSignUp(SignUp signUp) 
	  { 
		  try
		  { 
			return  signUpRepository.save(signUp);
			  //return true;
			   
		  }
		  catch(Exception e)
		  {
			  return null; 
			  
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
	
	}
