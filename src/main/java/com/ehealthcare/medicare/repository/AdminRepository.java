package com.ehealthcare.medicare.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ehealthcare.medicare.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin,Integer>{

	Optional<Admin> findByAdminNameAndPassword(String adminName, String password);

}
