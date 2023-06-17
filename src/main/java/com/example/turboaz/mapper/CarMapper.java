package com.example.turboaz.mapper;


import com.example.turboaz.dto.CarDTO;
import com.example.turboaz.entity.CarEntity;
import lombok.RequiredArgsConstructor;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@Mapper
public class CarMapper {
    public CarDTO toMainDTO(CarEntity entity) {
        CarDTO dto = new CarDTO();
        dto.setCity(entity.getCity());
        dto.setMark(entity.getMark());
        dto.setCurrency(entity.getCurrency());
        dto.setMiles(entity.getMiles());
        dto.setMotor(entity.getMotor());
        dto.setElanNo(entity.getElanNo());
        dto.setYear(entity.getYear());
        dto.setPrice(entity.getPrice());
        dto.setMilesCurrency(entity.getMilesCurrency());
        dto.setUploadDate(entity.getUploadDate());
        return dto;
    }

    public List<CarDTO> toDTOList(List<CarEntity> entities) {
        CarMapper mapper = new CarMapper(); // Create a new instance of CarMapper
        return entities.stream().map(mapper::toMainDTO).collect(Collectors.toList());
    }

    public List<CarEntity> fromDTOList(List<CarDTO> dtoList) {
        CarMapper mapper = new CarMapper(); // Create a new instance of CarMapper
        return dtoList.stream().map(mapper::fromDTO).collect(Collectors.toList());
    }

    public CarEntity fromDTO(CarDTO dto) {
        CarEntity entity = new CarEntity();
        entity.setCity(dto.getCity());
        entity.setMark(dto.getMark());
        entity.setCurrency(dto.getCurrency());
        entity.setMiles(dto.getMiles());
        entity.setMotor(dto.getMotor());
        entity.setElanNo(dto.getElanNo());
        entity.setYear(dto.getYear());
        entity.setPrice(dto.getPrice());
        entity.setMilesCurrency(dto.getMilesCurrency());
        entity.setUploadDate(dto.getUploadDate());
        return entity;
    }
}



