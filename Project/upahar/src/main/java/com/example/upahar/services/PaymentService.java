package com.example.upahar.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.upahar.model.Payment;
import com.example.upahar.repository.PaymentRepository;

@Service

public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public Payment savePayment(Payment payment){
        return paymentRepository.save(payment);
    }

    public List<Payment> getPaymenteDetails()
    {
        return paymentRepository.findAll();
    }

    public List<Payment> gPayments(String s){
        return paymentRepository.findByStatusContains(s);
    }

    
    
}
