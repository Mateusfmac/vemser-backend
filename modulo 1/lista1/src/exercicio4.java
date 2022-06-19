import java.util.Scanner;

public class exercicio4 {
    public static void main(String[] args) {
        Scanner escolha = new Scanner(System.in);
        String estadoEscolhido, cidadeEscolhida = "";

        System.out.println("Digite a sigla em Maiusculo do estado escolhido: \nSP \nMG \nSC");
        estadoEscolhido = escolha.nextLine();

        switch (estadoEscolhido) {
            case "SP" -> {
                System.out.println("Digite o nome da cidade escolhida: \nHolambra \nBarretos");
                cidadeEscolhida = escolha.nextLine();
            }
            case "MG" -> {
                System.out.println("Digite o nome da cidade escolhida: \nOuro Preto \nUberlandia");
                cidadeEscolhida = escolha.nextLine();
            }
            case "SC" -> {
                System.out.println("Digite o nome da cidade escolhida: \nBlumenau \nFlorianopolis");
                cidadeEscolhida = escolha.nextLine();
            }
            default -> {
                System.out.println("Digite corretamente");
            }
        }

        switch (cidadeEscolhida) {
            case "Holambra" -> {
                System.out.println("População: 15.272 \nPrincipal Festa: Festa das Flores \nIDH: 0,793");
            }
            case "Barretos" -> {
                System.out.println("População: 123.546 \nPrincipal Festa: Festa do Peão \nIDH: 0,789");
            }
            case "Ouro Preto" -> {
                System.out.println("População: 74.558 \nPrincipal Festa: Festa do Amendoim \nIDH: 0,727");
            }
            case "Uberlandia" -> {
                System.out.println("População: 699.097 \nPrincipal Festa: Festa do Congado de Uberlandia \nIDH: 0,789");
            }
            case "Blumenau" -> {
                System.out.println("População: 361.855 \nPrincipal Festa: Oktoberfest \nIDH: 0,805");
            }
            case "Florianopolis" -> {
                System.out.println("População: 508.826 \nPrincipal Festa: Magic Island \nIDH: 0,847");
            }
            default -> {
                System.out.println("Digite corretamente");
            }
        }
    }
}
