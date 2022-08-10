package com.veiculoprodutorconsumidor.sensor.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VeiculoDTO {
    
    @NotNull
    private LocalDateTime dataLeitura;
    
    @NotNull
    private Double velocidade;
    
    @NotNull
    private Integer rotacao;
    
    @NotNull
    private Boolean sensorFrenagem;
}
