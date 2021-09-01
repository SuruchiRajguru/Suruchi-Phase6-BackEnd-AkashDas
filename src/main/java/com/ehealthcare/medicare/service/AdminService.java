package com.ehealthcare.medicare.service;

import com.ehealthcare.medicare.dto.request.AdminRequest;
import com.ehealthcare.medicare.entity.Admin;

public interface AdminService {
	Boolean saveAdmin(String adminName,String password);
	
//	Admin checkAdminValid(String adminName,String password);
	
//	String testAdmin(AdminRequest adminRequest);

}
