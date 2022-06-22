public class Contato {
    String descricao;
    String telefone;
    Integer tipo;
    
    void imprimirContato() {//ok
        if (tipo == 1) {
            System.out.println("Residencial");
        }
        if (tipo == 0) {
            System.out.println("Comercial");
        }
        System.out.printf("Descricao: %s \nTelefone: %s", descricao, telefone);
    }
}
