import java.util.Scanner;

public class exercicio4 {
    public static void main(String[] args) {
        //inicio variaveis
        int[] numeros = new int[3];
        int menor = Integer.MAX_VALUE; // inicia com o maior valor de int
        int indice = 0;
        Scanner input = new Scanner(System.in);
        //loop para coletar dados e
        for (int i = 0; i < numeros.length; i++) {
            System.out.printf("digite o numero da posicao %d\n", i);
            numeros[i] = input.nextInt();
            //verifica menor numero e o indice
            if (menor > numeros[i]) {
                menor = numeros[i];
                indice = i;
            }
        }
        System.out.printf("O menor numero digitado e : %d e esta no indice %d", menor, indice);
        input.close();
    }
}


