package com.ubo.ecommerceapi.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record CustomerDto(UUID id, String name, String email, String address, String phone, List<OrderDto> order, LocalDateTime createdAt, LocalDateTime updatedAt) {
}
