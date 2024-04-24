package com.example.upahar.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.example.upahar.model.OrderTab;
import com.example.upahar.repository.OrderRepository;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public OrderTab saveOrder(OrderTab order){
        return orderRepository.save(order);
    }

    public OrderTab getOrder(int id){
        return orderRepository.findById(id).orElse(null);
    }

    public List <OrderTab> getOrderDetaiList(){
        return orderRepository.findAll();
    }

    public Page<OrderTab> pagination(int pageNo,int pageSize){
        return orderRepository.findAll(PageRequest.of(pageNo,pageSize));
    }
  
    public List<OrderTab> paginations(int pageNo,int pageSize){
      return orderRepository.findAll(PageRequest.of(pageNo,pageSize)).getContent();
    }

    public Page<OrderTab> paginationSort(int pageNo,int pageSize,String name){
        return orderRepository.findAll(PageRequest.of(pageNo,pageSize,Sort.by(Direction.DESC,name)));
    }

    public void deleteOrder(int id)
    {
        orderRepository.deleteById(id);
    }


}
