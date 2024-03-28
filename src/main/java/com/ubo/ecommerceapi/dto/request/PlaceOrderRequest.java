package com.ubo.ecommerceapi.dto.request;

import com.ubo.ecommerceapi.dto.CartDto;
import com.ubo.ecommerceapi.dto.CustomerDto;
import com.ubo.ecommerceapi.dto.ProductDto;

import java.util.List;

public record PlaceOrderRequest(CustomerDto customer, List<ProductDto> products) {
}
