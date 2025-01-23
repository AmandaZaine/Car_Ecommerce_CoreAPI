package com.amandazaine.carecommerce.client;

import com.amandazaine.carecommerce.dto.CarPostDTO;
import com.amandazaine.carecommerce.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Objects;

//O "Client" é um "consumidor" de APIs
@Component
public class CarPostClient {
    private final String USER_URI = "/user";
    private final String POSTS_URI = "/sales";

    //WebClient é usado para chamadas HTTP, tanto síncronas quanto assíncronas
    @Autowired
    private WebClient webClient;

    public List<CarPostDTO> getAllCarPost() {
        CarPostDTO[] response = webClient.get()
                                    .uri(POSTS_URI + "/cars") // Construa a URL
                                    .retrieve() // Executa a requisição
                                    .bodyToMono(CarPostDTO[].class) // Define o tipo esperado da resposta
                                    .block(); // Converte chamadas reativas para síncronas

        return List.of(Objects.requireNonNull(response));
    }

    public void updateCarPost(CarPostDTO carPostDTO, String id) {
        webClient.put()
                .uri(POSTS_URI + "/car/{id}", id) // Define o URI completo
                .bodyValue(carPostDTO) // Define o corpo da requisição
                .retrieve() // Executa a requisição
                .toBodilessEntity() // Indica que não esperamos um corpo na resposta
                //.exchangeToMono(clientResponse -> Mono.empty())  // Também Indica que não esperamos um corpo na resposta
                .block(); // Bloqueia para executar a operação de forma síncrona
    }

    public void deleteCarPost(String id) {
        webClient.delete()
                .uri(POSTS_URI + "/car/{id}", id) // Define o URI com o postId
                .retrieve() // Executa a requisição e verifica o status
                .toBodilessEntity() // Indica que a resposta não terá um corpo
                .block(); // Bloqueia para executar a operação de forma síncrona
    }

    public void createUser(UserDTO newUser) {
        webClient.post()
                .uri(USER_URI) // Define o URI
                .bodyValue(newUser) // Adiciona o corpo da requisição
                .retrieve() // Realiza a requisição
                .bodyToMono(UserDTO.class) // Define o tipo de resposta esperada
                .block(); // Bloqueia para obter a resposta síncrona
    }
}
