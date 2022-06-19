import java.util.Scanner;

public class exercicio2 {
    public static void main(String[] args) {
        Scanner notas = new Scanner(System.in);
        double nota1, nota2, nota3, nota4, media;
        String status = "";

        System.out.println("informe as suas 4 notas: ");
        nota1 = notas.nextFloat();
        nota2 = notas.nextFloat();
        nota3 = notas.nextFloat();
        nota4 = notas.nextFloat();
        media = (nota1 + nota2 + nota3 + nota4) / 4;
          
        if((media >= 0) && (media <= 5) ){
            status = "Reprovado";
        } else if ((media >= 5.1) && (media <= 6.9)) {
            status = "Em Exame";
        } else if ((media >= 7) && (media <=10)){
            status = "Aprovado";
        }

        System.out.println("A sua média é " + media + " e você está " + status);
    }
}
