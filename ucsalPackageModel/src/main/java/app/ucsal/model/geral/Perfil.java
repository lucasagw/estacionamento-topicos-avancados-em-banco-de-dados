package app.ucsal.model.geral;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import app.ucsal.enums.perfil.Tipo;

@Entity
@Table(name = "perfil", schema = "public")
public class Perfil implements Serializable {

	private static final long serialVersionUID = 1L;

	@Enumerated(EnumType.STRING)
	@Id
	@Column(name = "tipo")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "perfil_sequence")
	@SequenceGenerator(name = "perfil_sequence", sequenceName = "public.perfil_seq", initialValue = 1, allocationSize = 1)
	private Tipo tipo;

	@Column(name = "descricao")
	private String descricao;

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Perfil other = (Perfil) obj;
		if (tipo != other.tipo)
			return false;
		return true;
	}
}
