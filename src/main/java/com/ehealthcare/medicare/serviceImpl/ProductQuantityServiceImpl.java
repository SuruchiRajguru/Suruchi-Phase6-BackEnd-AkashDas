package com.ehealthcare.medicare.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ehealthcare.medicare.dto.request.ProductQuantityRequest;
import com.ehealthcare.medicare.entity.ProductQuantity;
import com.ehealthcare.medicare.repository.ProductQuantityRepository;
import com.ehealthcare.medicare.repository.ProductRepository;
import com.ehealthcare.medicare.service.ProductQuantityService;

@Service
public class ProductQuantityServiceImpl implements ProductQuantityService{

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ProductQuantityRepository productQuantityRepository;
	
	@Override
	public List<ProductQuantity> getAllProductsQuantity() {
		List<ProductQuantity> productQuantities=productQuantityRepository.findAll();
		return productQuantities;
	}
	
	@Override
	public Boolean saveProductQuantity(ProductQuantityRequest productQuantityRequest) {
		try
		{
			System.out.println(productQuantityRequest.toString());
			ProductQuantity productQuantity=new ProductQuantity();
			productQuantity.setProduct(productRepository.getById(productQuantityRequest.getProductId()));
			productQuantity.setQuantity(productQuantityRequest.getQuantity());
			productQuantity.setPrice(productQuantityRequest.getPrice());
			productQuantity.setAvailableQuantity(productQuantityRequest.getQuantity());
			productQuantity.setEntryDate(new SimpleDateFormat("yyyy-MM-dd").parse(productQuantityRequest.getEntryDate()));
			
			productQuantityRepository.save(productQuantity);
			return true;
		}
		
		catch(Exception e)
		{
			return false;
		}
	}

	
}
