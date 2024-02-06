package com.coder.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class RelojService {
    @Autowired
    private RelojRestApi relojRestApi;

    public Map<String,List<String>> getHora(){
        return relojRestApi.getHora();
    }
}
