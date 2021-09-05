package com.ehealthcare.medicare.service;

import org.springframework.http.ResponseEntity;

import com.ehealthcare.medicare.dto.request.AdminRequest;
import com.ehealthcare.medicare.dto.response.ResponseDTO;
import com.ehealthcare.medicare.entity.Admin;

public interface AdminService {
	

	ResponseEntity<ResponseDTO> validateAdminLogin(String adminName, String password);
	
//	Admin checkAdminValid(String adminName,String password);
	
//	String testAdmin(AdminRequest adminRequest);

}
