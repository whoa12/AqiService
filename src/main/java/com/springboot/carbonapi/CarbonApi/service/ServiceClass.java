package com.springboot.carbonapi.CarbonApi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class ServiceClass {

    @Value("${api.baseUrl}")
    private String baseUrl;

    @Value("${api.token}")
    private String token;

    private final RestTemplate restTemplate;

    @Autowired
    public ServiceClass(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Map<String, Object> getAqiForCities(String[] cities) {
        Map<String, Object> cityAqiMap = new HashMap<>();

        for (String city : cities) {
            String url = baseUrl + city + "/?token=" + token;
            try {
                String response = restTemplate.getForObject(url, String.class);
                cityAqiMap.put(city, response);  
            } catch (Exception e) {
                cityAqiMap.put(city, "Error fetching AQI for " + city);  // Handle errors
            }
        }

        return cityAqiMap;
    }
}
