import java.util.Scanner;

public class exercicio3 {
    public static void main(String[] args) {
        //inicio variaveis
        Scanner input = new Scanner(System.in);
        String nome = "", nomeMaior = null, nomeMaisPesado = null, nomeMaisVelho = null;
        double altura = 0, peso = 0, alturaMaior = 0, maisPesado = 0, mediaAltura = 0;
        int idade = 0, qtdJogador = 0, maisVelho = 0;
        
        //loop para cadastrar jogadores, contador, media de altura
        do {
            System.out.println("Digite o nome do jogador");
            nome = input.nextLine();
            //condicao caso digite SAIR
            if (nome.equalsIgnoreCase("sair")) {
                break;
            }
            System.out.println("Digite a altura do jogador");
            altura = input.nextDouble();
            input.nextLine();
            System.out.println("Digite a idade do jogador");
            idade = input.nextInt();
            input.nextLine();
            System.out.println("Digite o peso do jogador");
            peso = input.nextDouble();
            input.nextLine();
            qtdJogador++;
            mediaAltura += altura;
            System.out.printf("Jogador cadastrado! \nTotal de jogadores cadastrados: %s \n", qtdJogador);
            
            //verificacao do mais alto, mais velho, mais pesado
            if (altura > alturaMaior) {
                alturaMaior = altura;
                nomeMaior = nome;
            }
            if (idade > maisVelho) {
                maisVelho = idade;
                nomeMaisVelho = nome;
            }
            if (peso > maisPesado) {
                maisPesado = peso;
                nomeMaisPesado = nome;
            }
        } while (true);
        
        System.out.printf("Quantidade de jogadores cadastrados: %s \n", qtdJogador);
        System.out.printf("%s e o jogador mais alto com %.2fM \n", nomeMaior, alturaMaior);
        System.out.printf("%s e o jogador mais pesado, pesando %.3fKg \n", nomeMaisPesado, maisPesado);
        System.out.printf("%s e o jogador mais velho com %d anos \n", nomeMaisVelho, maisVelho);
        System.out.printf("a media da altura dos jogadores e de %.2f", mediaAltura / qtdJogador);
        input.close();
    }
}
