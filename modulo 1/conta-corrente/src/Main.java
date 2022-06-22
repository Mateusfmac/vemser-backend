public class Main {
    public static void main(String[] args) {
        //1o cliente
        ContaCorrente contaCorrente1 = new ContaCorrente();
        contaCorrente1.numeroConta = "054823";
        contaCorrente1.agencia = 1485;
        contaCorrente1.saldo = 700.00;
        contaCorrente1.chequeEspecial = 500.00;
    
        Cliente cliente1 = new Cliente();
        cliente1.nome = "Mário Nelson Nunes";
        cliente1.cpf = "324.258.390-62";
        
        //ok
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
        
        //endereco1.imprimirEndereco();
        //contato1.imprimirContato();
        //contaCorrente1.imprimirContaCorrente();
        
        
            //2o Cliente
        ContaCorrente contaCorrente2 = new ContaCorrente();
        contaCorrente2.numeroConta = "786325";
        contaCorrente2.agencia = 1586;
        contaCorrente2.saldo = 1000.00;
        contaCorrente2.chequeEspecial = 500.00;
    
        Cliente cliente2 = new Cliente();
        cliente2.nome = "Marcela Eloá Alves";
        cliente2.cpf = "988.185.030-49";
        
        //ok
        Endereco endereco2 = new Endereco();
        endereco2.tipo = 1;
        endereco2.logradouro = "Rua Sao Marcelo";
        endereco2.numero = 867;
        endereco2.complemento = "Casa";
        endereco2.cep = "11081-110";
        endereco2.cidade = "Santos";
        endereco2.estado = "Sao Paulo";
        endereco2.pais = "Brasil";
        // metodo imprimir endereco
        
        
        //ok
        Contato contato2 = new Contato();
        contato2.descricao = "Oi?";
        contato2.telefone = "(13) 3942-4661";
        contato2.tipo = 1;
        
        contaCorrente1.imprimirContaCorrente();
        
        contaCorrente1.sacar(100.00);
        contaCorrente1.imprimirContaCorrente();
        
        contaCorrente1.depositar(150.00);
        contaCorrente1.imprimirContaCorrente();
        
        contaCorrente1.transferir(contaCorrente2, 100.00);
        System.out.println("Saldo atualizado");
        contaCorrente1.imprimirContaCorrente();
    
        System.out.println("------ Saldo destinatario");
        contaCorrente2.imprimirContaCorrente();
    }
}
