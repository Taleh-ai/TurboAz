package com.example.turboaz.dto.service;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Miles {
    BigDecimal minMile = BigDecimal.ZERO;
    BigDecimal maxMile = BigDecimal.valueOf(Integer.MAX_VALUE);
}
