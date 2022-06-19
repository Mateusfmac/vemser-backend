import java.util.Scanner;

public class exercicio1 {
    public static void main(String[] args) {
        Scanner dadosUsuario = new Scanner(System.in);
        String nome, cidade, estado;
        int idade;

        System.out.println("Digite seu primeiro nome: ");
        nome = dadosUsuario.next();

        System.out.println("informe o nome da sua cidade: ");
        cidade = dadosUsuario.nextLine();

        System.out.println("informe o nome do estado: ");
        estado = dadosUsuario.nextLine();

        System.out.println("informe sua idade: ");
        idade = dadosUsuario.nextInt();

        System.out.println("Olá seu nome é " + nome + " você tem " + idade + " anos," + " é da cidade de " + cidade + ", situada no estado de " + estado);
    }
}
