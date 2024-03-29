package com.ubo.ecommerceapi.dto.request;

import com.ubo.ecommerceapi.dto.CartDto;
import com.ubo.ecommerceapi.dto.CustomerDto;
import com.ubo.ecommerceapi.dto.ProductDto;

import java.util.List;
import java.util.UUID;

public record PlaceOrderRequest(UUID customerId, String orderCode) {
}
