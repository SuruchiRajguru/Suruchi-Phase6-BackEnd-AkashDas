package com.ehealthcare.medicare.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ehealthcare.medicare.dto.request.ProductRequest;
import com.ehealthcare.medicare.entity.Product;

public interface ProductService {
	
	List<Product> getAllProducts();
	
	Product getProduct(Integer productId);

	Boolean saveProduct(ProductRequest productRequest,MultipartFile multipartFile,RedirectAttributes redirectAttributes);
	
	
}
