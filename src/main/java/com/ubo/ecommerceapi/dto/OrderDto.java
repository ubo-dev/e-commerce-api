package com.ubo.ecommerceapi.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record OrderDto(UUID id, List<ProductDto> products, LocalDateTime createdAt, LocalDateTime updatedAt) {
}
