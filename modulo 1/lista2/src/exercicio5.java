import java.util.Scanner;

public class exercicio5 {
    public static void main(String[] args) {
        int[] numeros = new int[20];
        Scanner input = new Scanner(System.in);
        
        for (int i = 0; i < numeros.length; i++) {
            System.out.println("insira o numero na posicao " + i);
            numeros[i] = input.nextInt();
            input.nextLine();
        }
        
        System.out.println("vetor na ordem contraria: ");
        
        for (int j = numeros.length - 1; j >= 0; j--) {
            System.out.println(numeros[j]);
        }
        input.close();
    }
}
