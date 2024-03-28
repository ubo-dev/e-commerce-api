package com.ubo.ecommerceapi.service.customer;

import com.ubo.ecommerceapi.dto.CustomerDto;
import com.ubo.ecommerceapi.dto.request.CreateCustomerRequest;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService {

    CustomerDto addCustomer(CreateCustomerRequest request);
}
