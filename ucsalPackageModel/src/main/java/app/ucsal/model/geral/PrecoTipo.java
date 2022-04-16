package app.ucsal.model.geral;

import app.ucsal.enums.preco.Preco;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "preco_tipo", schema = "public")
public class PrecoTipo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Enumerated(EnumType.STRING)
	@Id
	@Column(name = "tipo")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "perfil_sequence")
	@SequenceGenerator(name = "tipo_preco_sequence", sequenceName = "public.tipo_preco_seq")
	private Preco tipo;

	@Column(name = "descricao")
	private String descricao;

	public Preco getTipo() {
		return tipo;
	}

	public void setTipo(Preco tipo) {
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
		return Objects.hash(tipo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PrecoTipo other = (PrecoTipo) obj;
		return tipo == other.tipo;
	}
}
