import java.util.Scanner;

public class exercicio6 {
    public static void main(String[] args) {
        int[] numeros = {10, 25, 65, 98, 44, 32, 77, 83, 11, 89};
        int num;
        boolean encontrou = false;
        Scanner input = new Scanner(System.in);
        
        System.out.println("insira o numero para realizar a busca no vetor: ");
        num = input.nextInt();
        
        for (int i = 0; i < numeros.length; i++) {
            if (num == numeros[i]) {
                encontrou = true;
            }
        }
        if (encontrou) {
            System.out.println("numero encontrado no vetor");
        } else {
            System.out.printf("o numero %d nao existe no vetor.", num);
        }
        input.close();
    }
}
