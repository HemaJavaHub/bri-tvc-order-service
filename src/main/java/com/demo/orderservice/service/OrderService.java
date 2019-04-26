package com.demo.orderservice.service;

import com.demo.orderservice.Utils.OrderNumberGenerator;
import com.demo.orderservice.models.Email;
import com.demo.orderservice.models.Order;
import com.demo.orderservice.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

//    @Autowired
//    OrderRepository orderRepository;

    public Email processOrder(Order orderDetails){
        String orderNumber = OrderNumberGenerator.randomOrderNumber();

        orderDetails.setOrderNumber(orderNumber);
        orderDetails.setDate(LocalDate.now());
        //Order order=orderRepository.save(orderDetails);
        Email email=new Email(orderDetails.getEmail(),orderDetails.getOrderNumber(),orderDetails.toString());
        return email;

        //update inventory
        //return orderNumber;
    }

   /* public List<Order> getOrderDetailsByUser(String email){
        return orderRepository.findByEmail(email);
    }

    public Order getOrderDetailsByOrderNumber(String orderNumber) {
        return orderRepository.findByOrderNumber(orderNumber);

    }*/



}
