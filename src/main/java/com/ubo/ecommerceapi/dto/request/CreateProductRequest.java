package com.ubo.ecommerceapi.dto.request;

public record CreateProductRequest(String name, double price, int quantity, String description) {
}
