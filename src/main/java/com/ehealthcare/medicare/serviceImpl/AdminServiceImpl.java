package com.ehealthcare.medicare.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ehealthcare.medicare.dto.request.AdminRequest;
import com.ehealthcare.medicare.entity.Admin;
import com.ehealthcare.medicare.repository.AdminRepository;
import com.ehealthcare.medicare.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminRepository adminRepository;

	@Override
	public Boolean saveAdmin(String adminName, String password) {
		
		if(adminName.equals("admin") && password.equals("pass123"))
		{
			return true;
		}
		return false;
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
