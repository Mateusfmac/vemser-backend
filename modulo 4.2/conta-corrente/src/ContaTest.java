import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContaTest {
    //1
    @Test
    public void deveTestarSaqueContaCorrenteEVerificarSaldoComSucesso() {
        // setup
        ContaCorrente contaCorrente = new ContaCorrente();
        contaCorrente.setSaldo(1000);
        contaCorrente.setChequeEspecial(1000);
        int saque = 1500;
        
        // act
        boolean conseguiuSacar = contaCorrente.sacar(saque);
        
        // assert
        Assertions.assertTrue(conseguiuSacar);
        Assertions.assertEquals(-500, contaCorrente.getSaldo());
    }
    
    //2
    @Test
    public void deveTestarSaqueContaCorrenteSemSaldo() {
        // setup
        ContaCorrente contaCorrente = new ContaCorrente();
        contaCorrente.setSaldo(1000);
        contaCorrente.setChequeEspecial(1000);
        int valorSaque = 3000;
        
        // act
        boolean conseguiuSacar = contaCorrente.sacar(valorSaque);
        
        // assert
        Assertions.assertFalse(conseguiuSacar);
        Assertions.assertEquals(1000, contaCorrente.getSaldo());
    }
    
    //3
    @Test
    public void deveTestarSaqueContaPoupancaEVerificarSaldoComSucesso() {
        // setup
        ContaPoupanca contaPoupanca = new ContaPoupanca();
        contaPoupanca.setSaldo(1000);
        contaPoupanca.creditarTaxa();
        int valorSaque = 500;
        
        // act
        boolean conseguiuSacar = contaPoupanca.sacar(valorSaque);
        
        // assert
        Assertions.assertTrue(conseguiuSacar);
        Assertions.assertEquals(510, contaPoupanca.getSaldo());
    }
    
    //4
    @Test
    public void deveTestarSaqueContaPoupancaSemSaldo() {
        // setup
        ContaPoupanca contaPoupanca = new ContaPoupanca();
        contaPoupanca.setSaldo(1000);
        int valorSaque = 2000;
        
        // act
        boolean conseguiuSacar = contaPoupanca.sacar(valorSaque);
        
        // assert
        Assertions.assertFalse(conseguiuSacar);
        Assertions.assertEquals(1010, contaPoupanca.getSaldo());
    }
    
    //5
    @Test
    public void deveTestarSaquePagamentoEVerificarSaldoComSucesso() {
        // setup
        ContaPagamento contaPagamento = new ContaPagamento();
        contaPagamento.setSaldo(2000);
        double valorSaque = 1995.75;
        
        // act
        boolean conseguiuSacar = contaPagamento.sacar(valorSaque);
        
        // assert
        Assertions.assertTrue(conseguiuSacar);
        Assertions.assertEquals(0, contaPagamento.getSaldo());
    }
    
    //6
    @Test
    public void deveTestarSaquePagamentoSemSaldo() {
        // setup
        ContaPagamento contaPagamento = new ContaPagamento();
        contaPagamento.setSaldo(2000);
        double valorSaque = 2000;
        
        // act
        boolean conseguiuSacar = contaPagamento.sacar(valorSaque);
        
        // assert
        Assertions.assertFalse(conseguiuSacar);
        Assertions.assertEquals(2000, contaPagamento.getSaldo());
    }
    
    //7
    @Test
    public void deveTestarTransferenciaEVerificarSaldoComSucesso() {
        // setup
        ContaCorrente contaCorrente = new ContaCorrente();
        ContaPagamento contaPagamento = new ContaPagamento();
        contaCorrente.setSaldo(2000);
        double valorTransferencia = 1500;
        
        // act
        boolean conseguiuTransferir = contaCorrente.transferir(contaPagamento, valorTransferencia);
        
        // assert
        Assertions.assertTrue(conseguiuTransferir);
        Assertions.assertEquals(500, contaCorrente.getSaldo());
        Assertions.assertEquals(1500, contaPagamento.getSaldo());
    }
    
    //8
    @Test
    public void deveTestarTransferenciaSemSaldo() {
        // setup
        ContaPoupanca contaPoupanca = new ContaPoupanca();
        ContaCorrente contaCorrente = new ContaCorrente();
        contaPoupanca.setSaldo(800);
        double valorTransferencia = 1000;
        
        // act
        boolean conseguiuTransferir = contaPoupanca.transferir(contaCorrente, valorTransferencia);
        
        // assert
        Assertions.assertFalse(conseguiuTransferir);
        Assertions.assertEquals(800, contaPoupanca.getSaldo());
        Assertions.assertEquals(0, contaCorrente.getSaldo());
    }
    
    //9
    @Test
    public void deveTestarDepositoEVerificarSaldoComSucesso() {
        // setup
        ContaPoupanca contaPoupanca = new ContaPoupanca();
        double valorDeposito = 1250;
        
        // act
        boolean conseguiuDepositar = contaPoupanca.depositar(valorDeposito);
        
        // assert
        Assertions.assertTrue(conseguiuDepositar);
        Assertions.assertEquals(1250, contaPoupanca.getSaldo());
    }
    
    //10
    @Test
    public void deveTestarDepositoNegativo() {
        // setup
        ContaPagamento contaPagamento = new ContaPagamento();
        double valorDeposito = -50;
        
        // act
        boolean conseguiuDepositar = contaPagamento.depositar(valorDeposito);
        
        // assert
        Assertions.assertFalse(conseguiuDepositar);
        Assertions.assertEquals(0, contaPagamento.getSaldo());
    }
}
