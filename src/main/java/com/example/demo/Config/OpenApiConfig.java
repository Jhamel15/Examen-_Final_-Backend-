package com.example.demo.Config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {

        return new OpenAPI()
                .info(new Info()
                        .title("Sistema Web - Colegio Carlos Medinaceli")
                        .version("1.0")
                        .description("""
                                Examen Final
                                SIS-404 - Tecnologías Emergentes  2026

                                Desarrollado por:
                                JHAMEL JAVIER PINTO UBALDES
                                """));
    }
}