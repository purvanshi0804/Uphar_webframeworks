package com.example.upahar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.upahar.model.Payment;

@Repository

public interface PaymentRepository extends JpaRepository<Payment,Integer> {
    List<Payment> findByStatusContains(String s);
}

