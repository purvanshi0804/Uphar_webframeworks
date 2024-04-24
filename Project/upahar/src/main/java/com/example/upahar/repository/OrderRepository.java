package com.example.upahar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.upahar.model.OrderTab;

@Repository
public interface OrderRepository extends JpaRepository<OrderTab,Integer>{
    
} 
