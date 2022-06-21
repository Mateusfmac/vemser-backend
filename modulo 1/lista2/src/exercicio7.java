import java.util.Scanner;

public class exercicio7 {
    public static void main(String[] args) {
        //inicio variaveis
        int[][] matriz = new int[4][4];
        int contador = 0;
        Scanner input = new Scanner(System.in);
        //loop para preencher linhas e colunas da matriz, i - linhas j - colunas
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.println("insira o numero na linha " + i + " coluna " + j);
                matriz[i][j] = input.nextInt();
                input.nextLine();
                //condicao para contar os maiores que 10
                if (matriz[i][j] > 10) {
                    contador++;
                }
            }
        }
        input.close();
        System.out.println("existem " + contador + " maiores que 10.");
    }
}
