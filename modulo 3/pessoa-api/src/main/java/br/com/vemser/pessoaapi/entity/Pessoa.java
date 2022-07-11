package br.com.vemser.pessoaapi.entity;

import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter // ou @Data
@Setter // ou @Data
@ToString // ou @Data
public class Pessoa {
    private Integer idPessoa;
    
    @NotNull
    @NotBlank(message = "insira o nome")
    private String nome;
    
    @NotNull
    @Past(message = "insira uma data válida")
    private LocalDate dataNascimento;
    
    @CPF(message = "insira um cpf válido")
    @NotBlank
    private String cpf;
}

