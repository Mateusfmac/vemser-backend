import java.rmi.UnexpectedException;
import java.util.Scanner;

public class exercicio2 {
    public static void main(String[] args) {
        //inicio variaveis
        int numeroEscolhido, numeroUsuario = 0;
        Scanner input = new Scanner(System.in);
        
        //solicitando numero a advinhar
        System.out.println("digite o numero para o outro advinhar: ");
        numeroEscolhido = input.nextInt();
        input.nextLine();
        
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        
        //verificando numero digitado com o escolhido
        while (numeroUsuario != numeroEscolhido) {
            System.out.println("Digite um numero para tentar acertar: ");
            numeroUsuario = input.nextInt();
            input.nextLine();
            if (numeroUsuario < numeroEscolhido) {
                System.out.println("Erooou !, o numero a ser encontrado e maior do que voce digitou.");
            } else if (numeroUsuario > numeroEscolhido) {
                System.out.println("Erooou!, o numero a ser encontrado e menor do que voce digitou.");
            }
        }
        System.out.println("Parabeens, voce acertou!!!");
        input.close();
    }
}
