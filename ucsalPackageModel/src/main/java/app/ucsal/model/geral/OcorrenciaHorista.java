package app.ucsal.model.geral;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.Duration;

public class OcorrenciaHorista extends Ocorrencia {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "preco_id", referencedColumnName = "id")
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    private Preco preco;

    public Preco getPreco() {
        return preco;
    }

    public void setPreco(Preco preco) {
        this.preco = preco;
    }

    public BigDecimal valorTotal() {
        return this.preco.getPreco().multiply(BigDecimal.valueOf(Duration.between(this.getEntrada(), this.getSaida()).toHours()));
    }
}
