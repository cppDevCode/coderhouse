package com.coder.ecommerce.service;

import com.coder.ecommerce.models.timeapi;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
public class RelojRestApi {
    public String getDato(){
        RestTemplate restTemplate = new RestTemplate();
        final String URL = "https://timeapi.io/api/Time/current/zone?timeZone=America/Argentina/Buenos_Aires";
        timeapi tiempo =  restTemplate.getForObject(URL, timeapi.class);
        return tiempo.getDateTime();
    }
}
