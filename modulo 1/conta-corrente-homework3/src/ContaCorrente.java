public class ContaCorrente extends Conta implements Movimentacao,Impressao{
    private double chequeEspecial;

    public ContaCorrente(Cliente cliente, String numeroConta, String agencia, double saldo) {
        super(cliente, numeroConta, agencia, saldo);
    }

    @Override
    public boolean sacar(double valor) {
        if (valor > 0 && retornarSaldoComChequeEspecial() >= valor){
            setSaldo(getSaldo() - valor);
            return true;
        } else {
            System.out.println("Operação não permitida.");
            return false;
        }
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

    public void setChequeEspecial(double chequeEspecial) {
        this.chequeEspecial = chequeEspecial;
    }

    public double retornarSaldoComChequeEspecial(){
        return super.getSaldo() + chequeEspecial;
    }
}
