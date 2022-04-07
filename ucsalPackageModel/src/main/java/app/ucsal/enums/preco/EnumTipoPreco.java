package app.ucsal.enums.preco;

public enum EnumTipoPreco {

    HORA("HORA"), MENSAL("MENSAL");


    private String nome;

    private String valor;

    public String getValor() {
        return valor = this.name();
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    EnumTipoPreco(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
