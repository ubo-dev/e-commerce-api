package com.ubo.ecommerceapi.dto.request;

public record CreateCustomerRequest(String name, String email, String password, String address, String phone) {
}
