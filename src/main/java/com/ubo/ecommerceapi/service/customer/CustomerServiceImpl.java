package com.ubo.ecommerceapi.service.customer;

import com.ubo.ecommerceapi.dto.CustomerDto;
import com.ubo.ecommerceapi.dto.converter.CustomerDtoConverter;
import com.ubo.ecommerceapi.dto.request.CreateCustomerRequest;
import com.ubo.ecommerceapi.model.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerDtoConverter customerDtoConverter;
    public CustomerDto addCustomer(CreateCustomerRequest request) {
        return customerDtoConverter.convertToDto(
                Customer.builder()
                        .name(request.name())
                        .email(request.email())
                        .password(request.password())
                        .address(request.address())
                        .phone(request.phone())
                        .build()
        );
    }
}
