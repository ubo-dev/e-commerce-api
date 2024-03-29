package com.ubo.ecommerceapi.controller;

import com.ubo.ecommerceapi.dto.CustomerDto;
import com.ubo.ecommerceapi.dto.request.CreateCustomerRequest;
import com.ubo.ecommerceapi.service.customer.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/addCustomer")
    public ResponseEntity<CustomerDto> register(@RequestBody CreateCustomerRequest request) {
        return ResponseEntity.ok(customerService.addCustomer(request));
    }
}
