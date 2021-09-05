package com.ehealthcare.medicare.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ehealthcare.medicare.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer> {

	List<Cart> findAllByUserId(Integer userId);

	List<Cart> findAllByUserIdAndStatus(Integer userId, String string);

	void deleteAllByUserIdAndStatus(Integer userId, String string);

}
