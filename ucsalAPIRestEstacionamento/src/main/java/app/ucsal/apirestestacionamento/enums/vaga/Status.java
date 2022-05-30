package app.ucsal.apirestestacionamento.enums.vaga;

public enum Status {
	
	DISPONIVEL("Disponível"), OCUPADO("Ocupado"), INDISPONIVEL("Indisponível");

	private String nome;
	
	private String valor;

	private Status(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getValor() {
		return valor = this.name(); // aponta para o enum de origem
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

//	@Override
//	public String toString() {
//
//		return this.name(); // aponta para o enum de origem
//	}
}
