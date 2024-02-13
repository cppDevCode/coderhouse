package com.coder.ecommerce.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigSwagger {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info().title("Ventas APIRest")
                        .description("APIRest Ventas")
                        .contact(new Contact()
                                .name("Alejandro Baldres")
                                .email("alejandro.baldres@gmail.com")
                                .url(""))
                        .version("1.0"));
    }
}