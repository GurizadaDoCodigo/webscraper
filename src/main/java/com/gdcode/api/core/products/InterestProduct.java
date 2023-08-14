package com.gdcode.api.core.products;

import org.springframework.data.annotation.Id;

import lombok.Builder;

@Builder
public record InterestProduct(@Id Long id, String query) {}
