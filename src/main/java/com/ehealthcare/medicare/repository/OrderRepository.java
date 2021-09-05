package com.ehealthcare.medicare.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ehealthcare.medicare.entity.Order;

public interface OrderRepository extends JpaRepository<Order,Integer>{

	List<Order> findAllByUserId(Integer userId);

}
