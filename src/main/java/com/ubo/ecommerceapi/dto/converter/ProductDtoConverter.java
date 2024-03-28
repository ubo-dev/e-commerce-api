package com.ubo.ecommerceapi.dto.converter;

import com.ubo.ecommerceapi.dto.ProductDto;
import com.ubo.ecommerceapi.model.Product;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductDtoConverter {

    public ProductDto convertToDto(Product product) {
        return new ProductDto(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getQuantity(),
                product.getDescription(),
                product.getCreatedAt(),
                product.getUpdatedAt()
        );
    }

    public List<ProductDto> convertListToDto(List<Product> products) {
        return products.stream().map(this::convertToDto).toList();
    }
}
