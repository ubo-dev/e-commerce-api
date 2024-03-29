package com.ubo.ecommerceapi.service.product;

import com.ubo.ecommerceapi.dto.ProductDto;
import com.ubo.ecommerceapi.dto.converter.ProductDtoConverter;
import com.ubo.ecommerceapi.dto.request.CreateProductRequest;
import com.ubo.ecommerceapi.dto.request.UpdateProductRequest;
import com.ubo.ecommerceapi.model.Cart;
import com.ubo.ecommerceapi.model.Customer;
import com.ubo.ecommerceapi.model.Product;
import com.ubo.ecommerceapi.repository.CartRepository;
import com.ubo.ecommerceapi.repository.CustomerRepository;
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
    private final CustomerRepository customerRepository;

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

    public List<ProductDto> addProductToCart(UUID customerId, UUID productId) {
        Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new RuntimeException("Customer not found"));

        Cart cart = customer.getCart();
        List<Product> products = cart.getProduct();

        Product productToBeAdded = productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Product not found"));

        var total = products.stream().mapToDouble(Product::getPrice).sum();

        products.add(productToBeAdded);
        cart.setProduct(products);

        cart.setTotal(total + productToBeAdded.getPrice());
        productToBeAdded.setQuantity(productToBeAdded.getQuantity() - 1);

        if (productToBeAdded.getQuantity() < 0) {
            throw new RuntimeException("Product out of stock");
        }

        cartRepository.save(cart);
        productRepository.save(productToBeAdded);

        return productDtoConverter.convertListToDto(products);
    }

    public List<ProductDto> removeProductFromCart(UUID customerId, UUID productId) {
        Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new RuntimeException("Customer not found"));

        Cart cart = customer.getCart();
        List<Product> products = cart.getProduct();

        Product productToBeDeleted = productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Product not found"));

        products.remove(productToBeDeleted);
        cart.setProduct(products);

        var total = products.stream().mapToDouble(Product::getPrice).sum();
        cart.setTotal(total - productToBeDeleted.getPrice());
        productToBeDeleted.setQuantity(productToBeDeleted.getQuantity() + 1);

        cartRepository.save(cart);
        productRepository.save(productToBeDeleted);

        return productDtoConverter.convertListToDto(products);
    }
}
