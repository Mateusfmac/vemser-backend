package com.chatkafka.service;

import com.chatkafka.dto.MensagemDTO;
import com.chatkafka.enums.Enviar;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProducerService {
    
    private final KafkaTemplate<String, String> kafkaTemplate;
    
    private final ObjectMapper objectMapper;
    
    @Value("${kafka.user}")
    private String Eu;
    
    public void enviarMensagemObj(MensagemDTO mensagemDTO, List<Enviar> listaEnvio) throws JsonProcessingException {
        mensagemDTO.setUsuario(Eu);
        mensagemDTO.setDataCriacao(LocalDateTime.now());
        String enviar = objectMapper.writeValueAsString(mensagemDTO);
        listaEnvio.forEach(lista ->
                        enviarMensagem(enviar, lista.getChat()));
    }
    
    private void enviarMensagem(String mensagem, String topico) {
        MessageBuilder<String> stringMessageBuilder = MessageBuilder.withPayload(mensagem)
                .setHeader(KafkaHeaders.TOPIC, topico)
                .setHeader(KafkaHeaders.MESSAGE_KEY, UUID.randomUUID().toString());
        Message<String> stringMessage = stringMessageBuilder
                .build();
        
        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(stringMessage);
        future.addCallback(new ListenableFutureCallback<>() {
            @Override
            public void onSuccess(SendResult result) {
                log.info(" Log enviado para o kafka com o texto: {} ", mensagem);
            }
            
            @Override
            public void onFailure(Throwable ex) {
                log.error(" Erro ao publicar duvida no kafka com a mensagem: {}", mensagem, ex);
            }
        });
    }
}
