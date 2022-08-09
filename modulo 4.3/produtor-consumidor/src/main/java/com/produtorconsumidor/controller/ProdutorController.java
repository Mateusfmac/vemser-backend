package com.produtorconsumidor.controller;

import com.produtorconsumidor.service.ProdutorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/kafka")
public class ProdutorController {
    
    private final ProdutorService produtorService;
    
    @PostMapping("/enviar")
    public void enviarMensagemTopico(String mensagem) {
        produtorService.enviarMensagemKafka(mensagem);
    }
}
