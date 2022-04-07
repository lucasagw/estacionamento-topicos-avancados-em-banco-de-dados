package app.ucsal.model.geral;

import app.ucsal.enums.preco.EnumTipoPreco;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

public class TipoPreco implements Serializable {

    private static final long serialVersionUID = 1L;

    @Enumerated(EnumType.STRING)
    @Id
    @Column(name = "tipo_preco")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "perfil_sequence")
    @SequenceGenerator(name = "tipo_preco_sequence", sequenceName = "public.tipo_preco_seq", initialValue = 1, allocationSize = 1)
    private EnumTipoPreco enumTipoPreco;

    @Column(name = "descricao")
    private String descricao;

    public EnumTipoPreco getEnumTipoPreco() {
        return enumTipoPreco;
    }

    public void setEnumTipoPreco(EnumTipoPreco tipo) {
        this.enumTipoPreco = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TipoPreco)) return false;
        TipoPreco tipoPreco = (TipoPreco) o;
        return enumTipoPreco == tipoPreco.enumTipoPreco;
    }

    @Override
    public int hashCode() {
        return Objects.hash(enumTipoPreco);
    }
}

