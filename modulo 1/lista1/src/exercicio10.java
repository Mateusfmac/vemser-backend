import java.util.Scanner;

public class exercicio10 {
    public static void main(String[] args) {
        Scanner dados = new Scanner(System.in);
        double total, validos, pBrancos, pNulos, brancos, nulos;

        System.out.println("Digite o total de eleitores: ");
        total = dados.nextInt();

        System.out.println("Digite o total de votos brancos: ");
        brancos = dados.nextInt();

        System.out.println("Digite o total de votos nulos: ");
        nulos = dados.nextInt();

        validos = total - brancos - nulos;

        pBrancos = brancos * 100 / total;
        pNulos = nulos * 100 / total;

        System.out.println("O total de eleitores é " + total + ", a porcentagem de votos brancos é de " + pBrancos + "%, a porcentagem de votos nulos é de " + pNulos + "% e o total de votos validos é de " + validos);
    }
}
