package com.ubo.ecommerceapi.service.product;

import com.ubo.ecommerceapi.dto.ProductDto;
import com.ubo.ecommerceapi.dto.request.CreateProductRequest;
import com.ubo.ecommerceapi.dto.request.UpdateProductRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface ProductService {

    ProductDto getProduct(UUID productId);

    ProductDto addProduct(CreateProductRequest request);

    ProductDto updateProduct(UUID productId, UpdateProductRequest request);

    void deleteProduct(UUID productId);

    List<ProductDto> addProductToCart(UUID customerId, UUID productId);

    List<ProductDto> removeProductFromCart(UUID customerId, UUID productId);
}
