package com.ehealthcare.medicare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ehealthcare.medicare.entity.Company;

public interface CompanyRepository extends JpaRepository<Company,Integer> {

}
