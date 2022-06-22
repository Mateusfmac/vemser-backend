public class Cliente {
    String nome;
    String cpf;
    Contato[] contatos = new Contato[2];
    Endereco[] enderecos = new Endereco[2];
    
    
    void imprimirCliente() {
        System.out.printf("Nome: %s \nCPF: %s", nome, cpf);
    }
    
    void imprimirContatos() {
    
    }
    
    void imprimirEnderecos() {
    }
}
