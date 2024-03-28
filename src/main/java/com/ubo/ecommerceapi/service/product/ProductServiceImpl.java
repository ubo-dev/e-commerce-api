package com.ubo.ecommerceapi.service.product;

import com.ubo.ecommerceapi.dto.ProductDto;
import com.ubo.ecommerceapi.dto.converter.ProductDtoConverter;
import com.ubo.ecommerceapi.dto.request.CreateProductRequest;
import com.ubo.ecommerceapi.dto.request.UpdateProductRequest;
import com.ubo.ecommerceapi.model.Cart;
import com.ubo.ecommerceapi.model.Product;
import com.ubo.ecommerceapi.repository.CartRepository;
import com.ubo.ecommerceapi.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductDtoConverter productDtoConverter;
    private final CartRepository cartRepository;

    public ProductDto getProduct(UUID productId) {
        return productDtoConverter.convertToDto(
                productRepository.findById(productId).orElseThrow(
                                    () -> new RuntimeException("Product not found")
                )
        );
    }

    public ProductDto addProduct(CreateProductRequest request) {
        return productDtoConverter.convertToDto(
                productRepository.save(
                        Product.builder()
                                .name(request.name())
                                .description(request.description())
                                .price(request.price())
                                .quantity(request.quantity())
                                .createdAt(LocalDateTime.now())
                                .updatedAt(LocalDateTime.now())
                                .build()
                )
        );
    }

    public ProductDto updateProduct(UUID productId, UpdateProductRequest request) {
        Product product = productRepository
                .findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        product.setName(request.name());
        product.setDescription(request.description());
        product.setPrice(request.price());
        product.setQuantity(request.quantity());
        product.setUpdatedAt(LocalDateTime.now());

        return productDtoConverter.convertToDto(productRepository.save(product));
    }

    public void deleteProduct(UUID productId) {
        productRepository.deleteById(productId);
    }

    public List<ProductDto> addProductToCart(UUID cartId, UUID productId) {
        Cart cart = cartRepository.findById(cartId).orElseThrow(() -> new RuntimeException("Cart not found"));
        List<Product> products = cart.getProduct();

        products.add(productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Product not found")));
        cart.setProduct(products);
        cartRepository.save(cart);

        return productDtoConverter.convertListToDto(products);
    }

    public List<ProductDto> removeProductFromCart(UUID cartId, UUID productId) {
        Cart cart = cartRepository.findById(cartId).orElseThrow(() -> new RuntimeException("Cart not found"));
        List<Product> products = cart.getProduct();

        products.remove(productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Product not found")));
        cart.setProduct(products);
        cartRepository.save(cart);

        return productDtoConverter.convertListToDto(products);
    }
}
