package com.example.turboaz.service;

import com.example.turboaz.dto.CarDTO;
import com.example.turboaz.entity.CarEntity;
import com.example.turboaz.mapper.CarMapper;
import com.example.turboaz.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Service
@RequiredArgsConstructor
@Slf4j
public class ScrapingService {

    private final CarMapper mapper;
    private final CarRepository carRepository;

    @Scheduled(fixedRate = 3000)
    public void getData() throws IOException {

        int page = 1;

        while(page<60){
            Document pageTest =  Jsoup.connect("https://turbo.az/autos?page="+page).get();
            Document doc = Jsoup.parse(String.valueOf(pageTest));

            Elements products = doc.select(".products-i.vipped");
            if (products.isEmpty()) {
                log.info("Scrap end");
            } else {
                log.info("Scrap begin");
                for (Element items : products) {
                   String elan_id = items.selectFirst("a.products-i__link").attr("href");
                    CarEntity existingCar = carRepository.findByElanNo(elan_id);

                    if(existingCar== null) {
                        ///Get tag values
                        Element priceElement = items.selectFirst(".product-price");
                        log.info(String.valueOf(priceElement));
                        String priceText = priceElement.ownText().replaceAll("\\s+", "");
                        Element attributesElement = items.selectFirst(".products-i__attributes");
                        log.info(String.valueOf(attributesElement));
                        String attributesText = attributesElement.text();
                        String[] attributes = attributesText.split(",\\s");
                        String dateCityElement = items.selectFirst(".products-i__datetime").text();
                        String[] parts = dateCityElement.split(", ");
                        String marka = items.selectFirst(".products-i__name.products-i__bottom-text").text();


                        ///Assign tag values
                        BigDecimal price = BigDecimal.valueOf(Integer.parseInt(priceText));
                        String currency = priceElement.selectFirst("span").text();
                        int year = Integer.parseInt(attributes[0]);
                        double motor = Double.parseDouble(attributes[1].replaceAll("[^\\d.]", ""));
                        int miles = Integer.parseInt(attributes[2].replaceAll("[^\\d.]", ""));
                        String  milesCurrency =attributes[2].replaceAll("[\\d.,]", "").trim();
                        String city = parts[0];
                        String datePart = parts[1];
                        LocalDate date;
                        if (datePart.contains("bugün")) {
                            date = LocalDate.now();
                        } else if (datePart.contains("dünən")) {
                            date = LocalDate.now().minusDays(1);
                        } else {
                            // Parse the date using a custom format if it's in a different format
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
                            date = LocalDate.parse(datePart, formatter);
                        }
                        CarDTO car = new CarDTO(marka,price,currency,year,motor,miles,milesCurrency,city,date,elan_id);
                        log.info("Scrap data "+car.toString());
                        CarEntity entity = mapper.fromDTO(car);
                        carRepository.save(entity);
                    }
                }


            }
            page++;
        }
    }


}
