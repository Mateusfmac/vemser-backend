package com.chatkafka.controller;

import com.chatkafka.dto.MensagemDTO;
import com.chatkafka.enums.Enviar;
import com.chatkafka.service.ProducerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chat")
@RequiredArgsConstructor
public class ProducerController {
    
    private final ProducerService producerService;
    
    @PostMapping("/enviar-mensagem")
    public void enviar(@RequestBody MensagemDTO mensagemDTO, @RequestParam List<Enviar> listaEnvio) throws JsonProcessingException {
        producerService.enviarMensagemObj(mensagemDTO, listaEnvio);
    }
}
