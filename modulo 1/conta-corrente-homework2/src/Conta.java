public abstract class Conta implements Movimentacao{
    private Cliente cliente;
    private String numeroConta;
    private String agencia;
    private double saldo;
    
    public Conta(Cliente cliente, String numeroConta, String agencia, double saldo) {
        this.cliente = cliente;
        this.numeroConta = numeroConta;
        this.agencia = agencia;
        this.saldo = saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public boolean sacar(double valor) {
        return false;
    }

    @Override
    public boolean transferir(Conta conta, double valor) {
        double saldo = getSaldo();
        if (valor > 0 && valor <= saldo){
            setSaldo(saldo -= valor);
            conta.depositar(valor);
            return true;
        }
        return false;
    }

    @Override
    public boolean depositar(double valor) {
        if (valor <= 0){
            System.out.println("Não é permitido depositar um valor negativo ou zero.");
            return false;
        }else {
            this.saldo += valor;
            return true;
        }
    }
}
