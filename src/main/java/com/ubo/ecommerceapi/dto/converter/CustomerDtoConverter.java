package com.ubo.ecommerceapi.dto.converter;

import com.ubo.ecommerceapi.dto.CustomerDto;
import com.ubo.ecommerceapi.model.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerDtoConverter {



    public CustomerDto convertToDto(Customer customer) {
        return new CustomerDto(
                customer.getId(),
                customer.getName(),
                customer.getEmail(),
                customer.getAddress(),
                customer.getPhone(),
                customer.getOrder(),
                customer.getCreatedAt(),
                customer.getUpdatedAt()
        );
    }
}
