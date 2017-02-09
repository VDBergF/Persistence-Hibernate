package br.com.persistence.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by berg on 08/02/17.
 */
@Embeddable
public class FundaPK implements Serializable {
    private int codigoFundador;
    private int codigoMuseu;

    @Column(name = "CODIGO_FUNDADOR", nullable = false, precision = 0)
    @Id
    public int getCodigoFundador() {
        return codigoFundador;
    }

    public void setCodigoFundador(int codigoFundador) {
        this.codigoFundador = codigoFundador;
    }

    @Column(name = "CODIGO_MUSEU", nullable = false, precision = 0)
    @Id
    public int getCodigoMuseu() {
        return codigoMuseu;
    }

    public void setCodigoMuseu(int codigoMuseu) {
        this.codigoMuseu = codigoMuseu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FundaPK fundaPK = (FundaPK) o;

        if (codigoFundador != fundaPK.codigoFundador) return false;
        if (codigoMuseu != fundaPK.codigoMuseu) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = codigoFundador;
        result = 31 * result + codigoMuseu;
        return result;
    }
}
