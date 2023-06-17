package com.example.turboaz.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cars")
public class CarEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id ;
    @Column(name = "marka")
    String mark;

    @Column(name = "qiymət")
    BigDecimal price;

    @Column(name = "valyuta")
    String currency;

    @Column(name = "buraxilis_ili")
    int year;

    @Column(name = "muherrik_hecmi")
    double motor;
    @Column(name = "yuruyus")
    int miles;
    @Column(name = "yuruyus_vahidi")
    String  milesCurrency;

    @Column(name = "sheher")
    String City;

    @Column(name = "elan_tarixi")
    LocalDate uploadDate;

    @Column(name = "elan_no")
    String elanNo;

}
