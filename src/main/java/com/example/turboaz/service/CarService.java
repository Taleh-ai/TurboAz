package com.example.turboaz.service;

import com.example.turboaz.dto.CarDTO;
import com.example.turboaz.dto.service.Buraxilis;
import com.example.turboaz.dto.service.Miles;
import com.example.turboaz.dto.service.Price;

import com.example.turboaz.mapper.CarMapper;
import com.example.turboaz.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {
    private final CarMapper mapper;
    private final CarRepository repository;

    public List<CarDTO> getCarByFilter(Buraxilis year, Price price, Miles mile){
      return mapper.toDTOList(repository.findCarEntitiesByPriceBetweenAndMilesBetweenoAndYearBetween
               (price.getMinPrice(),price.getMaxPrice(),mile.getMinMile(),mile.getMaxMile(),year.getFirstDate(),year.getLastDate())) ;
    }
}
