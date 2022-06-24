public class ContaPagamento extends Conta implements Impressao{
    private static final Double TAXA_SAQUE = 4.25;
    
    public ContaPagamento(Cliente cliente, String numeroConta, String agencia, double saldo) {
        super(cliente, numeroConta, agencia, saldo);
    }
    
    @Override
    public void imprimir() {
        if (getCliente()!= null){
            getCliente().imprimirCliente();
        }
        System.out.println("Agencia: "+getAgencia());
        System.out.println("Número conta: "+getNumeroConta());
        System.out.printf("Saldo: %.2f%n%n",getSaldo());
    }
    
    @Override
    public boolean sacar(double valor) {
        if (valor + TAXA_SAQUE <= getSaldo() && valor > 0) {
            super.sacar(valor + TAXA_SAQUE);
            return true;
        }
        return false;
    }
}
