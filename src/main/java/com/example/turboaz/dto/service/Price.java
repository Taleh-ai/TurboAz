package com.example.turboaz.dto.service;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Price {
    BigDecimal minPrice = BigDecimal.ZERO;
    BigDecimal maxPrice = BigDecimal.valueOf(Integer.MAX_VALUE);
}
