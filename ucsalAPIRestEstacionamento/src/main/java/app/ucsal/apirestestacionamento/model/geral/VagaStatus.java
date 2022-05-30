package app.ucsal.apirestestacionamento.model.geral;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import app.ucsal.apirestestacionamento.enums.vaga.Status;

@Entity
@Table(name = "vaga_status", schema = "public")
public class VagaStatus implements Serializable {

	private static final long serialVersionUID = 1L;

	@Enumerated(EnumType.STRING)
	@Id
	@Column(name = "status")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vaga_status_sequence")
	@SequenceGenerator(name = "vaga_status_sequence", sequenceName = "public.vaga_status_seq")
	private Status status;

	@Column(name = "descricao")
	private String descricao;

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
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
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		VagaStatus other = (VagaStatus) obj;
		if (status != other.status)
			return false;
		return true;
	}
}
