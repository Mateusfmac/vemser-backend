package com.produtorconsumidor.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ConsumidorService {
    
    @KafkaListener(
            topics = "${kafka.topic}", // mateus-primeiro-topico
            groupId = "group1",
            containerFactory = "listenerContainerFactory", //nome da fabrica que esta lendo
            clientIdPrefix = "primeiroTopico")
    public void consumir(@Payload String mensagem, //payload da mensagem criada
                         @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key, //chave que recebe
                         @Header(KafkaHeaders.OFFSET) Long offset){ //offset da mensagem
        log.info("####{consume} offset -> '{}' key -> '{}' -> Consumed Object message -> '{}'  ", offset, key, mensagem);
    }
}
