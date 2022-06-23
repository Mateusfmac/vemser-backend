public class Contato {
    String descricao;
    String telefone;
    int tipo;
    
    void imprimirContato() {
        if (tipo == 1) {
            System.out.println("\nResidencial");
        }
        if (tipo == 0) {
            System.out.println("\nComercial");
        }
        System.out.printf("Descricao: %s \nTelefone: %s", descricao, telefone);
    }
}
