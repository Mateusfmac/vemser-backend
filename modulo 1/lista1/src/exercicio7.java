public class exercicio7 {
    public static void main(String[] args) {
        int A, B, aux;
        A = 10;
        B = 20;
        System.out.println("Valor de A " + A + " Valor de B " + B);

        aux = A;
        A = B;
        B = aux;
        System.out.println("Valor de A " + A + " Valor de B " + B);
    }
}
