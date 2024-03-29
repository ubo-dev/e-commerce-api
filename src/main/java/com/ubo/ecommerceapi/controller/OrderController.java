package com.ubo.ecommerceapi.controller;

import com.ubo.ecommerceapi.dto.OrderDto;
import com.ubo.ecommerceapi.dto.request.PlaceOrderRequest;
import com.ubo.ecommerceapi.service.order.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/placeOrder/{customerId}/{orderCode}")
    public ResponseEntity<OrderDto> placeOrder(@PathVariable String customerId, @PathVariable String orderCode) {
        return ResponseEntity.ok(orderService.placeOrder(UUID.fromString(customerId), orderCode));
    }

    @GetMapping("/getOrder/{orderCode}")
    public ResponseEntity<OrderDto> getOrder(@PathVariable String orderCode) {
        return ResponseEntity.ok(orderService.getOrderForCode(orderCode));
    }

    @GetMapping("/getOrders/{customerId}")
    public ResponseEntity<List<OrderDto>> getOrders(@PathVariable String customerId) {
        return ResponseEntity.ok(orderService.getAllOrdersForCustomer(UUID.fromString(customerId)));
    }

}
