package com.ehealthcare.medicare.serviceImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ehealthcare.medicare.dto.request.CartRequest;
import com.ehealthcare.medicare.dto.response.CartItemResponse;
import com.ehealthcare.medicare.dto.response.OrderDetailsResponse;
import com.ehealthcare.medicare.dto.response.ResponseDTO;
import com.ehealthcare.medicare.entity.Cart;
import com.ehealthcare.medicare.entity.Order;
import com.ehealthcare.medicare.entity.Product;
import com.ehealthcare.medicare.entity.ProductQuantity;
import com.ehealthcare.medicare.entity.SignUp;
import com.ehealthcare.medicare.repository.CartRepository;
import com.ehealthcare.medicare.repository.CategoryRepository;
import com.ehealthcare.medicare.repository.CompanyRepository;
import com.ehealthcare.medicare.repository.OrderRepository;
import com.ehealthcare.medicare.repository.ProductQuantityRepository;
import com.ehealthcare.medicare.repository.ProductRepository;
import com.ehealthcare.medicare.repository.SignUpRepository;
import com.ehealthcare.medicare.service.CartService;
import com.ehealthcare.medicare.util.CommonUtils;

@Service
public class CartServiceImpl implements CartService {

	
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private CommonUtils commonUtils;
	
	@Autowired
	private ProductQuantityRepository productQuantityRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private SignUpRepository signUpRepository;
	
	@Autowired
	private CompanyRepository comapnyRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	
	
	@Override
	public boolean saveCartItemByUserId(CartRequest cartRequest) {
		
		try {
			Cart cart = new Cart();
			cart.setCreatedDate(LocalDateTime.now());
			cart.setQuantityId(cartRequest.getQuantityId());
			cart.setUserId(cartRequest.getUserId());
			cart.setStatus("cart");
			cartRepository.save(cart);
			
			return true;
		}catch(Exception e) {
			return false;
		}
	}

