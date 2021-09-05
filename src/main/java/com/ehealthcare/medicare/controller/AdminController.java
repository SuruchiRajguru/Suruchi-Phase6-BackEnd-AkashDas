package com.ehealthcare.medicare.controller;

import java.text.ParseException;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ehealthcare.medicare.dto.request.AdminRequest;
import com.ehealthcare.medicare.dto.request.ProductQuantityRequest;
import com.ehealthcare.medicare.dto.request.ProductRequest;
import com.ehealthcare.medicare.dto.response.ResponseDTO;
import com.ehealthcare.medicare.entity.Category;
import com.ehealthcare.medicare.entity.Company;
import com.ehealthcare.medicare.entity.Product;
import com.ehealthcare.medicare.entity.ProductQuantity;
import com.ehealthcare.medicare.service.AdminService;
import com.ehealthcare.medicare.service.CartService;
import com.ehealthcare.medicare.service.CategoryService;
import com.ehealthcare.medicare.service.CompanyService;
import com.ehealthcare.medicare.service.ProductQuantityService;
import com.ehealthcare.medicare.service.ProductService;
import com.ehealthcare.medicare.service.TransactionService;
import com.google.gson.Gson;


@RestController
@RequestMapping("/medicare-admin")
@CrossOrigin(origins="*")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private CompanyService companyService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductQuantityService productQuantityService;
	
	@Autowired
	private TransactionService transactionService;
	
	@Autowired
	private CartService cartService;
	
	@PostMapping("/saveadmin")
	public Boolean saveAdmin(@RequestBody AdminRequest adminRequest) {
		if(adminService.saveAdmin(adminRequest.getAdminName(), adminRequest.getPassword()))
		{
			return true;
		}
		else
		{
			return false;
		}
		
		
	}
	
	@GetMapping("/listcategory")
	public List<Category> list()
	{
		return categoryService.getAllCategory();
	}
	
	@GetMapping("/getCategoryById/{id}")
	public ResponseEntity<Category> getCategoryId(@PathVariable Integer id)
	{
		try {
				Category category=categoryService.getCategory(id);
				return new ResponseEntity<Category>(category,HttpStatus.OK);	
		}
		catch(NoSuchElementException e)
		{
			return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
		}		
	}

	@PutMapping("updateCategoryById/{id}")
	public ResponseEntity<Category> updateCategoryById(@RequestBody Category category,@PathVariable Integer id)
	{
		try {
			Category existCategory=categoryService.getCategory(id);
			category.setCategoryId(id);
			categoryService.saveCategory(category);
			return new ResponseEntity<Category>(HttpStatus.OK);
		}
		catch(NoSuchElementException e)
		{
			return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	@PostMapping("/savecategory")
	public void saveCategory(@RequestBody Category category)
	{
		categoryService.saveCategory(category);
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Integer id)
	{
		categoryService.deleteCategory(id);
		//System.out.println("deleted");
	}
	
	@GetMapping("/listcompany")
	public List<Company> listCompany()
	{
		return companyService.getAllCompany();
	}
	
	@PostMapping("/savecompany")
	public void saveCompany(@RequestBody Company company)
	{
		companyService.saveCompany(company);
	}	
	
	@GetMapping("/getCompanyById/{id}")
	public ResponseEntity<Company> getCompanyId(@PathVariable Integer id)
	{
		try {
			Company company=companyService.getCompany(id);
			return new ResponseEntity<Company>(company,HttpStatus.OK);	
		}
		catch(NoSuchElementException e)
		{
			return new ResponseEntity<Company>(HttpStatus.NOT_FOUND);
		}		
	}
	
	@DeleteMapping("/deletecompany/{id}")
	public void deleteCompany(@PathVariable Integer id)
	{
		companyService.deleteCompany(id);
		//System.out.println("deleted");
	}
	
	@GetMapping("/listproduct")
	public List<Product> listProduct()
	{
		return productService.getAllProducts();
	}
	
	@GetMapping("/getProductById/{id}")
	public ResponseEntity<Product> getProductId(@PathVariable Integer id)
	{
		try {
			Product product=productService.getProduct(id);
			return new ResponseEntity<Product>(product,HttpStatus.OK);	
		}
		catch(NoSuchElementException e)
		{
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		}		
	}
	
	@GetMapping("/listproductquantity")
	public List<ProductQuantity> listProductQuantity()
	{
		return productQuantityService.getAllProductsQuantity();
	}
	
	@PostMapping(value = "/saveProduct", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.MULTIPART_FORM_DATA_VALUE })
	public Boolean saveProduct(@RequestPart("request") String productRequestString,@RequestPart("imgUrl") MultipartFile multipartFile)
	{
		
		ProductRequest productRequest = new Gson().fromJson(productRequestString, ProductRequest.class);
	
		if(productService.saveProduct(productRequest, multipartFile))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	@PostMapping("/saveProductQuantity")
	public Boolean saveProductQuantity(@RequestBody ProductQuantityRequest productQuantityRequest) throws ParseException
	{
		
		if(productQuantityService.saveProductQuantity(productQuantityRequest))
		{
			return  true;
		}
		else
		{
			return false;
		}
	}
	
	@GetMapping("/getAllCartItem")
	public ResponseEntity<ResponseDTO> getAllCartItem(){
		ResponseEntity<ResponseDTO> response = cartService.getAllCarItem();
		return response;
	}
	
	@GetMapping("/getAllOrderDetails")
	public ResponseEntity<ResponseDTO> getAllOrderDetails(){
		ResponseEntity<ResponseDTO> response = transactionService.getAllOrderDetails();
		return response;
	}
	
	
	}


