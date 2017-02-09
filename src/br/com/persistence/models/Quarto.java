package br.com.persistence.models;

import javax.persistence.*;

/**
 * Created by berg on 08/02/17.
 */
@Entity
public class Quarto {
    private long preco;
    private String tipo;
    private int codigoHotel;
    private int numero;
    private Hotel hotelByCodigoHotel;

    @Basic
    @Column(name = "PRECO", nullable = false, precision = 2)
    public long getPreco() {
        return preco;
    }

    public void setPreco(long preco) {
        this.preco = preco;
    }

    @Basic
    @Column(name = "TIPO", nullable = false, length = 30)
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Basic
    @Column(name = "CODIGO_HOTEL", nullable = false, precision = 0)
    public int getCodigoHotel() {
        return codigoHotel;
    }

    public void setCodigoHotel(int codigoHotel) {
        this.codigoHotel = codigoHotel;
    }

    @Id
    @Column(name = "NUMERO", nullable = false, precision = 0)
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Quarto quarto = (Quarto) o;

        if (preco != quarto.preco) return false;
        if (codigoHotel != quarto.codigoHotel) return false;
        if (numero != quarto.numero) return false;
        if (tipo != null ? !tipo.equals(quarto.tipo) : quarto.tipo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (preco ^ (preco >>> 32));
        result = 31 * result + (tipo != null ? tipo.hashCode() : 0);
        result = 31 * result + codigoHotel;
        result = 31 * result + numero;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "CODIGO_HOTEL", referencedColumnName = "CODIGO", nullable = false)
    public Hotel getHotelByCodigoHotel() {
        return hotelByCodigoHotel;
    }

    public void setHotelByCodigoHotel(Hotel hotelByCodigoHotel) {
        this.hotelByCodigoHotel = hotelByCodigoHotel;
    }
}
