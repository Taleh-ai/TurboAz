package com.example.turboaz.controller;

import com.example.turboaz.dto.CarDTO;
import com.example.turboaz.dto.service.Buraxilis;
import com.example.turboaz.dto.service.Miles;
import com.example.turboaz.dto.service.Price;
import com.example.turboaz.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/cars")
public class CarController {
    private final CarService service;


    @GetMapping("/filter")
    public List<CarDTO> getCarByFilter(@PathVariable Buraxilis year,@PathVariable  Price price,@PathVariable  Miles mile){
     return   service.getCarByFilter(year, price, mile);
    }
}
