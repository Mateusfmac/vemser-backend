import java.util.Scanner;

public class exercicio8 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double[][] tabelaAlunos = new double[5][4];
        
        final int MATRICULA = 0, MEDIA_PROVA = 1, MEDIA_TRABALHO = 2, NOTA_FINAL = 3;
        double matriculaMaior = 0, maiorNota = 0, mediaFInalAlunos = 0;
        
        for (int i = 0; i < 5; i++) {
            System.out.println("Insira a matricula do aluno: ");
            tabelaAlunos[0][MATRICULA] = input.nextDouble();
            input.nextLine();
            System.out.println("Insira a media da prova: ");
            tabelaAlunos[0][MEDIA_PROVA] = input.nextDouble();
            input.nextLine();
            System.out.println("Insira a media do trabalho: ");
            tabelaAlunos[0][MEDIA_TRABALHO] = input.nextDouble();
            input.nextLine();
            
            tabelaAlunos[i][NOTA_FINAL] =  (tabelaAlunos[i][MEDIA_PROVA] * 0.6) + (tabelaAlunos[i][MEDIA_TRABALHO] * 0.4);
            
            if (i == 0) {
                maiorNota = tabelaAlunos[i][NOTA_FINAL];
                matriculaMaior = tabelaAlunos[i][MATRICULA];
            } else if (tabelaAlunos[i][NOTA_FINAL] > maiorNota) {
                maiorNota = tabelaAlunos[i][NOTA_FINAL];
                matriculaMaior = tabelaAlunos[i][MATRICULA];
            }
            mediaFInalAlunos += tabelaAlunos[i][NOTA_FINAL];
            
        }
        input.close();
        System.out.printf("a matricula do aluno com a maior nota e: %.0f \n", matriculaMaior);
        System.out.printf("a media das notas finais de todos os alunos e: %.2f", mediaFInalAlunos);
    }
}
