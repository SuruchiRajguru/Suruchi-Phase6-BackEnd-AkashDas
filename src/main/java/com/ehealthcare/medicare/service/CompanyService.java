package com.ehealthcare.medicare.service;

import java.util.List;

import com.ehealthcare.medicare.entity.Company;

public interface CompanyService {

	List<Company> getAllCompany();
	
	Company saveCompany(Company company);
	
	Company getCompany(Integer companyId);
	
	boolean deleteCompany(Integer id);
	
}
