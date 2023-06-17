package com.example.turboaz.dto.service;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.Year;
import java.util.Date;

@Data
public class Buraxilis {

    int firstDate = 1990;


    int lastDate = Year.now().getValue();
}
