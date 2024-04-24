package com.example.upahar.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.example.upahar.model.Products;

@Repository
public interface ProductsRepository extends JpaRepository<Products,Integer>{

    List <Products> findByProductQuantityGreaterThan(int a);
}