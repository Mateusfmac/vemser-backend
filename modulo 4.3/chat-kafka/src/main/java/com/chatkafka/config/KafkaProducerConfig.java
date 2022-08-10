package com.chatkafka.config;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaProducerConfig {
    
    @Value("${kafka.bootstrap-servers}")
    private String server;
    
    @Bean
    public KafkaTemplate<String, String> configKafka() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, server); //porta servidor
        configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class); // chave da mensagem
        configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class); // valor mensagem
        
        DefaultKafkaProducerFactory<String, String> kafkaProducerFactory =
                new DefaultKafkaProducerFactory<>(configs); //cria uma nova fabrica de escrita
        
        return new KafkaTemplate<>(kafkaProducerFactory);
    }
}
