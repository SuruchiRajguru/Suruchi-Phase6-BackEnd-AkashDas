package com.ehealthcare.medicare.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ehealthcare.medicare.entity.Company;
import com.ehealthcare.medicare.repository.CompanyRepository;
import com.ehealthcare.medicare.service.CompanyService;
@Service
public class CompanyServiceImpl implements CompanyService{
	
	@Autowired
	private CompanyRepository companyRepository;

	@Override
	public List<Company> getAllCompany() {
		List<Company> companies=companyRepository.findAll();
		return companies;
	}

	@Override
	public Company saveCompany(Company company) {
		try {
				return companyRepository.save(company);
			}
			catch(Exception e)
			{
				return null;
			}
		
	}

	@Override
	public Company getCompany(Integer companyId) {
		
		return companyRepository.findById(companyId).get();
	}

	@Override
	public boolean deleteCompany(Integer id) {
		companyRepository.deleteById(id);
		return true;
	}
	

}
