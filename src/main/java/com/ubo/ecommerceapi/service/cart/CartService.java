package com.ubo.ecommerceapi.service.cart;

import com.ubo.ecommerceapi.dto.CartDto;
import com.ubo.ecommerceapi.dto.request.UpdateCartRequest;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface CartService {

    CartDto getCart(UUID cartId);

    CartDto updateCart(UUID cartId, UpdateCartRequest request);

    void emptyCart(UUID cartId);
}
