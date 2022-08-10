package com.veiculoprodutorconsumidor.sensor.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.veiculoprodutorconsumidor.sensor.dto.VeiculoDTO;
import com.veiculoprodutorconsumidor.sensor.repository.VeiculoRepository;
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

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProducerService {
    
    private final KafkaTemplate<String, String> kafkaTemplate;
    
    private final ObjectMapper objectMapper;
    
    private final VeiculoRepository veiculoRepository;
    
    @Value("${kafka.topic-sensor}")
    private String topicoSensor;
    
    public void enviarMensagemVeiculoObjeto(VeiculoDTO veiculoDTO) throws JsonProcessingException {
        String veiculoObjString = objectMapper.writeValueAsString(veiculoDTO);
        enviarMensagem(veiculoObjString, topicoSensor);
    }
    
    private void enviarMensagem(String mensagem, String topicoSensor) {
        MessageBuilder<String> stringMessageBuilder = MessageBuilder.withPayload(mensagem)
                .setHeader(KafkaHeaders.TOPIC, topicoSensor)
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
    
    public List<VeiculoDTO> listDadosSensor() {
        return veiculoRepository.findAll()
                .stream()
                .map(veiculoEntity -> {
                    VeiculoDTO veiculoDTO = objectMapper.convertValue(veiculoEntity, VeiculoDTO.class);
                    return veiculoDTO;
                }).toList();
    }
    
    public Double mediaVelocidade() {
        return veiculoRepository.mediaVelocidade();
    }
    
    public Double mediaRotacao() {
        return veiculoRepository.mediaRotacao();
    }
}
