package com.example.upahar.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.upahar.model.Products;
import com.example.upahar.repository.ProductsRepository;

@Service
public class ProductsService {

    @Autowired
    private ProductsRepository productsRepository;

    public Products saveProducts(Products products){
        return productsRepository.save(products);
    }

    public Products getProducts(int id){
        return productsRepository.findById(id).orElse(null);
    }

    public List<Products> getProductDetails()
    {
        return productsRepository.findAll();
    }

    public List<Products> getProductQuantitygreat(int a){
        return productsRepository.findByProductQuantityGreaterThan(a);
    }

    public void deleteProduct(int id)
    {
        productsRepository.deleteById(id);
    }
    
}
