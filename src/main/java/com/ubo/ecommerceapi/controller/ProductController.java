package com.ubo.ecommerceapi.controller;

import com.ubo.ecommerceapi.dto.ProductDto;
import com.ubo.ecommerceapi.dto.request.CreateProductRequest;
import com.ubo.ecommerceapi.dto.request.UpdateProductRequest;
import com.ubo.ecommerceapi.service.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/getProductById/{productId}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable String productId) {
        return ResponseEntity.ok(productService.getProduct(UUID.fromString(productId)));
    }

    @PostMapping("/addProduct")
    public ResponseEntity<ProductDto> addProduct(@RequestBody CreateProductRequest request) {
        return ResponseEntity.ok(productService.addProduct(request));
    }

    @PutMapping("/updateProduct/{productId}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable String productId, @RequestBody UpdateProductRequest request) {
        return ResponseEntity.ok(productService.updateProduct(UUID.fromString(productId), request));
    }

    @DeleteMapping("/deleteProduct/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable String productId) {
        productService.deleteProduct(UUID.fromString(productId));
        return ResponseEntity.ok().build();
    }

    @PostMapping("/addProductToCart/{customerId}/{productId}")
    public ResponseEntity<List<ProductDto>> addProductToCart(@PathVariable String customerId, @PathVariable String productId) {
        return ResponseEntity.ok(productService.addProductToCart(UUID.fromString(customerId), UUID.fromString(productId)));
    }

    @DeleteMapping("/removeProductFromCart/{customerId}/{productId}")
    public ResponseEntity<List<ProductDto>> removeProductFromCart(@PathVariable String customerId, @PathVariable String productId) {
        return ResponseEntity.ok(productService.removeProductFromCart(UUID.fromString(customerId), UUID.fromString(productId)));
    }
}
