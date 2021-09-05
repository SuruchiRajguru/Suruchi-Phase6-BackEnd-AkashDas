package com.ehealthcare.medicare.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ehealthcare.medicare.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Integer>{
	
	@Query(value = "select p.product_id as productId , p.img_url as imgUrl, p.product_name as productName, b.company_name as companyName,  c.category_name as categoryName, p.short_description as shortDescription, p.long_description as longDescription, q.available_quantity as availabeQuantity ,q.price as price, b.company_id as companyId, c.category_id as categoryId, q.quantity_id as quantityId from tbl_product p, tbl_company b, tbl_category c,  tbl_quantity q where p.product_id = q.product_id and  p.category_id = c.category_id and  p.company_id = b.company_id and q.available_quantity > 0 ", nativeQuery = true)
	public List<Object[]> fetchAllProductDetails();
	
	@Query(value = "select p.product_id as productId , p.img_url as imgUrl, p.product_name as productName, b.company_name as companyName,  c.category_name as categoryName,  p.short_description as shortDescription, p.long_description as longDescription, q.available_quantity as availabeQuantity ,q.price as price, b.company_id as companyId, c.category_id as categoryId, q.quantity_id as quantityId from tbl_product p, tbl_company b, tbl_category c, tbl_quantity q where p.product_id = q.product_id and  p.category_id = c.category_id and p.company_id = b.company_id and q.available_quantity > 0 and p.product_id = :productId and q.quantity_id = :quantityId", nativeQuery = true)
	public List<Object[]> fetchProductDetailsByProductIdQuantityId(@Param("productId")Integer productId, @Param("quantityId")Integer quantityId);

	@Query(value = "select p.product_id as productId , p.img_url as imgUrl, p.product_name as productName, b.company_name as companyName,  c.category_name as categoryName, p.short_description as shortDescription, p.long_description as longDescription, q.available_quantity as availabeQuantity ,q.price as price, b.company_id as companyId, c.category_id as categoryId, q.quantity_id as quantityId from tbl_product p, tbl_company b, tbl_category c, tbl_quantity q where p.product_id = q.product_id and  p.category_id = c.category_id and p.company_id = b.company_id and q.available_quantity > 0 and  p.product_id in (\r\n"
			+ "			select pro.product_id as product_id from tbl_product pro where match(pro.product_name, pro.short_description, pro.long_description) AGAINST (:searchText IN NATURAL LANGUAGE MODE)\r\n"
			+ "			union all\r\n"
			+ "			select pro.product_id as product_id from tbl_product pro where pro.company_id in (select b.company_id as company_id from tbl_company b where match(b.company_name) AGAINST (:searchText IN NATURAL LANGUAGE MODE))\r\n"
			+ "			union all\r\n"
			+ "			select pro.product_id as product_id from tbl_product pro where pro.category_id in (select c.category_id as category_id from tbl_category c where match(c.category_name) AGAINST (:searchText IN NATURAL LANGUAGE MODE)))", nativeQuery = true)
	public List<Object[]> fetchAllProductsBySearchText(@Param("searchText")String searchText);
	
	@Query(value = "select p.product_id as productId , p.img_url as imgUrl, p.product_name as productName, b.company_name as companyName,  c.category_name as categoryName, p.short_description as shortDescription, p.long_description as longDescription, q.available_quantity as availabeQuantity ,q.price as price, b.company_id as companyId, c.category_id as categoryId, q.quantity_id as quantityId from tbl_product p, tbl_company b, tbl_category c, tbl_quantity q where p.product_id = q.product_id and  p.category_id = c.category_id and p.company_id = b.company_id and q.available_quantity > 0 and b.company_name like :companyName and c.category_name like :categoryName", nativeQuery = true)
	public List<Object[]> fetchAllProductDetailsByFilter(@Param("companyName")String companyName,@Param("categoryName")String categoryName);

	


	
}
