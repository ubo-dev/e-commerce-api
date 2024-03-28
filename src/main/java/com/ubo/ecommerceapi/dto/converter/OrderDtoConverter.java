package com.ubo.ecommerceapi.dto.converter;

import com.ubo.ecommerceapi.dto.OrderDto;
import com.ubo.ecommerceapi.model.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class OrderDtoConverter {

    private final ProductDtoConverter productDtoConverter;
    public OrderDto convertToDto(Order order) {
        return new OrderDto(
                order.getId(),
                productDtoConverter.convertListToDto(order.getProducts()),
                order.getCreatedAt(),
                order.getUpdatedAt()
        );
    }

    public List<OrderDto> convertListToDto(List<Order> orders) {
        return orders.stream().map(this::convertToDto).toList();
    }
}
