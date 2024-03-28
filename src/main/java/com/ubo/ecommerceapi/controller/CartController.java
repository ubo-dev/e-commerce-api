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

    @GetMapping("/getCart/{cartId}")
    public ResponseEntity<CartDto> getCart(@PathVariable String cartId) {
        return ResponseEntity.ok(cartService.getCart(UUID.fromString(cartId)));
    }

    @PutMapping("/updateCart/{cartId}")
    public ResponseEntity<CartDto> updateCart(@PathVariable String cartId, @RequestBody UpdateCartRequest request) {
        return ResponseEntity.ok(cartService.updateCart(UUID.fromString(cartId), request));
    }

    @PutMapping("/emptyCart/{cartId}")
    public ResponseEntity<String> emptyCart(@PathVariable String cartId) {
        cartService.emptyCart(UUID.fromString(cartId));
        return ResponseEntity.ok("Cart successfully emptied");
    }

}
