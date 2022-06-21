import java.util.Scanner;

public class exercicio1 {
    public static void main(String[] args) {
        String produto = null;
        double preco = 0, precoComDesconto = 0;
        Scanner input = new Scanner(System.in);
    
        System.out.println("Insira o nome do produto: ");
        produto = input.nextLine();
    
        System.out.println("Informe o preço normal: ");
        preco = input.nextDouble();
        input.nextLine();
    
        System.out.printf("Produto: %s \nPreco R$: %.2f \nPromocao: %s", produto, preco, produto + "\n------------------ \n");
    
        for (double i = 1, j = 0.05 ; i <= 10; i++, j += 0.05) {
            precoComDesconto = preco - (preco * j) ;
            System.out.printf("%.0f x R$ %.2f = %.2f\n", i, precoComDesconto, precoComDesconto * i);
        }
        input.close();
    }
}
