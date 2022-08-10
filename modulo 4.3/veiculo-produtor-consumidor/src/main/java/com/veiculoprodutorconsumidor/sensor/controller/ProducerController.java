package com.veiculoprodutorconsumidor.sensor.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.veiculoprodutorconsumidor.sensor.dto.VeiculoDTO;
import com.veiculoprodutorconsumidor.sensor.service.ProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sensor")
@RequiredArgsConstructor
public class ProducerController {
    
    private final ProducerService producerService;
    
    @PostMapping("/enviar-dados-veiculo")
    public void enviarDadosSensor(@RequestBody VeiculoDTO veiculoDTO) throws JsonProcessingException {
        producerService.enviarMensagemVeiculoObjeto(veiculoDTO);
    }
    
    @GetMapping("/listar-dados-veiculo")
    public ResponseEntity<List<VeiculoDTO>> listarDadosSensor() {
        return new ResponseEntity<>(producerService.listDadosSensor(), HttpStatus.OK);
    }
    
    @GetMapping("/media-velocidade")
    public Double mediaVelocidade() {
        return producerService.mediaVelocidade();
    }
    
    @GetMapping("/media-rotacao")
    public Double mediaRotacao() {
        return producerService.mediaRotacao();
    }
}
