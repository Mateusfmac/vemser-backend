package br.com.vemser.pessoaapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PessoaCreateDTO {
    @Schema(description = "Nome da Pessoa")
    @NotNull
    @NotBlank(message = "insira o nome")
    private String nome;
    
    @Schema(description = "Data no passado")
    @NotNull
    @Past(message = "insira uma data válida no formato aaaa-mm-dd")
    private LocalDate dataNascimento;
    
    @Schema(description = "CPF válido")
    @CPF(message = "insira um cpf válido")
    @NotBlank
    private String cpf;
    
    @Schema(description = "email da pessoa")
    private String email;
}
