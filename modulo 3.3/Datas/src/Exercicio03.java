
import java.time.LocalDateTime;

public class Exercicio03 {
    public static void main(String[] args) {
        LocalDateTime dataAtual = LocalDateTime.now();
        LocalDateTime dataPlus = dataAtual.plusDays(15).plusHours(10);
    
        System.out.println("Dia da semana: " + dataPlus.getDayOfWeek());
        System.out.println("Dias do ano: " + dataPlus.getDayOfYear());
    }
}
