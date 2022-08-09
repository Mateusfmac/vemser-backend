package com.produtorconsumidor.config;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConsumerConfig {
    
    private static final String EARLIEST = "earliest"; //ler todas as mensagens
    private static final String LATEST = "latest"; //ler somente as ultimas mensagens
    
    @Value(value = "${kafka.bootstrap-servers}")
    private String bootstrapAddress; //endereco da porta
    
    @Value("${kafka.client-id}")
    private String clientId; //consumidor
    
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String> listenerContainerFactory(){ //cria as porp para consumir o servico
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress); //localhost:9092
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.CLIENT_ID_CONFIG, clientId); //pro kafka identificar o leitor pelo id
        props.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, 10); //numero leitura de registros por vez
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, EARLIEST);
        
        DefaultKafkaConsumerFactory<Object, Object> kafkaConsumerFactory = new DefaultKafkaConsumerFactory<>(props); //cria uma nova fabrica de leitura
        
        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(kafkaConsumerFactory);
        
        return factory;
    }
}
