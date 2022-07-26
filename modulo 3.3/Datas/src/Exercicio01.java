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
        LocalDate foratarData = LocalDate.parse(aniversario, DateTimeFormatter.ofPattern("dd/MM/yyyy")).withYear(dataAtual.getYear());
    
        Period periodo = Period.between(dataAtual, foratarData.plusYears(1));
    
        System.out.println("Faltam " + periodo.getMonths() + " meses e " + periodo.getDays() +  " dias até seu aniversario ");
    
    }
}
