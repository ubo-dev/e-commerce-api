package com.ubo.ecommerceapi.dto.converter;

import com.ubo.ecommerceapi.dto.OrderDto;
import com.ubo.ecommerceapi.model.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class OrderDtoConverter {

    private final CustomerDtoConverter customerDtoConverter;
    public OrderDto convertToDto(Order order) {
        return new OrderDto(
                order.getId(),
                customerDtoConverter.convertToDto(order.getCustomer()),
                order.getCreatedAt(),
                order.getUpdatedAt()
        );
    }

    public List<OrderDto> convertListToDto(List<Order> orders) {
        return orders.stream().map(this::convertToDto).toList();
    }
}
