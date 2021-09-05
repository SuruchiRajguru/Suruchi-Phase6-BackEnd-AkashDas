package com.ehealthcare.medicare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ehealthcare.medicare.entity.ProductQuantity;

public interface ProductQuantityRepository extends JpaRepository<ProductQuantity,Integer>{

	@Query(value="select q.price from tbl_quantity q where q.quantity_id = :quantityId",nativeQuery=true)
	public Double fetchPriceById(@Param("quantityId") Integer quantityId);
	
	
/*	@Query(value = "select q.price from tbl_product_quantity q where q.quantity_id = :quantityId", nativeQuery = true)
	public Double fetchPriceById(@Param("quantityId") Integer quantityId) ;
*/

	
}
