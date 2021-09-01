package com.ehealthcare.medicare.controller;

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

import com.ehealthcare.medicare.dto.request.SearchProductByNameRequest;
import com.ehealthcare.medicare.entity.SignUp;
import com.ehealthcare.medicare.service.CategoryService;
import com.ehealthcare.medicare.service.CompanyService;
import com.ehealthcare.medicare.service.ProductService;
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
	
	@GetMapping("/userSignUp")
	public List<SignUp> list()
	{
		return userSignUpService.getAllSignUp();
	}
	
	@PostMapping("/saveUserSignUp")
	public void saveUserSignUp(@RequestBody SignUp signUp)//,Model model)
	{
	//	SignUp signUptry=userSignUpService.saveSignUp(signUp);
	//	model.addAttribute("user_id", signUptry.getUser_id());
	//	return "saved record";
		
		userSignUpService.saveSignUp(signUp);
//		if(userSignUpService.saveSignUp(signUp))
//		{
//			return true;
//		}
//		else
//		{
//			return false;
//		}
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


	@PostMapping("/searchProductByName")
	public String searchProductByName(@ModelAttribute SearchProductByNameRequest searchProductByNameRequest,Model model)
	{
		model.addAttribute("categories",categoryService.getAllCategory());
		model.addAttribute("companies", companyService.getAllCompany());
		
		return "Hello";
		
	}
}
