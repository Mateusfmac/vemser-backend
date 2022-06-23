public class ContaCorrente {
    String numeroConta;
    Integer agencia;
    Double saldo;
    Double chequeEspecial;
    
    void imprimirContaCorrente() {
        System.out.printf("\nAgencia: %d Conta: %s \nSaldo: %.2f \nCheque Especial: %.2f \n\n",
                agencia, numeroConta, saldo, chequeEspecial);
    }
    
    Boolean sacar(Double valor) {
        if (valor > 0 && retornarSaldoComChequeEspecial() >= valor) {
            saldo -= valor;
            return true;
        }
        return false;
    }
    
    Boolean depositar(Double valor) {
        if (valor > 0) {
            saldo += valor;
            return true;
        }
        return false;
    }
    
    Double retornarSaldoComChequeEspecial() {
        return saldo + chequeEspecial;
    }
    
    Boolean transferir(ContaCorrente destino, Double valor) {
        if (this.sacar(valor)) {
            destino.depositar(valor);
            System.out.println("\noperacao realizada, tranferiu: R$ " + valor + " para conta: " + destino.numeroConta);
            return true;
        }
        return false;
    }
}
