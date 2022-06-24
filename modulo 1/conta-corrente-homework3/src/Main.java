public class Main {
    public static void main(String[] args) {
        Contato contato1 = new Contato(1,"1996458725","Celular");
        Contato contato2 = new Contato(2,"1938325416","Telefone");
    
        //Endereço
        Endereco endereco1 = new Endereco(1,"Rua Bulgarelli",225,"n/a",
                "1385236","Sao Paulo","SP","Brasil");
    
        Endereco endereco2 = new Endereco(2,"Rua Benedito Ruy",20,"n/a",
                "18568425","São Paulo","SP","Brasil");
    
        //Cliente
    
        Cliente cliente1 = new Cliente("Benedita Goncalves","12698874522");
        Cliente cliente2 = new Cliente("Bruscagina Guilhermina","87423685422");
        cliente1.getContatos().add(contato1);
        cliente1.getEnderecos().add(endereco1);
        cliente2.getContatos().add(contato2);
        cliente2.getEnderecos().add(endereco2);
    
        //ContaCorrente
        ContaCorrente cc1 = new ContaCorrente(cliente1,"38955","1245",0);
        cc1.setChequeEspecial(500);
    
        //ContaPagamento
        ContaPagamento cPag = new ContaPagamento(cliente1,"38956","1246",0);
    
        //ContaPoupança
        ContaPoupanca cp2 = new ContaPoupanca(cliente2,"38957","1247",0.0);
        
        //Testes
        cPag.depositar(100);
        cPag.sacar(10);
        cPag.transferir(cc1,80);
        cPag.imprimir();
        System.out.println("---------------------");
        cc1.depositar(20);
        cc1.sacar(10);
        cc1.transferir(cp2,80);
        cc1.imprimir();
        System.out.println("---------------------");
        cp2.depositar(20);
        cp2.sacar(10);
        cp2.transferir(cPag,30);
        cp2.imprimir();
        cPag.imprimir();
    
    }
}
