package com.example.turboaz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarDTO {
    String mark;
    BigDecimal price;
    String currency;
    int year;
    double motor;
    int miles;
    String  milesCurrency;
    String City;
    LocalDate uploadDate;
    String elanNo;
}
