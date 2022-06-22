public class ContaCorrente {
    String numeroConta;
    Integer agencia;
    Double saldo;
    Double chequeEspecial;
    
    void imprimirContaCorrente() {
        System.out.printf("\nAgencia: %d Conta: %s \nSaldo: %.2f \nCheque Especial: %.2f \n\n",
                agencia,numeroConta, saldo, chequeEspecial);
        
    }
    
    Boolean sacar(Double valor) {
        if(valor > 0 && retornarSaldoComChequeEspecial() >= valor && saldo > 0) {
            if (valor > saldo) {
               saldo -= valor;
               return true;
            } else {
                saldo -= valor;
                return  true;
            }
        } else if (saldo < 0 && valor <= retornarSaldoComChequeEspecial()) {
            saldo -= valor;
            return true;
        }
        return false;
    }
    
    Boolean depositar(Double valor) {
       if (valor > 0);
       saldo += valor;
       return true;
    }
    
    Double retornarSaldoComChequeEspecial() {
        if (saldo > 0) {
            return  saldo + chequeEspecial;
        } else {
            return chequeEspecial;
        }
    }
    
    Boolean transferir(ContaCorrente destino, Double valor) {
        if (!this.numeroConta.equalsIgnoreCase(destino.numeroConta)) {
            this.sacar(valor);
            destino.depositar(valor);
            System.out.println(" operacao realizada, tranferiu: R$ " + valor + " para conta: " + destino.numeroConta);
            return true;
        }
        return false;
    }
}
