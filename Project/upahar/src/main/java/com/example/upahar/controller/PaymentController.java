package com.example.upahar.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.upahar.model.Payment;
import com.example.upahar.services.PaymentService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;



@RestController
public class PaymentController {

    private PaymentService paymentService;

    public PaymentController(PaymentService paymentService){
        this.paymentService=paymentService;
    }

    @ResponseStatus(value=HttpStatus.ACCEPTED)
    @PostMapping("/payment")
    public String postPaymentName(@RequestBody Payment payment) {

        paymentService.savePayment(payment);
        return "Saved";
    }

    @GetMapping("/status/{s}")
    public List <Payment> gPayments(@PathVariable String s) {
        return paymentService.gPayments(s);
    }
    
    
}
