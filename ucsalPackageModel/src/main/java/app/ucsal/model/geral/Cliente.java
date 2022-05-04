package app.ucsal.model.geral;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "cliente", schema = "public",  uniqueConstraints = { @UniqueConstraint(name = "cliente_cpf", columnNames = { "cpf" }),
		                                                           @UniqueConstraint(name = "cliente_email", columnNames = { "email" })})
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;
  
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cliente_sequence")
	@SequenceGenerator(name = "cliente_sequence", sequenceName = "public.cliente_seq", initialValue = 1, allocationSize = 1)
	private Long id;

	@Enumerated(EnumType.STRING)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "perfil_tipo", referencedColumnName = "tipo")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Perfil perfil;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "estacionamento_id", referencedColumnName = "id")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Estacionamento estacionamento;

	@Column(name = "nome")
	private String nome;

	@Column(name = "cpf")
	private String cpf;

	@Column(name = "telefone")
	private String telefone;

	@Column(name = "email")
	private String email;
	
	@Transient
	private Integer quantidadeDeElementos;

	@Transient
	private Integer numeroDaPagina;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public Estacionamento getEstacionamento() {
		return estacionamento;
	}

	public void setEstacionamento(Estacionamento estacionamento) {
		this.estacionamento = estacionamento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Cliente other = (Cliente) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
