package com.springboot.carbonapi.CarbonApi.controller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.carbonapi.CarbonApi.service.ServiceClass;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/emissions")
@RequiredArgsConstructor
public class ControllerClass {

    @Autowired
    private ServiceClass serviceClass;

    @GetMapping("/aqi")
    public Map<String, Object> getAqiForAllCities() {
        String[] cities = {"asanol", "jadavpur", "mangala", "talcher coalfields", "meelavittan", "Nagpur", "Guwahati", "Imphal", "Jabalpur"};
        return serviceClass.getAqiForCities(cities);
    }
}
