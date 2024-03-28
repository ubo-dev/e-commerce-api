package com.ubo.ecommerceapi.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record CartDto(UUID id, CustomerDto customer, List<ProductDto> products, double total, LocalDateTime createdAt, LocalDateTime updatedAt) {
}
