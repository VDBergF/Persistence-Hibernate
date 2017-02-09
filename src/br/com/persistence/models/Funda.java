package br.com.persistence.models;

import javax.persistence.*;
import java.sql.Time;

/**
 * Created by berg on 08/02/17.
 */
@Entity
@IdClass(FundaPK.class)
public class Funda {
    @EmbeddedId
    private FundaPK pk;
    @MapsId("codigoFundador")
    private int codigoFundador;
    @MapsId("codigoMuseu")
    private int codigoMuseu;
    private Time data;
    private Fundador fundadorByCodigoFundador;
    private Museu museuByCodigoMuseu;

    @Id
    @Column(name = "CODIGO_FUNDADOR", nullable = false, precision = 0)
    public int getCodigoFundador() {
        return codigoFundador;
    }

    public void setCodigoFundador(int codigoFundador) {
        this.codigoFundador = codigoFundador;
    }

    @Id
    @Column(name = "CODIGO_MUSEU", nullable = false, precision = 0)
    public int getCodigoMuseu() {
        return codigoMuseu;
    }

    public void setCodigoMuseu(int codigoMuseu) {
        this.codigoMuseu = codigoMuseu;
    }

    @Basic
    @Column(name = "DATA", nullable = true)
    public Time getData() {
        return data;
    }

    public void setData(Time data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Funda funda = (Funda) o;

        if (codigoFundador != funda.codigoFundador) return false;
        if (codigoMuseu != funda.codigoMuseu) return false;
        if (data != null ? !data.equals(funda.data) : funda.data != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = codigoFundador;
        result = 31 * result + codigoMuseu;
        result = 31 * result + (data != null ? data.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "CODIGO_FUNDADOR", referencedColumnName = "CODIGO", nullable = false, insertable = false, updatable = false)
    public Fundador getFundadorByCodigoFundador() {
        return fundadorByCodigoFundador;
    }

    public void setFundadorByCodigoFundador(Fundador fundadorByCodigoFundador) {
        this.fundadorByCodigoFundador = fundadorByCodigoFundador;
    }

    @ManyToOne
    @JoinColumn(name = "CODIGO_MUSEU", referencedColumnName = "CODIGO", nullable = false, insertable = false, updatable = false)
    public Museu getMuseuByCodigoMuseu() {
        return museuByCodigoMuseu;
    }

    public void setMuseuByCodigoMuseu(Museu museuByCodigoMuseu) {
        this.museuByCodigoMuseu = museuByCodigoMuseu;
    }
}
