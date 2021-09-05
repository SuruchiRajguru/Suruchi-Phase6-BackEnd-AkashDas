package com.ehealthcare.medicare.serviceImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ehealthcare.medicare.dto.request.TransactionDetailsRequest;
import com.ehealthcare.medicare.dto.response.OrderDetailsResponse;
import com.ehealthcare.medicare.dto.response.ResponseDTO;
import com.ehealthcare.medicare.entity.Cart;
import com.ehealthcare.medicare.entity.Order;
import com.ehealthcare.medicare.entity.Product;
import com.ehealthcare.medicare.entity.ProductQuantity;
import com.ehealthcare.medicare.entity.SignUp;
import com.ehealthcare.medicare.entity.Transaction;
import com.ehealthcare.medicare.repository.CartRepository;
import com.ehealthcare.medicare.repository.OrderRepository;
import com.ehealthcare.medicare.repository.ProductQuantityRepository;
import com.ehealthcare.medicare.repository.ProductRepository;
import com.ehealthcare.medicare.repository.SignUpRepository;
import com.ehealthcare.medicare.repository.TransactionRepository;
import com.ehealthcare.medicare.service.TransactionService;
import com.ehealthcare.medicare.util.CommonUtils;

@Service
public class TransactionServiceImpl implements TransactionService{
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	@Autowired
	private ProductQuantityRepository productQuantityRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private SignUpRepository signUpRepository;
	
	@Autowired
	private CommonUtils commonUtils;
	
	@Autowired
	private CartRepository cartRepository;
	
