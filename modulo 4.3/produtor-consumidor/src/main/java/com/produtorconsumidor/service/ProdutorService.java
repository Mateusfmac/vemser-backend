package com.produtorconsumidor.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProdutorService {
    
    private final KafkaTemplate<String, String> kafkaTemplate;
    
    @Value("${kafka.topic}")
    private String topico;
    
    public void enviarMensagemKafka(String mensagem) { //builda a mensagem
        MessageBuilder<String> messageBuilder = MessageBuilder.withPayload(mensagem)
                        .setHeader(KafkaHeaders.TOPIC, topico)
                        .setHeader(KafkaHeaders.MESSAGE_KEY, UUID.randomUUID().toString());
        Message<String> stringMessage = messageBuilder.build();
        
        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(stringMessage);
        future.addCallback(new ListenableFutureCallback<>() { //callback para verificar se deu certo ou errado o envio da mensagem
            @Override
            public void onSuccess(SendResult result) {
                log.info("Enviado para o Kafka o seguinte texto: {} ", mensagem);
            }
            
            @Override
            public void onFailure(Throwable ex) {
                log.error("Erro ao publicar no Kafka a mensagem: {} ", mensagem, ex);
            }
        });
    }
}
