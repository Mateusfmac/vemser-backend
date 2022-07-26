import java.time.*;
import java.time.temporal.ChronoUnit;

public class Exercicio04 {
    public static void main(String[] args) {
        LocalDateTime dataEvento = LocalDateTime.of(2024, 9, 14, 18, 30);
        ZoneId londres = ZoneId.of("Europe/London");
        ZonedDateTime zoned = ZonedDateTime.of(dataEvento, londres);
    
        LocalDateTime datAtual = LocalDateTime.now();
    
        long anos = datAtual.until(zoned, ChronoUnit.YEARS);
        datAtual = datAtual.plusYears(anos);
    
        long meses = datAtual.until(zoned, ChronoUnit.MONTHS);
        datAtual = datAtual.plusMonths(meses);
    
        long dias = datAtual.until(zoned, ChronoUnit.DAYS);
        datAtual = datAtual.plusDays(dias);
    
        long horas = datAtual.until(zoned, ChronoUnit.HOURS);
        datAtual = datAtual.plusHours(horas);
    
        long minutos = datAtual.until(zoned, ChronoUnit.MINUTES);
        datAtual = datAtual.plusMinutes(minutos);
    
        long segundos = datAtual.until(zoned, ChronoUnit.SECONDS);
        
        System.out.println(anos + " Anos");
        System.out.println(meses + " Meses");
        System.out.println(dias + " Dias");
        System.out.println(horas + " Horas");
        System.out.println(minutos + " Minutos");
        System.out.println(segundos + " Segundos");
    }
}
