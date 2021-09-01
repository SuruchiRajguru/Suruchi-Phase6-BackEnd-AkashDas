package com.ehealthcare.medicare.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ehealthcare.medicare.dto.request.ProductRequest;
import com.ehealthcare.medicare.entity.Product;
import com.ehealthcare.medicare.repository.CategoryRepository;
import com.ehealthcare.medicare.repository.CompanyRepository;
import com.ehealthcare.medicare.repository.ProductRepository;
import com.ehealthcare.medicare.service.ProductService;
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

	@Override
	public Product getProduct(Integer productId) {
		
		return productRepository.findById(productId).get();
	}

	@Override
	public Boolean saveProduct(ProductRequest productRequest, MultipartFile multipartFile,
			RedirectAttributes redirectAttributes) {
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
		
		String uploadDir="./Images/"+savedProduct.getProductId();
		FileUploadUtil.saveFile(uploadDir, filename, multipartFile);
		
		return true;
		
		}
		catch(Exception e)
		{
			return false;
		}	
	}
}
