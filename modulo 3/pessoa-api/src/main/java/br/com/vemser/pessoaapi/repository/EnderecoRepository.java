package br.com.vemser.pessoaapi.repository;

import br.com.vemser.pessoaapi.entity.Endereco;
import br.com.vemser.pessoaapi.entity.TipoEndereco;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class EnderecoRepository {
    public static List<Endereco> enderecoLista = new ArrayList<>();
    private final AtomicInteger COUNT = new AtomicInteger();
    private PessoaRepository pessoaRepository;
    
    
    public EnderecoRepository() {
        pessoaRepository = new PessoaRepository();
        enderecoLista.add(new Endereco(COUNT.incrementAndGet(), 5, TipoEndereco.COMERCIAL, "Rua das Galinhas", 222, "casa", "13258761", "Cabritina", "Acre", "Brasil"));
        enderecoLista.add(new Endereco(COUNT.incrementAndGet(), 4, TipoEndereco.RESIDENCIAL, "Padre Longino", 8962, "casa", "25896321", "Caninana", "Sao Paulo", "Brasil"));
        enderecoLista.add(new Endereco(COUNT.incrementAndGet(), 3, TipoEndereco.RESIDENCIAL, "Rua Ernestina Sebastiana", 129, "casa", "13889361", "Mongua", "Rio de Janeiro", "Brasil"));
        enderecoLista.add(new Endereco(COUNT.incrementAndGet(), 2, TipoEndereco.COMERCIAL, "Rua Porto Lorem", 981, "casa", "98765432", "Gurupi", "Santa Catarina", "Brasil"));
        enderecoLista.add(new Endereco(COUNT.incrementAndGet(), 1, TipoEndereco.RESIDENCIAL, "Parise", 539, "casa", "45269874", "São Luis", "Ceara", "Brasil"));
    }
    
    public Endereco criar(Endereco endereco) {
        endereco.setIdEndereco(COUNT.incrementAndGet());
        enderecoLista.add(endereco);
        return endereco;
    }
    
    public List<Endereco> listar() {
        return enderecoLista;
    }
    
    public void delete(Integer id) throws Exception {
        Endereco endereco = enderecoLista.stream()
                .filter(end -> end.getIdEndereco().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Id nao encontrado"));
        enderecoLista.remove(endereco);
    }
}
