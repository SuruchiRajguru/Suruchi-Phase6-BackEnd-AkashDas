package com.ehealthcare.medicare.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ehealthcare.medicare.dto.request.ProductQuantityRequest;
import com.ehealthcare.medicare.entity.ProductQuantity;

public interface ProductQuantityService {
	Boolean saveProductQuantity(ProductQuantityRequest productQuantityRequest);
	
	List<ProductQuantity> getAllProductsQuantity();
	
	
/*	@Query(value = "select q.price from tbl_product_quantity q where q.quantity_id = :quantityId", nativeQuery = true)
	public Double fetchPriceById(@Param("quantityId") Integer quantityId) ;
*/
	

}
