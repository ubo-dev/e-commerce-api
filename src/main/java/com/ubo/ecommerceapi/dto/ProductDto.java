package com.ubo.ecommerceapi.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public record ProductDto(UUID id, String name, double price, int quantity, String description, LocalDateTime createdAt, LocalDateTime updatedAt) {
}
