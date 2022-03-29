package app.ucsal.apirestestacionamento.util;

import java.io.Serializable;
import java.util.List;

public class ParametroDeAnuncioPaginado implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private List<Integer> listaDeProdutoId;

	private List<Integer> listaDeDocumentoId;
	
	private Integer cidadeId;
	
	private Integer tipoProdutoId;
	
	private Integer contatoId;

	private Float latitudeDoUsuario;

	private Float longitudeDoUsuario;

	private Integer quantidadeDeElementos;

	private Integer numeroDaPagina;

	public List<Integer> getListaDeProdutoId() {
		return listaDeProdutoId;
	}

	public void setListaDeProdutoId(List<Integer> listaDeProdutoId) {
		this.listaDeProdutoId = listaDeProdutoId;
	}

	public List<Integer> getListaDeDocumentoId() {
		return listaDeDocumentoId;
	}

	public void setListaDeDocumentoId(List<Integer> listaDeDocumentoId) {
		this.listaDeDocumentoId = listaDeDocumentoId;
	}

	public Integer getCidadeId() {
		return cidadeId;
	}

	public void setCidadeId(Integer cidadeId) {
		this.cidadeId = cidadeId;
	}

	public Integer getTipoProdutoId() {
		return tipoProdutoId;
	}

	public void setTipoProdutoId(Integer tipoProdutoId) {
		this.tipoProdutoId = tipoProdutoId;
	}

	public Integer getContatoId() {
		return contatoId;
	}

	public void setContatoId(Integer contatoId) {
		this.contatoId = contatoId;
	}

	public Float getLatitudeDoUsuario() {
		return latitudeDoUsuario;
	}

	public void setLatitudeDoUsuario(Float latitudeDoUsuario) {
		this.latitudeDoUsuario = latitudeDoUsuario;
	}

	public Float getLongitudeDoUsuario() {
		return longitudeDoUsuario;
	}

	public void setLongitudeDoUsuario(Float longitudeDoUsuario) {
		this.longitudeDoUsuario = longitudeDoUsuario;
	}

	public Integer getQuantidadeDeElementos() {
		return quantidadeDeElementos;
	}

	public void setQuantidadeDeElementos(Integer quantidadeDeElementos) {
		this.quantidadeDeElementos = quantidadeDeElementos;
	}

	public Integer getNumeroDaPagina() {
		return numeroDaPagina;
	}

	public void setNumeroDaPagina(Integer numeroDaPagina) {
		this.numeroDaPagina = numeroDaPagina;
	}
}