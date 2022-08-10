package com.veiculoprodutorconsumidor.sensor.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.veiculoprodutorconsumidor.sensor.dto.VeiculoDTO;
import com.veiculoprodutorconsumidor.sensor.entity.VeiculoEntity;
import com.veiculoprodutorconsumidor.sensor.repository.VeiculoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ConsumerService {
    
    private final ObjectMapper objectMapper;
    
    private final VeiculoRepository veiculoRepository;
    
    @KafkaListener(
            topics = "${kafka.topic-sensor}",
            groupId = "group1",
            containerFactory = "listenerContainerFactory",
            clientIdPrefix = "sensor")
    public void consumirSensor(@Payload String mensagem,
                              @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
                              @Header(KafkaHeaders.OFFSET) Long offset) throws JsonProcessingException {
        VeiculoDTO veiculoDTO = objectMapper.readValue(mensagem, VeiculoDTO.class);
        VeiculoEntity veiculoEntity = objectMapper.convertValue(veiculoDTO, VeiculoEntity.class);
        veiculoRepository.save(veiculoEntity);
        log.info("####{consume} offset -> '{}' key -> '{}' -> Consumed Object message -> '{}'  ", offset, key, veiculoDTO);
        
    }
}
