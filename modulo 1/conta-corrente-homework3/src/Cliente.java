import java.util.ArrayList;

public class Cliente {
    private String nome;
    private String cpf;
    private ArrayList<Contato> contatos = new ArrayList<>();
    private ArrayList<Endereco> enderecos = new ArrayList<>();
    
    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }
    
    public void imprimirContatos() {
        if (contatos != null) {
            for (Contato contato : contatos) {
                if (contato != null) {
                    contato.imprimirContato();
                }
            }
        }
    }
    
    public void imprimirEnderecos() {
        if (enderecos != null) {
            for (Endereco endereco : enderecos) {
                if (endereco != null) {
                    endereco.imprimirEndereco();
                }
            }
        }
    }
    
    public void imprimirCliente() {
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + cpf);
        imprimirEnderecos();
        imprimirContatos();
    }
    
    public String toString() {
        return "Nome: " + nome + "\nCPF: " + cpf;
    }
    
    public void setContatos(ArrayList<Contato> contatos) {
        this.contatos = contatos;
    }
    
    public ArrayList<Contato> getContatos() {
        return contatos;
    }
    
    public ArrayList<Endereco> getEnderecos() {
        return enderecos;
    }
    
    public void setEnderecos(ArrayList<Endereco> enderecos) {
        this.enderecos = enderecos;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getCpf() {
        return cpf;
    }
    
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
