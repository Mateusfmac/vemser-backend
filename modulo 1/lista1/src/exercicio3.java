import java.util.Scanner;

public class exercicio3 {
    public static void main(String[] args) {
        Scanner valores = new Scanner(System.in);
        double totalConsumido, valorPago, troco;

        System.out.println("insira o valor total consumido: ");
        totalConsumido = valores.nextDouble();

        System.out.println("insira o valor pago pelo cliente: ");
        valorPago = valores.nextDouble();

        if(valorPago < totalConsumido) {
            System.out.println("O valor pago deve ser maior ou igual que o valor consumido");
        } else {
            troco = valorPago - totalConsumido;
            System.out.println("o troco é de : R$" + troco);
        }
    }
}
