package com.spring.cicd;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderDao orderDao;

    @GetMapping
    public List<Order> fetchOrders() {
        return orderDao.getOrders();
    }
    
    
    @GetMapping("/{id}")
    public Order fetchOrderById(@PathVariable int id) {
        for(Order ord: orderDao.getOrders()) {
        	if(ord.getId() == id)
        		return ord;
        }
        return null;
    }

}