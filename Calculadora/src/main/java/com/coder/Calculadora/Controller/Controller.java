package com.coder.Calculadora.Controller;

import com.coder.Calculadora.Model.ModelOperatoria;
import com.coder.Calculadora.Service.ServiceCalculadora;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/calculadora")
public class Controller {

    @Autowired
    private ServiceCalculadora calculadora;
    @GetMapping("/suma/n1={numero1}&n2={numero2}")
    public ModelOperatoria suma(@PathVariable(name = "numero1") float numero1, @PathVariable(name = "numero2") float numero2) {
        return this.calculadora.suma(numero1,numero2);
    }
}
