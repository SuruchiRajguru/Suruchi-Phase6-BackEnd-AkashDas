package com.ehealthcare.medicare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ehealthcare.medicare.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Integer>{
	
}
