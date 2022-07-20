package br.com.vemser.pessoaapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "ENDERECO_PESSOA")
public class EnderecoEntity {
    //validacoes nos DTO
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ENDERECO_SEQ")
    @SequenceGenerator(name = "ENDERECO_SEQ", sequenceName = "seq_endereco_contato", allocationSize = 1)
    @Column(name = "ID_ENDERECO")
    private Integer idEndereco;
    
  //  private Integer idPessoa;
    
    @Column(name = "TIPO")
    private TipoEndereco tipo;
    @Column(name = "LOGRADOURO")
    private String logradouro;
    @Column(name = "NUMERO")
    private Integer numero;
    @Column(name = "COMPLEMENTO")
    private String complemento;
    @Column(name = "CEP")
    private String cep;
    @Column(name = "CIDADE")
    private String cidade;
    @Column(name = "ESTADO")
    private String estado;
    @Column(name = "PAIS")
    private String pais;
    
    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "PESSOA_X_PESSOA_ENDERECO",
    joinColumns = @JoinColumn(name = "ID_endereco"),
    inverseJoinColumns = @JoinColumn(name = "ID_PESSOA")
    )
    private Set<PessoaEntity> pessoas;
}
