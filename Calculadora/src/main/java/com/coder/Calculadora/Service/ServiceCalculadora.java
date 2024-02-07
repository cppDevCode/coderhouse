package com.coder.Calculadora.Service;

import com.coder.Calculadora.Model.ModelOperatoria;
import org.springframework.stereotype.Service;

@Service
public class ServiceCalculadora {
    public ModelOperatoria suma(float n1, float n2){
        ModelOperatoria auxiliar = new ModelOperatoria(n1,n2);
        auxiliar.setResultado(n1+n2);
        return auxiliar;
    }
}
