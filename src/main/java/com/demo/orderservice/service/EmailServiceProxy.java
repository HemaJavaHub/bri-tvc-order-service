package com.demo.orderservice.service;

import com.demo.orderservice.models.Email;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name="zuul-gateway-server")
@RibbonClient(name="email-service")
@Service
public interface EmailServiceProxy {
    @PostMapping("email-service/email/sendEmail")
    String sendEmail(Email email);

}
