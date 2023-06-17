package com.example.turboaz.repository;

import com.example.turboaz.dto.service.Buraxilis;
import com.example.turboaz.dto.service.Miles;
import com.example.turboaz.dto.service.Price;
import com.example.turboaz.entity.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.Year;
import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<CarEntity,Long> {

    CarEntity findByElanNo(String elan);
    @Query(value = "SELECT * FROM cars " +
            "WHERE (qiymət BETWEEN :minPrice AND :maxPrice) " +
            "And (yuruyus BETWEEN :minMiles AND :maxMiles) " +
            "And (buraxilis_ili BETWEEN :minYear AND :maxYear)",
            nativeQuery = true)
    List<CarEntity> findCarEntitiesByPriceBetweenAndMilesBetweenoAndYearBetween
            (BigDecimal minPrice,BigDecimal maxPrice,BigDecimal minMiles,BigDecimal maxMiles,int minYear,int maxYear
                                                                              );
}
