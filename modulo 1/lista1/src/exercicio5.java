import java.util.Scanner;

public class exercicio5 {
    public static void main(String[] args) {
        Scanner dadosUsuario = new Scanner(System.in);
        double valorHora, horasNormais, horasExtras50, horasExtras100, salarioBruto;
        
        System.out.println("Informe o salario por hora: ");
        valorHora = dadosUsuario.nextFloat();

        System.out.println("Informe o numero de horas normais trabalhadas: ");
        horasNormais = dadosUsuario.nextFloat();

        System.out.println("Informe as horas extas 50%: ");
        horasExtras50 = dadosUsuario.nextFloat();

        System.out.println("Informe as horas extras 100%: ");
        horasExtras100 = dadosUsuario.nextFloat();

        salarioBruto = (horasNormais * valorHora) + (horasExtras50 * valorHora * 1.5) + (horasExtras100 * valorHora * 2);

        System.out.println("O seu salário bruto é de: R$" + salarioBruto);
    }
}
