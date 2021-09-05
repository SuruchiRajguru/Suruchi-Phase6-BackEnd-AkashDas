package com.ehealthcare.medicare.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ehealthcare.medicare.dto.request.FilterProductRequest;
import com.ehealthcare.medicare.dto.request.FilterProductRequestDTO;
import com.ehealthcare.medicare.dto.request.ProductRequest;
import com.ehealthcare.medicare.dto.request.SearchProductByTextRequest;
import com.ehealthcare.medicare.dto.response.ProductDetailsResponse;
import com.ehealthcare.medicare.dto.response.ResponseDTO;
import com.ehealthcare.medicare.dto.response.TransactionDetailsResponse;
import com.ehealthcare.medicare.entity.Product;

public interface ProductService {
	
	List<Product> getAllProducts();
	
	Product getProduct(Integer productId);

	Boolean saveProduct(ProductRequest productRequest,MultipartFile multipartFile);
	
	ResponseEntity<ResponseDTO> getAllProductDetails();
	

	 ResponseEntity<ResponseDTO> getProductDetailsBySearchText(SearchProductByTextRequest searchProductByTextRequest);

	ResponseEntity<ResponseDTO> getProductDetailById(Integer productId,Integer quantityId);

	ResponseEntity<ResponseDTO> getAllProductDetailsByFilter(FilterProductRequestDTO filterProductRequestDTO);
	
}