	@Override
	public Boolean saveTransaction(TransactionDetailsRequest transactionDetailsRequest) {
		try {
			System.out.println(transactionDetailsRequest.getBankName());
			System.out.println(transactionDetailsRequest.getCardNumber());
			System.out.println(LocalDateTime.now());
			System.out.println(transactionDetailsRequest.getModeOfTransaction());
			System.out.println(transactionDetailsRequest.getNameOnCard());
			System.out.println(transactionDetailsRequest.getUserId());
			System.out.println(transactionDetailsRequest.getQuantityids());
			
			Transaction transaction=new Transaction();
			Double transactionAmount=0.0;
			
			List<String> stringProductsQuantityId =(Arrays.asList(transactionDetailsRequest.getQuantityids().split(",")));
			for(String qid:stringProductsQuantityId)
			{
				System.out.println("transactionAmount "+ transactionAmount);
				Integer intProductQid=Integer.parseInt(qid);
				transactionAmount=transactionAmount+productQuantityRepository.fetchPriceById(intProductQid);
			}
			System.out.println("transactionAmount "+ transactionAmount);
			
			transaction.setBankName(transactionDetailsRequest.getBankName());
			transaction.setCardNumber(transactionDetailsRequest.getCardNumber());
			transaction.setDateOfTrans(LocalDateTime.now());
			transaction.setModeOfTransaction(transactionDetailsRequest.getModeOfTransaction());
			transaction.setNameOnCard(transactionDetailsRequest.getNameOnCard());
			transaction.setTransactionAmount(transactionAmount);
			
			Transaction transactionResult=transactionRepository.save(transaction);
			
			for(String qid:stringProductsQuantityId)
			{
				Integer intProductQid=Integer.parseInt(qid);
				Order order =new Order();
				order.setQuantityId(intProductQid);
				order.setUserId(Integer.parseInt(transactionDetailsRequest.getUserId()));
				order.setTransactionId(transactionResult.getTransactionId());
				orderRepository.save(order);	
			}	
			
			List<Cart> carts = cartRepository.findAllByUserId(Integer.parseInt(transactionDetailsRequest.getUserId()));
			for(Cart cart : carts) {
				if(cart.getStatus().equalsIgnoreCase("order")) {
					cartRepository.deleteById(cart.getCartId());
				}
				
			}

			
			
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public ResponseEntity<ResponseDTO> getAllOrderByUserId(Integer userId) {
		List<Order> orderItems = orderRepository.findAllByUserId(userId);
		List<OrderDetailsResponse> orderDetailsResponseList = new ArrayList<>();
		orderItems.stream().forEach(orderItem ->{
			OrderDetailsResponse orderDetailsResponse = new OrderDetailsResponse();
			orderDetailsResponse.setOrderId(orderItem.getOrderId());
			Optional<SignUp> userDetails = signUpRepository.findById(userId);
			orderDetailsResponse.setUserId(userId);
			orderDetailsResponse.setUserConcatName(userDetails.get().getFirstName()+" " +userDetails.get().getLastName());
			orderDetailsResponse.setQuantityId(orderItem.getQuantityId());
			Optional<ProductQuantity> productQuantity = productQuantityRepository.findById(orderItem.getQuantityId());
			orderDetailsResponse.setPrice(productQuantity.get().getPrice());
			Optional<Product> product = productRepository.findById(productQuantity.get().getProduct().getProductId());
			orderDetailsResponse.setProductId(product.get().getProductId());
			orderDetailsResponse.setProductName(product.get().getProductName());
			orderDetailsResponse.setShortDescription(product.get().getShortDescription());
			orderDetailsResponse.setLongDescription(product.get().getLongDescription());
			orderDetailsResponse.setCategoryId(product.get().getCategory().getCategoryId());
			orderDetailsResponse.setCategoryName(product.get().getCategory().getCategoryName());
			orderDetailsResponse.setCompanyId(product.get().getCompany().getCompanyId());
			orderDetailsResponse.setCompanyName(product.get().getCompany().getCompanyName());
			orderDetailsResponse.setImgUrl("D:/Suruchi Rajguru/Simplilearn/Projects/Phase6/medicare/Images/"+product.get().getProductId()+"/" + product.get().getImgUrl());
			Optional<Transaction> transactionDetails = transactionRepository.findById(orderItem.getTransactionId());
			orderDetailsResponse.setTransactionId(transactionDetails.get().getTransactionId());
			orderDetailsResponse.setBankName(transactionDetails.get().getBankName());
			orderDetailsResponse.setCardNumber(transactionDetails.get().getCardNumber());
			orderDetailsResponse.setNameOnCard(transactionDetails.get().getNameOnCard());
			orderDetailsResponse.setDateOfTrans(transactionDetails.get().getDateOfTrans());
			orderDetailsResponse.setTransactionAmount(transactionDetails.get().getTransactionAmount());
			orderDetailsResponse.setModeOfTransaction(transactionDetails.get().getModeOfTransaction());
			orderDetailsResponseList.add(orderDetailsResponse);
			
		});
		
		return commonUtils.generateResponse("Success",orderDetailsResponseList , HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ResponseDTO> getAllOrderDetails() {
		List<Order> orderItems = orderRepository.findAll();
		List<OrderDetailsResponse> orderDetailsResponseList = new ArrayList<>();
		orderItems.stream().forEach(orderItem ->{
			OrderDetailsResponse orderDetailsResponse = new OrderDetailsResponse();
			orderDetailsResponse.setOrderId(orderItem.getOrderId());
			Optional<SignUp> userDetails = signUpRepository.findById(orderItem.getUserId());
			orderDetailsResponse.setUserId(orderItem.getUserId());
			orderDetailsResponse.setUserConcatName(userDetails.get().getFirstName()+" " +userDetails.get().getLastName());
			orderDetailsResponse.setQuantityId(orderItem.getQuantityId());
			Optional<ProductQuantity> productQuantity = productQuantityRepository.findById(orderItem.getQuantityId());
			orderDetailsResponse.setPrice(productQuantity.get().getPrice());
			Optional<Product> product = productRepository.findById(productQuantity.get().getProduct().getProductId());
			orderDetailsResponse.setProductId(product.get().getProductId());
			orderDetailsResponse.setProductName(product.get().getProductName());
			orderDetailsResponse.setShortDescription(product.get().getShortDescription());
			orderDetailsResponse.setLongDescription(product.get().getLongDescription());
			orderDetailsResponse.setCategoryId(product.get().getCategory().getCategoryId());
			orderDetailsResponse.setCategoryName(product.get().getCategory().getCategoryName());
			orderDetailsResponse.setCompanyId(product.get().getCompany().getCompanyId());
			orderDetailsResponse.setCompanyName(product.get().getCompany().getCompanyName());
			orderDetailsResponse.setImgUrl("D:/Suruchi Rajguru/Simplilearn/Projects/Phase6/medicare/Images/"+product.get().getProductId()+"/" + product.get().getImgUrl());
			Optional<Transaction> transactionDetails = transactionRepository.findById(orderItem.getTransactionId());
			orderDetailsResponse.setTransactionId(transactionDetails.get().getTransactionId());
			orderDetailsResponse.setBankName(transactionDetails.get().getBankName());
			orderDetailsResponse.setCardNumber(transactionDetails.get().getCardNumber());
			orderDetailsResponse.setNameOnCard(transactionDetails.get().getNameOnCard());
			orderDetailsResponse.setDateOfTrans(transactionDetails.get().getDateOfTrans());
			orderDetailsResponse.setTransactionAmount(transactionDetails.get().getTransactionAmount());
			orderDetailsResponse.setModeOfTransaction(transactionDetails.get().getModeOfTransaction());
			orderDetailsResponseList.add(orderDetailsResponse);
			
		});
		
		return commonUtils.generateResponse("Success",orderDetailsResponseList , HttpStatus.OK);
	}
	
	

}
