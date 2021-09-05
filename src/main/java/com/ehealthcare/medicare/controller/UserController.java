package com.ehealthcare.medicare.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ehealthcare.medicare.dto.request.CartRequest;
import com.ehealthcare.medicare.dto.request.FilterProductRequestDTO;
import com.ehealthcare.medicare.dto.request.LoginRequest;
import com.ehealthcare.medicare.dto.request.SearchProductByTextRequest;
import com.ehealthcare.medicare.dto.request.TransactionDetailsRequest;
import com.ehealthcare.medicare.dto.response.ResponseDTO;
import com.ehealthcare.medicare.entity.SignUp;
import com.ehealthcare.medicare.service.CartService;
import com.ehealthcare.medicare.service.CategoryService;
import com.ehealthcare.medicare.service.CompanyService;
import com.ehealthcare.medicare.service.ProductService;
import com.ehealthcare.medicare.service.TransactionService;
import com.ehealthcare.medicare.service.UserSignUpService;


@RestController
@RequestMapping("/medicare")
@CrossOrigin(origins="*")
public class UserController {

	@Autowired
	private UserSignUpService userSignUpService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private CompanyService companyService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private TransactionService transactionService;
	
	@Autowired
	private CartService cartService;
	
	@GetMapping("/userSignUp")
	public List<SignUp> list()
	{
		return userSignUpService.getAllSignUp();
	}
	
	@PostMapping("/saveUserSignUp")
	public Boolean saveUserSignUp(@RequestBody SignUp signUp)//,Model model)
	{
	
		
		userSignUpService.saveSignUp(signUp);
		if(userSignUpService.saveSignUp(signUp))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
//	@GetMapping("/searchUserById/{id}")
	//public ResponseEntity<SignUp> searchUserById(@PathVariable Integer user_id)
	//{
		//try {
			//	SignUp signUp=userSignUpService.getUserSignUpById(user_id);
			//return new ResponseEntity<SignUp> (signUp,HttpStatus.OK);	
		//}
		//catch(Exception e) {
			//return new ResponseEntity<SignUp> (HttpStatus.NOT_FOUND);
		//}
//	}
	
	@GetMapping("/getUserSignUpById/{id}")
	public ResponseEntity<SignUp> getUserSignUpById(@PathVariable Integer id)
	{
		try {
			SignUp signUp=userSignUpService.getUserSignUpById(id);
			return new ResponseEntity<SignUp>(signUp,HttpStatus.OK);
			
		}
		catch(NoSuchElementException e)
		{
			return new ResponseEntity<SignUp>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Integer id)
	{
		userSignUpService.deleteUser(id);
	}


	@PostMapping("/searchProductByText")
	public ResponseEntity<ResponseDTO> searchProductByName(@RequestBody SearchProductByTextRequest searchProductByTextRequest)
	{
		 ResponseEntity<ResponseDTO> response = productService.getProductDetailsBySearchText(searchProductByTextRequest);
		
		return response;
		
	}
	
	@PostMapping("/filterProduct")
	public ResponseEntity<ResponseDTO> filterProducts(@RequestBody FilterProductRequestDTO filterProductRequestDTO) {
	
		
		ResponseEntity<ResponseDTO> response = productService.getAllProductDetailsByFilter(filterProductRequestDTO);
		return response;
	}
	
	/*	@GetMapping("/transactionPage/{quantityIds}/{userId}")
	public String getTransactionPage(@PathVariable String quantityIds,@PathVariable String userId,Model model)
	{	
		TransactionDetailsResponse transactionDetailsResponse = new TransactionDetailsResponse();
		transactionDetailsResponse =  productService.getTransactionDetails(quantityIds,userId);
		model.addAttribute("productDetails", transactionDetailsResponse.getProductDetailsResponseDTO());
		model.addAttribute("userDetails", transactionDetailsResponse.getUserRegister());
		 System.out.println("Test after");
		
		return "viewTransactionDetails";
	}

	 * 
	 * 
	 * */
	
	@PostMapping("/saveTransaction")
	public Boolean saveTransaction(@RequestBody TransactionDetailsRequest  transactionDetailsRequest) {
		
		
		
		if(transactionService.saveTransaction(transactionDetailsRequest))
		{
			return true;
		}
		else
		{
			return false;
		}
		
		
	}
	
	@PostMapping("/saveCartItemByUserId")
	public Boolean saveCartItemByUserId(@RequestBody CartRequest  cartRequest) {
		
		
		
		if(cartService.saveCartItemByUserId(cartRequest))
		{
			return true;
		}
		else
		{
			return false;
		}	
		
	}
	
	@GetMapping("/getAllCartItemByUserId/{userId}")
	public ResponseEntity<ResponseDTO> getAllCartItemByUserId(@PathVariable("userId") Integer userId){
		ResponseEntity<ResponseDTO> response = cartService.getAllCarItemtByUserId(userId);
		return response;
	}
	
	@GetMapping("/getAllOrderByUserId/{userId}")
	public ResponseEntity<ResponseDTO> getAllOrderByUserId(@PathVariable Integer userId){
		ResponseEntity<ResponseDTO> response = transactionService.getAllOrderByUserId(userId);
		return response;
	}
	
	
	@GetMapping("/viewProduct/{id}/{qid}")
	public ResponseEntity<ResponseDTO> getProductDetailById(@PathVariable Integer id, @PathVariable Integer qid )
	{	
		ResponseEntity<ResponseDTO> response = productService.getProductDetailById(id,qid);
		 
		
		return response;
	}
	
	
	
	@GetMapping("/viewAllProducts")
	public  ResponseEntity<ResponseDTO> viewAllProducts()
	{
		ResponseEntity<ResponseDTO> response = productService.getAllProductDetails();
		return response;
	}
	
	@PostMapping("/validateLogin")
	public ResponseEntity<ResponseDTO> validateSignUp(@RequestBody LoginRequest  loginRequest) {
		
		ResponseEntity<ResponseDTO>  response = userSignUpService.validateLogin(loginRequest);
		
		return response ;
		
	}
	

	@GetMapping("/removeCartItem/{id}")
	public Boolean removeCartItem(@PathVariable Integer id)
	{
		if(cartService.removeCartItem(id)) {
			return true;
		}
		else{
			return false;
		}
		//System.out.println("deleted");
	}
	
	@GetMapping("/updateCartStatus/{id}")
	public Boolean updateCartStatus(@PathVariable Integer id)
	{
		if(cartService.updateCartStatus(id)) {
			return true;
		}
		else{
			return false;
		}
		//System.out.println("deleted");
	}
	
	@GetMapping("/getAllCheckOutItemByUserId/{userId}")
	public ResponseEntity<ResponseDTO> getAllCheckOutItemByUserId(@PathVariable("userId") Integer userId){
		ResponseEntity<ResponseDTO> response = cartService.getAllCheckOutItemByUserId(userId);
		return response;
	}
	
	
	
	
	

	
	
}
