package com.ehealthcare.medicare.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ehealthcare.medicare.dto.request.FilterProductRequestDTO;
import com.ehealthcare.medicare.dto.request.ProductRequest;
import com.ehealthcare.medicare.dto.request.SearchProductByTextRequest;
import com.ehealthcare.medicare.dto.response.ProductDetailsResponse;
import com.ehealthcare.medicare.dto.response.ResponseDTO;
import com.ehealthcare.medicare.entity.Product;
import com.ehealthcare.medicare.repository.CategoryRepository;
import com.ehealthcare.medicare.repository.CompanyRepository;
import com.ehealthcare.medicare.repository.ProductRepository;
import com.ehealthcare.medicare.service.ProductService;
import com.ehealthcare.medicare.util.CommonUtils;
import com.ehealthcare.medicare.util.FileUploadUtil;


@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private CompanyRepository companyRepository;
	
	@Override
	public List<Product> getAllProducts() {
		 List<Product> products=productRepository.findAll();
		return products;
	}
	@Autowired
	private CommonUtils commonUtils;
	@Override
	public Product getProduct(Integer productId) {
		
		return productRepository.findById(productId).get();
	}

	@Override
	public Boolean saveProduct(ProductRequest productRequest, MultipartFile multipartFile) {
		try {
			
			String filename=StringUtils.cleanPath(multipartFile.getOriginalFilename());
			
		Product product=new Product();
		
		product.setProductName(productRequest.getProductName());
		product.setImgUrl(filename);
		product.setLongDescription(productRequest.getLongDescription());
		product.setShortDescription(productRequest.getShortDescription());
		product.setCategory(categoryRepository.getById(productRequest.getCategoryId()));
		product.setCompany(companyRepository.getById(productRequest.getCompanyId()));
		
		Product savedProduct=productRepository.save(product);
		
		String uploadDir="D:\\Suruchi Rajguru\\Simplilearn\\Projects\\Phase6\\Medicare-eHealthcare\\src\\assets\\Images\\"+savedProduct.getProductId();
		FileUploadUtil.saveFile(uploadDir, filename, multipartFile);
		
		return true;
		
		}
		catch(Exception e)
		{
			return false;
		}	
	}

	@Override
	public ResponseEntity<ResponseDTO> getAllProductDetails() {
		List<Object[]> objects=productRepository.fetchAllProductDetails();
		List<ProductDetailsResponse> productDetails = new ArrayList<>();
		for(Object object[]  : objects) {
			ProductDetailsResponse productDetail = new ProductDetailsResponse();
			productDetail.setProductId((Integer) object[0]);
			productDetail.setImgUrl((String) object[1]);
			productDetail.setProductName((String) object[2]);
			productDetail.setCompanyName((String) object[3]);
			productDetail.setCategoryName((String) object[4]);
			productDetail.setShortDescription((String) object[5]);
			productDetail.setLongDescription((String) object[6]);
			productDetail.setAvailabeQuantity((Integer) object[7]);
			productDetail.setPrice((Double) object[8]);
			productDetail.setCompanyId((Integer) object[9]);
			productDetail.setCategoryId((Integer) object[10]);
			
			productDetail.setQuantityId((Integer) object[11]);
			productDetails.add(productDetail);
			System.out.println((Integer) object[0]);
		}
		
		
		
		return commonUtils.generateResponse("Success",productDetails , HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ResponseDTO> getProductDetailById(Integer productId, Integer quantityId) {
		System.out.println("Test service");
		List<Object[]> objects = productRepository.fetchProductDetailsByProductIdQuantityId(productId, quantityId);
		Object object[] = objects.get(0);
		ProductDetailsResponse productDetail = new ProductDetailsResponse();
		productDetail.setProductId((Integer) object[0]);
		System.out.println("Test service");
		productDetail.setImgUrl((String) object[1]);
		productDetail.setProductName((String) object[2]);
		productDetail.setCompanyName((String) object[3]);
		productDetail.setCategoryName((String) object[4]);
		productDetail.setShortDescription((String) object[5]);
		productDetail.setLongDescription((String) object[6]);
		productDetail.setAvailabeQuantity((Integer) object[7]);
		productDetail.setPrice((Double) object[8]);
		productDetail.setCompanyId((Integer) object[9]);
		productDetail.setCategoryId((Integer) object[10]);
		
		productDetail.setQuantityId((Integer) object[11]);
//		System.out.println("Test after img : " + productDetailsResponseDTO.getImageUrl());
		
		return commonUtils.generateResponse("Success",productDetail , HttpStatus.OK);
	
		
	}

	@Override
	public  ResponseEntity<ResponseDTO> getProductDetailsBySearchText(SearchProductByTextRequest searchProductByTextRequestDTO) {
		
//		String modifiedSearchText = (Arrays.asList(searchProductByTextRequestDTO.getSearchText().split("\\s"))).stream().collect(Collectors.joining("|","(",")"));

List<Object[]> objects  = productRepository.fetchAllProductsBySearchText("%"+searchProductByTextRequestDTO.getSearchText()+"%");
		
		List<ProductDetailsResponse> productDetails = new ArrayList<>();
		for(Object object[]  : objects) {
			ProductDetailsResponse productDetail = new ProductDetailsResponse();
			productDetail.setProductId((Integer) object[0]);
			productDetail.setImgUrl((String) object[1]);
			productDetail.setProductName((String) object[2]);
			productDetail.setCompanyName((String) object[3]);
			productDetail.setCategoryName((String) object[4]);
			productDetail.setShortDescription((String) object[5]);
			productDetail.setLongDescription((String) object[6]);
			productDetail.setAvailabeQuantity((Integer) object[7]);
			productDetail.setPrice((Double) object[8]);
			productDetail.setCompanyId((Integer) object[9]);
			productDetail.setCategoryId((Integer) object[10]);
			productDetail.setQuantityId((Integer) object[11]);
			productDetails.add(productDetail);
			System.out.println((Integer) object[0]);
		}
		
		return commonUtils.generateResponse("Success",productDetails , HttpStatus.OK);
	}
	
	@Override
	public ResponseEntity<ResponseDTO> getAllProductDetailsByFilter(FilterProductRequestDTO filterProductRequestDTO) {
		
		
		List<Object[]> objects  = productRepository.fetchAllProductDetailsByFilter("%"+filterProductRequestDTO.getCompanyName()+"%","%"+filterProductRequestDTO.getCategoryName()+"%");
		
		List<ProductDetailsResponse> productDetails = new ArrayList<>();
		for(Object object[]  : objects) {
			ProductDetailsResponse productDetail = new ProductDetailsResponse();
			productDetail.setProductId((Integer) object[0]);
			productDetail.setImgUrl((String) object[1]);
			productDetail.setProductName((String) object[2]);
			productDetail.setCompanyName((String) object[3]);
			productDetail.setCategoryName((String) object[4]);
			
			productDetail.setShortDescription((String) object[5]);
			productDetail.setLongDescription((String) object[6]);
			productDetail.setAvailabeQuantity((Integer) object[7]);
			productDetail.setPrice((Double) object[8]);
			productDetail.setCompanyId((Integer) object[9]);
			productDetail.setCategoryId((Integer) object[10]);
			productDetail.setQuantityId((Integer) object[11]);
			productDetails.add(productDetail);
			System.out.println((Integer) object[0]);
		}
		
		return commonUtils.generateResponse("Success",productDetails , HttpStatus.OK);
	}

}
