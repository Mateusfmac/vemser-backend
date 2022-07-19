package br.com.vemser.pessoaapi.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "ENDERECO_PESSOA")
public class ContatoEntity {
    //validacoes nos DTO
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CONTATO_SEQ")
    @SequenceGenerator(name = "CONTATO_SEQ", sequenceName = "SEQ_CONTATO", allocationSize = 1)
    @Column(name = "ID_CONTATO")
    private Integer idContato;
    @Column(name = "ID_PESSOA")
    private Integer idPessoa;
    @Column(name = "TIPO")
    private String tipoContato;
    @Column(name = "NUMERO")
    private String numero;
    @Column(name = "DESCRICAO")
    private String descricao;
}
