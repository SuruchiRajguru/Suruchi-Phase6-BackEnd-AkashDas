package com.ehealthcare.medicare.service;

import java.util.List;

import com.ehealthcare.medicare.entity.Category;
import com.ehealthcare.medicare.entity.Company;

public interface CategoryService {
	List<Category> getAllCategory();
	
	Category saveCategory(Category category);
	
	boolean deleteCategory(Integer id);

	Category getCategory(Integer categoryId);
}
