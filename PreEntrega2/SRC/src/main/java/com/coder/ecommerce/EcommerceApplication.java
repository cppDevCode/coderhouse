package com.coder.ecommerce;

import com.coder.ecommerce.models.Cliente;
import com.coder.ecommerce.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EcommerceApplication {


	public static void main(String[] args) {

		System.out.println("Segunda Pre-Entrega de Trabajo Final");
		System.out.println("Curso de Programación en JAVA");
		System.out.println("Comision: 50280");
		System.out.println("Estudiante: Alejandro Lucas Baldres");
		SpringApplication.run(EcommerceApplication.class, args);


	}

}
