package com.ubo.ecommerceapi.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record OrderDto(UUID id, CustomerDto customer, LocalDateTime createdAt, LocalDateTime updatedAt) {
}
