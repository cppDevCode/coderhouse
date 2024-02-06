package com.coder.ecommerce.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
public class RelojRestApi {
    public Map<String,List<String>> getHora(){
        RestTemplate restTemplate = new RestTemplate();
        final String URL = "https://www.worldtimeapi.org/api/timezone/America/Argentina/Buenos_Aires";

        return restTemplate.getForObject(URL, Map.class);
    }
}
