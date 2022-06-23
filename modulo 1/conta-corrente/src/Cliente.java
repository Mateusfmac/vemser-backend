public class Cliente {
    String nome;
    String cpf;
    Contato[] contatos = new Contato[2];
    Endereco[] enderecos = new Endereco[2];
    
    void imprimirContatos() {
        for (int i = 0; i < contatos.length; i++) {
            if (contatos[i] != null) {
                contatos[i].imprimirContato();
            }
        }
    }
    
    void imprimirEnderecos() {
        for (int i = 0; i < enderecos.length; i++) {
            if (enderecos[i] != null) {
                enderecos[i].imprimirEndereco();
            }
        }
    }
    
    void imprimirCliente() {
        System.out.printf("Nome: %s \nCPF: %s", nome, cpf);
        imprimirEnderecos();
        imprimirContatos();
    }
}
