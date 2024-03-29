package com.ubo.ecommerceapi.controller;

import com.ubo.ecommerceapi.dto.CartDto;
import com.ubo.ecommerceapi.dto.request.UpdateCartRequest;
import com.ubo.ecommerceapi.service.cart.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    @GetMapping("/getCart/{customerId}")
    public ResponseEntity<CartDto> getCart(@PathVariable String customerId) {
        return ResponseEntity.ok(cartService.getCart(UUID.fromString(customerId)));
    }

    @PutMapping("/updateCart/{customerId}")
    public ResponseEntity<CartDto> updateCart(@PathVariable String customerId, @RequestBody UpdateCartRequest request) {
        return ResponseEntity.ok(cartService.updateCart(UUID.fromString(customerId), request));
    }

    @PutMapping("/emptyCart/{customerId}")
    public ResponseEntity<String> emptyCart(@PathVariable String customerId) {
        cartService.emptyCart(UUID.fromString(customerId));
        return ResponseEntity.ok("Cart successfully emptied");
    }

}
