public class ContaPoupanca extends Conta implements Impressao {
    public static final double JUROS_MENSAIS = 1.01;

    public ContaPoupanca(Cliente cliente, String numeroConta, String agencia, double saldo) {
        super(cliente, numeroConta, agencia, saldo);
    }
    public void creditarTaxa(){
        setSaldo(getSaldo()*JUROS_MENSAIS);
    }

    @Override
    public void imprimir() {
        if (getCliente()!= null){
            getCliente().imprimirCliente();
        }
        System.out.println("Agencia: "+getAgencia());
        System.out.println("Número conta: "+getNumeroConta());
        System.out.println("Saldo: "+getSaldo());
    }
}
