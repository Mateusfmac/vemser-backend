package com.veiculoprodutorconsumidor.sensor.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "dadosSensor")
public class VeiculoEntity {
    
    @Field(name = "dataLeitura")
    private LocalDateTime dataLeitura;
    
    @Field(name = "velocidade")
    private Double velocidade;
    
    @Field(name = "rotacao")
    private Integer rotacao;
    
    @Field(name = "sensorFrenagem")
    private Boolean sensorFrenagem;
}
