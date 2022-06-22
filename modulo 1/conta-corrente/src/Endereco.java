public class Endereco {
    Integer tipo;
    String logradouro;
    Integer numero;
    String complemento;
    String cep;
    String cidade;
    String estado;
    String pais;
    
    void imprimirEndereco() {//ok
        if (tipo == 1) {
            System.out.println("Endereco Residencial");
        }
        if (tipo == 0) {
            System.out.println("Endereco Comercial");
        }
        System.out.printf("Logradouro: %s, N%d, CEP: %s Complemento: %s \n", logradouro, numero, cep, complemento);
        System.out.printf("Cidade: %s, %s - %s", cidade, estado, pais);
    }
}
