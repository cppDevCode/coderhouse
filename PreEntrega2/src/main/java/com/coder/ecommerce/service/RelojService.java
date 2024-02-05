package com.coder.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class RelojService {
    @Autowired
    private RelojRestApi relojRestApi;
    private String  dato;
    public String getDato(){
        this.dato = relojRestApi.getDato();
        System.out.println(dato);
        return this.dato;
    }


}
