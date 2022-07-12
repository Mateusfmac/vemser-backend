package br.com.vemser.pessoaapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PessoaCreateDTO {
    @NotNull
    @NotBlank(message = "insira o nome")
    private String nome;
    
    @NotNull
    @Past(message = "insira uma data válida")
    private LocalDate dataNascimento;
    
    @CPF(message = "insira um cpf válido")
    @NotBlank
    private String cpf;
    private String email;
}
