package com.riwi.riwi.config;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@Configuration
@OpenAPIDefinition(
    info = @Info(
        title = "API para administracion de usuarios, encuestas y preguntas",
        version = "1.0",
        description = "API para probar conocimientos en API con Java"
    )
)
public class OpenApiConfig {

    
}