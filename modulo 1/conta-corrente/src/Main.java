public class Main {
    public static void main(String[] args) {
        //1o cliente
        ContaCorrente contaCorrente1 = new ContaCorrente();
        contaCorrente1.numeroConta = "054823";
        contaCorrente1.agencia = 1485;
        contaCorrente1.saldo = 700.00;
        contaCorrente1.chequeEspecial = 500.00;
        
        Cliente cliente1 = new Cliente();
        cliente1.nome = "Mario Nelson Nunes";
        cliente1.cpf = "324.258.390-62";
        
        Endereco endereco1 = new Endereco();
        endereco1.tipo = 1;
        endereco1.logradouro = "Rua Três";
        endereco1.numero = 745;
        endereco1.complemento = "Casa";
        endereco1.cep = "11081-220";
        endereco1.cidade = "Santos";
        endereco1.estado = "Sao Paulo";
        endereco1.pais = "Brasil";
        
        Contato contato1 = new Contato();
        contato1.descricao = "Oi?";
        contato1.telefone = "(13) 99703-2245";
        contato1.tipo = 1;
        
        //-----------------------------------------------------//
        
            //2o Cliente
        ContaCorrente contaCorrente2 = new ContaCorrente();
        contaCorrente2.numeroConta = "786325";
        contaCorrente2.agencia = 1586;
        contaCorrente2.saldo = 1000.00;
        contaCorrente2.chequeEspecial = 500.00;
    
        Cliente cliente2 = new Cliente();
        cliente2.nome = "Marcela Eloá Alves";
        cliente2.cpf = "988.185.030-49";
        
        Endereco endereco2 = new Endereco();
        endereco2.tipo = 1;
        endereco2.logradouro = "Rua Sao Marcelo";
        endereco2.numero = 867;
        endereco2.complemento = "Casa";
        endereco2.cep = "11081-110";
        endereco2.cidade = "Santos";
        endereco2.estado = "Sao Paulo";
        endereco2.pais = "Brasil";
        
        Contato contato2 = new Contato();
        contato2.descricao = "Oi?";
        contato2.telefone = "(13) 3942-4661";
        contato2.tipo = 1;
        
        //metodos
    
        cliente1.enderecos[0] = endereco1;
        cliente1.enderecos[1] = endereco1;
        cliente1.contatos[0] = contato1;
        cliente1.contatos[1] = contato1;
        cliente1.imprimirCliente();
        
        contaCorrente1.depositar(100.00);
        contaCorrente1.sacar(250.00);
        contaCorrente1.transferir(contaCorrente2, 500.00);
        contaCorrente1.imprimirContaCorrente();
    
        System.out.println("---------------------------------------------");
        
        System.out.println("------ Dados Destinatario ------");
        cliente2.imprimirCliente();
        contaCorrente2.imprimirContaCorrente();
    }
}
