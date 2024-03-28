package com.ubo.ecommerceapi.service.order;

import com.ubo.ecommerceapi.dto.OrderDto;
import com.ubo.ecommerceapi.dto.request.PlaceOrderRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface OrderService {

    OrderDto placeOrder(PlaceOrderRequest request);

    OrderDto getOrderForCode(String orderCode);

    List<OrderDto> getAllOrdersForCustomer(UUID customerId);
}
