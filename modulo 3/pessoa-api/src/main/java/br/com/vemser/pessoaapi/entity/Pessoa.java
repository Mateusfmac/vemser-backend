package br.com.vemser.pessoaapi.entity;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter // ou @Data
@Setter // ou @Data
@ToString // ou @Data
public class Pessoa {
    //validacoes nos DTO
    private Integer idPessoa;
    private String nome;
    private LocalDate dataNascimento;
    private String cpf;
    private String email;
}

