import jdk.swing.interop.SwingInterOpUtils;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Exercicio01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LocalDate dataAtual = LocalDate.now();
        
        System.out.println("Digite a data do seu aniversario no formato dd/mm/yyyy: ");
        String aniversario = scanner.nextLine();
        LocalDate formatarData = LocalDate.parse(aniversario, DateTimeFormatter.ofPattern("dd/MM/yyyy")).withYear(dataAtual.getYear());
        System.out.println(formatarData);
        Period periodo = Period.between(dataAtual, formatarData.plusYears(1));
    
        System.out.println("Faltam " + periodo.getMonths() + " meses e " + periodo.getDays() +  " dias para o seu aniversario ");
    
    }
}
