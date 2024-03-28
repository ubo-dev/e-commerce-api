package com.ubo.ecommerceapi.dto.request.cart;

public record CreateCustomerRequest(String name, String email, String password, String address, String phone) {
}
