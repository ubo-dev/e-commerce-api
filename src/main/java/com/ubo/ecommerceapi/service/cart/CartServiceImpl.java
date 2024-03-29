package com.ubo.ecommerceapi.service.cart;

import com.ubo.ecommerceapi.dto.CartDto;
import com.ubo.ecommerceapi.dto.converter.CartDtoConverter;
import com.ubo.ecommerceapi.dto.request.UpdateCartRequest;
import com.ubo.ecommerceapi.repository.CartRepository;
import com.ubo.ecommerceapi.repository.CustomerRepository;
import com.ubo.ecommerceapi.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService{

    private final CartRepository cartRepository;
    private final CartDtoConverter cartDtoConverter;
    private final ProductRepository productRepository;
    private final CustomerRepository customerRepository;


    public CartDto getCart(UUID customerId) {
        var customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        return cartDtoConverter.convertToDto(customer.getCart());
    }


    public CartDto updateCart(UUID customerId, UpdateCartRequest request) {
        var customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        var cart = customer.getCart();

        var products = cart.getProduct();
        var newProduct = productRepository.findById(request.productId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        products.add(newProduct);
        cart.setProduct(products);

        var newTotal = newProduct.getPrice() + cart.getTotal();
        cart.setTotal(newTotal);

        return cartDtoConverter.convertToDto(cartRepository.save(cart));
    }

    public void emptyCart(UUID customerId) {
        var customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        var cart = customer.getCart();

        cart.setProduct(null);
        cart.setTotal(0.0);

        cartRepository.save(cart);
    }
}
