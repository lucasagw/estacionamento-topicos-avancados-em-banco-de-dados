package app.ucsal.util;

import java.io.Serializable;

public class Erro implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer codigo;

	private String mensagem;

	public Erro(Integer codigo, String mensagem) {

		super();

		this.codigo = codigo;

		this.mensagem = mensagem;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
}