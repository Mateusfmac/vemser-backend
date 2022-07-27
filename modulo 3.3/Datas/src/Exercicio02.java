import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Exercicio02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
    
        System.out.println("Informe a primeira data: ");
        LocalDate primeriaData = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    
        System.out.println("Insira a segunda data: ");
        LocalDate segundaData = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        
        Period period = Period.between(primeriaData, segundaData);
    
        System.out.println("a diferenca em dias eh de " + period.getDays() + ", de meses eh de " + period.getMonths() + ", e de anos eh de " + period.getYears());
    }
    
    
}
