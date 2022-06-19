import java.util.Scanner;

public class exercicio8 {
    public static void main(String[] args) {
        Scanner dados = new Scanner(System.in);
        double base, altura, area;

        System.out.println("Informe a medida da base: ");
        base = dados.nextFloat();

        System.out.println("Informe a medida da altura: ");
        altura = dados.nextFloat();

        area = base * altura;

        System.out.println("A area é : " + area);
    }
}
