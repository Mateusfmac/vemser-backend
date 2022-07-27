import java.time.*;
import java.time.temporal.ChronoUnit;

public class Exercicio04 {
    public static void main(String[] args) {
        LocalDateTime dataEvento = LocalDateTime.of(2024, 9, 14, 18, 30);
        ZoneId idLondres = ZoneId.of("Europe/London");
        ZonedDateTime zoned = ZonedDateTime.of(dataEvento, idLondres);
        LocalDateTime dataAtual = LocalDateTime.now();
    
        long anos = dataAtual.until(zoned, ChronoUnit.YEARS);
        dataAtual = dataAtual.plusYears(anos);
    
        long meses = dataAtual.until(zoned, ChronoUnit.MONTHS);
        dataAtual = dataAtual.plusMonths(meses);
    
        long dias = dataAtual.until(zoned, ChronoUnit.DAYS);
        dataAtual = dataAtual.plusDays(dias);
    
        long horas = dataAtual.until(zoned, ChronoUnit.HOURS);
        dataAtual = dataAtual.plusHours(horas);
    
        long minutos = dataAtual.until(zoned, ChronoUnit.MINUTES);
        dataAtual = dataAtual.plusMinutes(minutos);
    
        long segundos = dataAtual.until(zoned, ChronoUnit.SECONDS);
        dataAtual = dataAtual.plusSeconds(segundos);
        
        System.out.println(anos + " Anos");
        System.out.println(meses + " Meses");
        System.out.println(dias + " Dias");
        System.out.println(horas + " Horas");
        System.out.println(minutos + " Minutos");
        System.out.println(segundos + " Segundos");
    }
}
