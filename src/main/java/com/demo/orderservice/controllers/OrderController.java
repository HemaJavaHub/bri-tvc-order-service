package com.demo.orderservice.controllers;

import com.demo.orderservice.models.Email;
import com.demo.orderservice.models.Order;
import com.demo.orderservice.service.OrderService;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.shared.Application;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;


import org.springframework.beans.factory.annotation.Value;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import com.netflix.discovery.EurekaClient;
//import com.netflix.discovery.shared.Application;



@RestController
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private EurekaClient eurekaClient;

    @Autowired
    OrderService orderService;

    @Value("${service.application.serviceId}")
    private String emailservice;

    @GetMapping("/order")
    public String processOrder(@RequestBody Order orderDetails) throws JSONException {
        Email email= orderService.processOrder(orderDetails);
        System.out.println(emailservice);
        Application application = eurekaClient.getApplication(emailservice);
        System.out.println("APPLICATION SIZE: " + application.size());
        InstanceInfo instanceInfo = application.getInstances().get(0);
        String url = "http://" + instanceInfo.getIPAddr() + ":" + instanceInfo.getPort() + "/email/sendEmail";
        System.out.println("URL " + url);
        //create a request body
        JSONObject request=new JSONObject();
        request.put("emailAddress",email.getEmailAddress());
        request.put("subject",email.getSubject());
        request.put("content",email.getContent());
        //set headers
        HttpHeaders headers=new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity=new HttpEntity<String>(request.toString(),headers);
        ResponseEntity<String> emailResponse =restTemplate.exchange(url, HttpMethod.POST,entity,String.class);
        return emailResponse.getBody();
    }

    @GetMapping("/ordertest")
    public String test(){
        return "request received";
    }

   /* @PostMapping("/order/{orderNumber")
    public Order getOrderDetailsByOrderNumber(@PathVariable String email){
        return orderService.getOrderDetailsByOrderNumber(email);

    }


    @PostMapping("/order/user/{orderNumber")
    public List<Order> getOrderDetailsByUser(@PathVariable String email){
        return orderService.getOrderDetailsByUser(email);

    }*/

}
