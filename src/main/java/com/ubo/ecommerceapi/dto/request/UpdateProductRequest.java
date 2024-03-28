package com.ubo.ecommerceapi.dto.request;

import jakarta.validation.constraints.NotNull;

public record UpdateProductRequest(@NotNull String name,
                                   @NotNull double price,
                                   @NotNull int quantity,
                                   @NotNull String description) {
}
