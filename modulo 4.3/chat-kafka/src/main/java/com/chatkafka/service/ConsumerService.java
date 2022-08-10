package com.chatkafka.service;

import com.chatkafka.dto.MensagemDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
@Slf4j
public class ConsumerService {
    
    private final ObjectMapper objectMapper;
    
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    
    @KafkaListener(
            topics = "chat-geral",
            groupId = "${kafka.user}",
            containerFactory = "listenerContainerFactory",
            clientIdPrefix = "chat-geral")
    public void consumirChatGeral(@Payload String mensagem,
                                  @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
                                  @Header(KafkaHeaders.OFFSET) Long offset) throws JsonProcessingException {
        MensagemDTO mensagemDTO = objectMapper.readValue(mensagem, MensagemDTO.class);
        log.info(mensagemDTO.getDataCriacao().format(formatter) + " [ " + mensagemDTO.getUsuario() + " ]: " + mensagemDTO.getMensagem());
    }
    
    @KafkaListener(
            topics = "chat-machado",
            groupId = "${kafka.user}",
            containerFactory = "listenerContainerFactory",
            clientIdPrefix = "dm")
    public void consumirPrivado(@Payload String mensagem,
                                  @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
                                  @Header(KafkaHeaders.OFFSET) Long offset) throws JsonProcessingException {
        MensagemDTO mensagemDTO = objectMapper.readValue(mensagem, MensagemDTO.class);
        log.info(mensagemDTO.getDataCriacao().format(formatter) + " [" + mensagemDTO.getUsuario() + "] " + "(privada): " + mensagemDTO.getMensagem());
    }
}
