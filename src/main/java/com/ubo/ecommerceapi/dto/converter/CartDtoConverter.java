package com.ubo.ecommerceapi.dto.converter;

import com.ubo.ecommerceapi.dto.CartDto;
import com.ubo.ecommerceapi.model.Cart;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CartDtoConverter {

    private final ProductDtoConverter productDtoConverter;
    private final CustomerDtoConverter customerDtoConverter;

    public CartDto convertToDto(Cart cart) {
        return new CartDto(
                cart.getId(),
                customerDtoConverter.convertToDto(cart.getCustomer()),
                productDtoConverter.convertListToDto(cart.getProduct()),
                cart.getTotal(),
                cart.getCreatedAt(),
                cart.getUpdatedAt()
        );
    }
}
