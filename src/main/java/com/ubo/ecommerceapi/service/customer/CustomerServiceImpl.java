package com.ubo.ecommerceapi.service.customer;

import com.ubo.ecommerceapi.dto.CustomerDto;
import com.ubo.ecommerceapi.dto.converter.CustomerDtoConverter;
import com.ubo.ecommerceapi.dto.request.CreateCustomerRequest;
import com.ubo.ecommerceapi.model.Cart;
import com.ubo.ecommerceapi.model.Customer;
import com.ubo.ecommerceapi.repository.CartRepository;
import com.ubo.ecommerceapi.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerDtoConverter customerDtoConverter;
    private final CartRepository cartRepository;

    public CustomerDto addCustomer(CreateCustomerRequest request) {

        Cart cart = Cart.builder()
                .product(null)
                .total(0.0)
                .build();

        Customer customer = Customer.builder()
                .name(request.name())
                .email(request.email())
                .password(request.password())
                .address(request.address())
                .phone(request.phone())
                .cart(cart)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        cart.setCustomer(customer);
        cart.setCreatedAt(LocalDateTime.now());
        cart.setUpdatedAt(LocalDateTime.now());
        cartRepository.save(cart);

        return customerDtoConverter.convertToDto(
                customerRepository.save(customer)
        );
    }
}
