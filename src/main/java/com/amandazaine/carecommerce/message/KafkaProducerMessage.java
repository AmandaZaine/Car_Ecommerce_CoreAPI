package com.amandazaine.carecommerce.message;

import com.amandazaine.carecommerce.dto.CarPostDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducerMessage {

    @Autowired //Classe própria do Kafka que possibilita enviar mensagens para os tópicos do Kafka
    private KafkaTemplate<String, CarPostDTO> kafkaTemplate;

    private final String KAFKA_TOPIC = "car-post-topic";

    //Metodo que envia as mensagens para dentro do tópico do Kafka
    public void sendMessage(CarPostDTO carPostDTO) {
        kafkaTemplate.send(KAFKA_TOPIC, carPostDTO);
    }
}
