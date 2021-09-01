package com.ehealthcare.medicare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ehealthcare.medicare.entity.Category;

public interface CategoryRepository extends JpaRepository<Category,Integer>{

}
