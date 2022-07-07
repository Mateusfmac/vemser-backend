package br.com.vemser.pessoaapi.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Component
public class PropertieReader {
    
    @Value("${ambiente}")
    private String ambiente;
    
    public String getAmbiente() {
        return ambiente;
    }
    
}
