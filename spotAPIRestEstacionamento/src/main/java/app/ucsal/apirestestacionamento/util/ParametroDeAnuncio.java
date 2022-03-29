package app.ucsal.apirestestacionamento.util;

import java.io.Serializable;
import java.util.List;

// Entidade que representa os parametros que devem ser passado aos endpoint de AnuncioController
public class ParametroDeAnuncio implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer cidadeId;
	
	private List<Integer> listaDeProdutoId;
	
	private List<Integer> listaDeDocumentoId;
	
	private Float latitudeDoUsuario;
	
	private Float longitudeDoUsuario;

	public Integer getCidadeId() {
		return cidadeId;
	}

	public void setCidadeId(Integer cidadeId) {
		this.cidadeId = cidadeId;
	}

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
}
