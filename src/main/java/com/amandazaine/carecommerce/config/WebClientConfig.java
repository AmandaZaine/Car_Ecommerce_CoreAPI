package com.amandazaine.carecommerce.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

//Configura o WebClient para que seja injetado
//Define que a classe precisa ser lida quando a aplicação estiver inicializando
@Configuration
public class WebClientConfig {

    @Bean //Crie um bean configurado que pode ser reutilizado em toda a aplicação
    public WebClient createWebClient(WebClient.Builder builder) {
        return builder
                .baseUrl("http://localhost:8080")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }
}