	@Override
	public ResponseEntity<ResponseDTO> getAllCarItemtByUserId(Integer userId) {
		
		List<Cart> cartItems = cartRepository.findAllByUserId(userId);
		List<CartItemResponse> cartItemResponseList = new ArrayList<>();
		cartItems.stream().forEach(cartItem ->{
			CartItemResponse cartItemResponse = new CartItemResponse();
			cartItemResponse.setCartId(cartItem.getCartId());
			cartItemResponse.setCreatedDate(cartItem.getCreatedDate());
			cartItemResponse.setStatus(cartItem.getStatus());
			Optional<SignUp> userDetails = signUpRepository.findById(userId);
			cartItemResponse.setUserId(userId);
			cartItemResponse.setUserConcatName(userDetails.get().getFirstName()+" " +userDetails.get().getLastName());
			cartItemResponse.setQuantityId(cartItem.getQuantityId());
			Optional<ProductQuantity> productQuantity = productQuantityRepository.findById(cartItem.getQuantityId());
			cartItemResponse.setPrice(productQuantity.get().getPrice());
			Optional<Product> product = productRepository.findById(productQuantity.get().getProduct().getProductId());
			cartItemResponse.setProductId(product.get().getProductId());
			cartItemResponse.setProductName(product.get().getProductName());
			cartItemResponse.setShortDescription(product.get().getShortDescription());
			cartItemResponse.setLongDescription(product.get().getLongDescription());
			cartItemResponse.setCategoryId(product.get().getCategory().getCategoryId());
			cartItemResponse.setCategoryName(product.get().getCategory().getCategoryName());
			cartItemResponse.setCompanyId(product.get().getCompany().getCompanyId());
			cartItemResponse.setCompanyName(product.get().getCompany().getCompanyName());
			cartItemResponse.setImgUrl(product.get().getImgUrl());
			cartItemResponseList.add(cartItemResponse);
			
		});
		
		return commonUtils.generateResponse("Success",cartItemResponseList , HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ResponseDTO> getAllCarItem() {
		List<Cart> cartItems = cartRepository.findAll();
		List<CartItemResponse> cartItemResponseList = new ArrayList<>();
		cartItems.stream().forEach(cartItem ->{
			CartItemResponse cartItemResponse = new CartItemResponse();
			cartItemResponse.setCartId(cartItem.getCartId());
			cartItemResponse.setCreatedDate(cartItem.getCreatedDate());
			cartItemResponse.setStatus(cartItem.getStatus());
			Optional<SignUp> userDetails = signUpRepository.findById(cartItem.getUserId());
			cartItemResponse.setUserId(cartItem.getUserId());
			cartItemResponse.setUserConcatName(userDetails.get().getFirstName()+" " +userDetails.get().getLastName());
			cartItemResponse.setQuantityId(cartItem.getQuantityId());
			Optional<ProductQuantity> productQuantity = productQuantityRepository.findById(cartItem.getQuantityId());
			cartItemResponse.setPrice(productQuantity.get().getPrice());
			Optional<Product> product = productRepository.findById(productQuantity.get().getProduct().getProductId());
			cartItemResponse.setProductId(product.get().getProductId());
			cartItemResponse.setProductName(product.get().getProductName());
			cartItemResponse.setShortDescription(product.get().getShortDescription());
			cartItemResponse.setLongDescription(product.get().getLongDescription());
			cartItemResponse.setCategoryId(product.get().getCategory().getCategoryId());
			cartItemResponse.setCategoryName(product.get().getCategory().getCategoryName());
			cartItemResponse.setCompanyId(product.get().getCompany().getCompanyId());
			cartItemResponse.setCompanyName(product.get().getCompany().getCompanyName());
			cartItemResponse.setImgUrl(product.get().getImgUrl());
			cartItemResponseList.add(cartItemResponse);
			
		});
		
		return commonUtils.generateResponse("Success",cartItemResponseList , HttpStatus.OK);
	}

	@Override
	public boolean removeCartItem(Integer id) {
		try {
			cartRepository.deleteById(id);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	@Override
	public boolean updateCartStatus(Integer id) {
		try {
			Optional<Cart> cartOptional = cartRepository.findById(id);
			Cart cart = cartOptional.get();
			cart.setStatus("order");
			cartRepository.save(cart);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	@Override
	public ResponseEntity<ResponseDTO> getAllCheckOutItemByUserId(Integer userId) {
		List<Cart> cartItems = cartRepository.findAllByUserIdAndStatus(userId,"order");
		List<CartItemResponse> cartItemResponseList = new ArrayList<>();
		cartItems.stream().forEach(cartItem ->{
			CartItemResponse cartItemResponse = new CartItemResponse();
			cartItemResponse.setCartId(cartItem.getCartId());
			cartItemResponse.setCreatedDate(cartItem.getCreatedDate());
			cartItemResponse.setStatus(cartItem.getStatus());
			Optional<SignUp> userDetails = signUpRepository.findById(userId);
			cartItemResponse.setUserId(userId);
			cartItemResponse.setUserConcatName(userDetails.get().getFirstName()+" " +userDetails.get().getLastName());
			cartItemResponse.setQuantityId(cartItem.getQuantityId());
			Optional<ProductQuantity> productQuantity = productQuantityRepository.findById(cartItem.getQuantityId());
			cartItemResponse.setPrice(productQuantity.get().getPrice());
			Optional<Product> product = productRepository.findById(productQuantity.get().getProduct().getProductId());
			cartItemResponse.setProductId(product.get().getProductId());
			cartItemResponse.setProductName(product.get().getProductName());
			cartItemResponse.setShortDescription(product.get().getShortDescription());
			cartItemResponse.setLongDescription(product.get().getLongDescription());
			cartItemResponse.setCategoryId(product.get().getCategory().getCategoryId());
			cartItemResponse.setCategoryName(product.get().getCategory().getCategoryName());
			cartItemResponse.setCompanyId(product.get().getCompany().getCompanyId());
			cartItemResponse.setCompanyName(product.get().getCompany().getCompanyName());
			cartItemResponse.setImgUrl(product.get().getImgUrl());
			cartItemResponseList.add(cartItemResponse);
			
		});
		
		return commonUtils.generateResponse("Success",cartItemResponseList , HttpStatus.OK);
	}

	
	

}
