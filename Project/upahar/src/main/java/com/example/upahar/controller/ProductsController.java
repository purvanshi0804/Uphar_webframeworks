package com.example.upahar.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.upahar.model.Products;
import com.example.upahar.services.ProductsService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class ProductsController {

    private ProductsService productsService;

    public ProductsController(ProductsService productsService){
        this.productsService=productsService;
    }

    @PostMapping("/product")
    public String postProductName(@RequestBody Products products) {

        productsService.saveProducts(products);
        return "Saved the user details";
    }

    @GetMapping("/getproducts")
    public List<Products> getallani() {
        return productsService.getProductDetails();
    }



   @PutMapping("product/{id}")
   public ResponseEntity<String> putMethodName(@PathVariable int id, @RequestBody Products updateProducts) {

        Products existProducts = productsService.getProducts(id);
        if(existProducts != null){
            existProducts.setProductQuantity(updateProducts.getProductQuantity());
            productsService.saveProducts(existProducts);
        }
        else{
            return new ResponseEntity<>("No data found",HttpStatus.NOT_ACCEPTABLE) ;
        }
        return new ResponseEntity<>("Quantity updated",HttpStatus.ACCEPTED);
   }

   @GetMapping("/greaterthan/{a}")
   public List<Products> getProductQuantityGreaterThan(@PathVariable int a) {
       return productsService.getProductQuantitygreat(a);
   }

   @DeleteMapping("/delproducts/{id}")
    public String deleteQuery(@PathVariable("id") int id) {
        if (productsService.getProducts(id) != null) {
            productsService.deleteProduct(id);
        }
        return "Post Deleted Successfully.";
    }
}
    
