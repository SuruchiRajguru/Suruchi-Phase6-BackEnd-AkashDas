package com.ehealthcare.medicare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ehealthcare.medicare.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction,Integer>{
	

}
