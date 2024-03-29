package com.ubo.ecommerceapi.service.order;

import com.ubo.ecommerceapi.dto.OrderDto;
import com.ubo.ecommerceapi.dto.converter.OrderDtoConverter;
import com.ubo.ecommerceapi.dto.request.PlaceOrderRequest;
import com.ubo.ecommerceapi.model.Cart;
import com.ubo.ecommerceapi.model.Customer;
import com.ubo.ecommerceapi.model.Order;
import com.ubo.ecommerceapi.model.Product;
import com.ubo.ecommerceapi.repository.CustomerRepository;
import com.ubo.ecommerceapi.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;
    private final OrderDtoConverter orderDtoConverter;
    private final CustomerRepository customerRepository;

    public OrderDto placeOrder(UUID customerId, String orderCode) {

        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        return orderDtoConverter.convertToDto(
                orderRepository.save(
                        Order.builder()
                                .orderCode(orderCode)
                                .customer(customer)
                                .createdAt(LocalDateTime.now())
                                .updatedAt(LocalDateTime.now())
                                .build()
                )
        );
    }

    public OrderDto getOrderForCode(String orderCode) {
        return orderDtoConverter.convertToDto(
                orderRepository.findByOrderCode(orderCode)
        );
    }

    public List<OrderDto> getAllOrdersForCustomer(UUID customerId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        return customer.getOrder().stream().map(
                orderDtoConverter::convertToDto
        ).toList();
    }
}
