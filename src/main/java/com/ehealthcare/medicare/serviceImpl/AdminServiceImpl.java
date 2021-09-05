package com.ehealthcare.medicare.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ehealthcare.medicare.dto.request.AdminRequest;
import com.ehealthcare.medicare.dto.response.AdminLoginResponse;
import com.ehealthcare.medicare.dto.response.ResponseDTO;
import com.ehealthcare.medicare.entity.Admin;
import com.ehealthcare.medicare.repository.AdminRepository;
import com.ehealthcare.medicare.service.AdminService;
import com.ehealthcare.medicare.util.CommonUtils;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminRepository adminRepository;
	@Autowired
	private CommonUtils commonUtils;

	@Override
	public ResponseEntity<ResponseDTO> validateAdminLogin(String adminName, String password) {
		AdminLoginResponse adminLoginResponse = new AdminLoginResponse();
		try {
			Optional<Admin> adminOptional = adminRepository.findByAdminNameAndPassword(adminName,password);
			Admin admin = adminOptional.get();
			
			adminLoginResponse.setAdminId(admin.getAdminId());
			adminLoginResponse.setAdminName(admin.getAdminName());
			adminLoginResponse.setEmailId(admin.getEmailId());
			adminLoginResponse.setFirstName(admin.getFirstName());
			adminLoginResponse.setLastName(admin.getLastName());
			adminLoginResponse.setMobileNumber(admin.getMobileNumber());
			return commonUtils.generateResponse("Success",adminLoginResponse , HttpStatus.OK);
		}catch(Exception e) {
			return commonUtils.generateResponse("Invalid",adminLoginResponse , HttpStatus.OK);
		}
	}

//	@Override
//	public Admin checkAdminValid(String adminName, String password) {
//			if(adminRepository.getById(adminName).equals(adminName) && adminRepository.getById(password).equals(password))
//			{
//				return "success";
//				
//			}
//			else
//			{
//				
//			}
//	}
//
//	@Override
//	public String testAdmin(AdminRequest adminRequest) {
//			Admin admin=new Admin();
//			if(admin.getAdminName(adminName).equals(adminName) && admin.getPassword(password).equals(adminRequest.getPassword()))
//			{
//				
//				
//			}
//	}

	

}
