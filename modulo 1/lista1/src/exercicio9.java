import java.util.Scanner;

public class exercicio9 {
    public static void main(String[] args) {
        Scanner dados = new Scanner(System.in);
        
        int dias, meses, anos, totalDias;
    
        System.out.println("informe sua idade em anos, meses e dias \nEx: 15 anos, 3 meses e 25 dias");
        System.out.println("informe sua idade em anos: ");
        anos = dados.nextInt();
    
        System.out.println("informe os meses: ");
        meses = dados.nextInt();
    
        System.out.println("informe os dias: ");
        dias = dados.nextInt();
        
        totalDias = (anos * 365) + (meses * 30) + dias;
        
        System.out.println("voce tem " + totalDias + " de vida ");
    }
}
