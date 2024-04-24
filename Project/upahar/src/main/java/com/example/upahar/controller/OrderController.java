package com.example.upahar.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.upahar.model.OrderTab;
import com.example.upahar.services.OrderService;

@RestController
public class OrderController {

    private OrderService orderService;

    public OrderController(OrderService orderService){
        this.orderService=orderService;
    }

    @PostMapping("/orders")
    public String postOrderName(@RequestBody OrderTab order) {
        
        orderService.saveOrder(order);
        return "Saved the user details";
    }

    @GetMapping("/getorders")
    public List<OrderTab> getDetails() {
        return orderService.getOrderDetaiList();
    }
    

    @GetMapping("/page/{pn}/{ps}")
    public Page<OrderTab> getMethod(@PathVariable("pn") int pageNo,@PathVariable("ps") int pageSize) {
        return orderService.pagination(pageNo, pageSize);
    }
    @GetMapping("/pagelist/{pn}/{ps}")
    public List<OrderTab> getMethodName(@PathVariable("pn") int pageNo,@PathVariable("ps") int pageSize) {
        return orderService.paginations(pageNo, pageSize);
    }

    @GetMapping("/pageSort")
    public Page<OrderTab> getMethodSort(@RequestParam int pageNo,@RequestParam int pageSize,@RequestParam String name) {
        return orderService.paginationSort(pageNo, pageSize,name);
    }

    @DeleteMapping("/delorder/{id}")
    public String deleteQuery(@PathVariable("id") int id) {
        if (orderService.getOrder(id) != null) {
            orderService.deleteOrder(id);
        }
        return "Post Deleted Successfully.";
    }
    
    
}
