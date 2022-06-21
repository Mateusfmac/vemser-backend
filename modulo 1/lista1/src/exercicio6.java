import java.util.Scanner;

public class exercicio6 {
    public static void main(String[] args) {
        Scanner palavraUsuario = new Scanner(System.in);
        String traducao;

        System.out.println("Digite uma palavra que deseja traduzir do portugues para o ingles ou do ingles para o portugues: ");
        traducao = palavraUsuario.nextLine();

        switch (traducao) {
            case "Cachorro" -> {
                System.out.println("Dog");
            }
            case "Tempo" -> {
                System.out.println("Time");
            }
            case "Amor" -> {
                System.out.println("Love");
            }
            case "Cidade" -> {
                System.out.println("City");
            }
            case "Feliz" -> {
                System.out.println("Happy");
            }
            case "Triste" -> {
                System.out.println("Sad");
            }
            case "Deveria" -> {
                System.out.println("Should");
            }
            case "Poderia" -> {
                System.out.println("Could");
            }
            case "Dog" -> {
                System.out.println("Cachorro");
            }
            case "Time" -> {
                System.out.println("Tempo");
            }
            case "Love" -> {
                System.out.println("Amor");
            }
            case "City" -> {
                System.out.println("Cidade");
            }
            case "Happy" -> {
                System.out.println("Feliz");
            }
            case "Sad" -> {
                System.out.println("Triste");
            }
            case "Shoud" -> {
                System.out.println("Deveria");
            }
            case "Could" -> {
                System.out.println("Poderia");
            }
            default -> {
                System.out.println("Palavra Invalida!");
            }
        }
    }
}
