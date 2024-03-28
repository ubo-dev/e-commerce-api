package com.ubo.ecommerceapi.service.order;

import com.ubo.ecommerceapi.dto.OrderDto;
import com.ubo.ecommerceapi.dto.converter.OrderDtoConverter;
import com.ubo.ecommerceapi.dto.request.PlaceOrderRequest;
import com.ubo.ecommerceapi.model.Order;
import com.ubo.ecommerceapi.repository.OrderRepository;
import com.ubo.ecommerceapi.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;
    private final OrderDtoConverter orderDtoConverter;
    private final ProductRepository productRepository;

    public OrderDto placeOrder(PlaceOrderRequest request) {
        return null;
    }

    public OrderDto getOrderForCode(String orderCode) {
        return null;
    }

    public List<OrderDto> getAllOrdersForCustomer(UUID customerId) {
        return null;
    }
}
