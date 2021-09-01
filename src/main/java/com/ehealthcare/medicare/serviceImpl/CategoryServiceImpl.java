package com.ehealthcare.medicare.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ehealthcare.medicare.entity.Category;
import com.ehealthcare.medicare.repository.CategoryRepository;
import com.ehealthcare.medicare.service.CategoryService;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService{
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public List<Category> getAllCategory() {
		List<Category> categories=categoryRepository.findAll();
		return categories;
	}

	@Override
	public Category saveCategory(Category category) {
		try {
			return categoryRepository.save(category);
			
		}
		catch(Exception e)
		{
			return null;
		}
	}

	@Override
	public boolean deleteCategory(Integer id) {
		
		categoryRepository.deleteById(id);
		return true;
	}

	@Override
	public Category getCategory(Integer categoryId) {
		
		return categoryRepository.findById(categoryId).get();
	}
}
