import java.util.Scanner;

public class exercicio7 {
    public static void main(String[] args) {
        int[][] matriz = new int[4][4];
        int contador = 0;
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.println("insira o numero na linha " + i + " coluna " + j);
                matriz[i][j] = input.nextInt();
                input.nextLine();
                if(matriz[i][j] > 10) {
                    contador++;
                }
            }
        }
        input.close();
        System.out.println("existem " + contador + " maiores que 10.");
    }
}
