package com.ehealthcare.medicare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ehealthcare.medicare.entity.SignUp;

public interface SignUpRepository extends JpaRepository<SignUp,Integer>{

	SignUp findByEmailIdAndPassword(String emailId, String password);

}
