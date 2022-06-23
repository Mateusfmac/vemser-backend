public class Contato {
    private String descricao;
    private String telefone;
    private int tipo; //1-residencial, 2-comercial

    public Contato(int tipo, String telefone, String descricao) {
        this.tipo = tipo;
        this.telefone = telefone;
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public void imprimirContato() {
        if (this.tipo == 1) {
            System.out.println("Tipo: " + this.tipo + " - Residencial");
            System.out.println("Descrição: " + this.descricao);
            System.out.println("Telefone " + this.telefone);
        } else if (this.tipo == 2) {
            System.out.println("Tipo: " + this.tipo + " - Comercial");
            System.out.println("Descrição: " + this.descricao);
            System.out.println("Telefone " + this.telefone);
        }
    }

    public String toString() {
        return this.descricao + " - " + this.telefone + " - " + this.tipo;
    }
}
