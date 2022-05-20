package app.ucsal.model.geral;

import java.math.BigDecimal;
import java.time.Duration;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "ocorrencia_horista", schema = "public")
@PrimaryKeyJoinColumn(name = "ocorrencia_id", referencedColumnName = "id")
@Inheritance(strategy = InheritanceType.JOINED)
public class OcorrenciaHorista extends Ocorrencia {

	private static final long serialVersionUID = 1L;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "preco_id", referencedColumnName = "id", nullable = true)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Preco preco;
	
	public Preco getPreco() {
		return preco;
	}

	public void setPreco(Preco preco) {
		this.preco = preco;
	}

	public BigDecimal valorTotal() {
		return this.preco.getPreco()
				.multiply(BigDecimal.valueOf(Duration.between(this.getEntrada(), this.getSaida()).toHours()));
	}
}
