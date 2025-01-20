package com.amandazaine.carecommerce.message;

import com.amandazaine.carecommerce.dto.CarPostDTO;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Configuration
public class KafkaProducerConfiguration {

    @Value("${spring.kafka.bootstrap-servers}")  //Busca no arquivo application.properties a url do servidor onde o cluster do Kafka está rodando
    private String bootstrapServer;

    @Bean
    //Método de configuração do Kafka que será gerenciado pelo Spring ao se inicializar a aplicação
    //Realiza a conexão com o cluster Kafka e define que a mensagem produzida terá como chave uma String e como valor um CarPostDTO
    public ProducerFactory<String, CarPostDTO> userProducerFactory() {
        Map<String, Object> properties = new HashMap<>();

        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);

        //Define que nenhum JSON será enviado como header, iremos enviar apenas o "body"
        properties.put(JsonSerializer.ADD_TYPE_INFO_HEADERS, false);

        //Define o tipo-da-chave da mensagem que será produzida
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        //Define o tipo-do-valor da mensagem que será produzida. Aqui o objeto será enviado como JSON para o Kafka
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class.getName());

        //DefaultKafkaProducerFactory é um componente Spring que encapsula a criação de instâncias do KafkaProducer e gerencia sua configuração
        return new DefaultKafkaProducerFactory<>(properties);
    }

    @Bean
    //KafkaTemplate é uma abstração de alto nível fornecida pelo Spring para facilitar o envio de mensagens à tópicos do Kafka
    public KafkaTemplate<String, CarPostDTO> userKafkaTemplate() {
        return new KafkaTemplate<>(userProducerFactory());
    }
}
