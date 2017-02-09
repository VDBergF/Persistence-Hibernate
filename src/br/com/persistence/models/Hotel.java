package br.com.persistence.models;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by berg on 08/02/17.
 */
@Entity
public class Hotel {
    private int codigo;
    private String nome;
    private String rua;
    private String bairro;
    private String numero;
    private int codigoCidade;
    private boolean tipo;
    private Integer codigoRestaurante;
    private Restaurante restauranteByCodigoRestaurante;
    private Collection<Quarto> quartosByCodigo;

    @Id
    @Column(name = "CODIGO", nullable = false, precision = 0)
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Basic
    @Column(name = "NOME", nullable = false, length = 100)
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Basic
    @Column(name = "RUA", nullable = false, length = 100)
    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    @Basic
    @Column(name = "BAIRRO", nullable = false, length = 100)
    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    @Basic
    @Column(name = "NUMERO", nullable = true, length = 12)
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Basic
    @Column(name = "CODIGO_CIDADE", nullable = false, precision = 0)
    public int getCodigoCidade() {
        return codigoCidade;
    }

    public void setCodigoCidade(int codigoCidade) {
        this.codigoCidade = codigoCidade;
    }

    @Basic
    @Column(name = "TIPO", nullable = false, precision = 0)
    public boolean isTipo() {
        return tipo;
    }

    public void setTipo(boolean tipo) {
        this.tipo = tipo;
    }

    @Basic
    @Column(name = "CODIGO_RESTAURANTE", nullable = true, precision = 0)
    public Integer getCodigoRestaurante() {
        return codigoRestaurante;
    }

    public void setCodigoRestaurante(Integer codigoRestaurante) {
        this.codigoRestaurante = codigoRestaurante;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Hotel hotel = (Hotel) o;

        if (codigo != hotel.codigo) return false;
        if (codigoCidade != hotel.codigoCidade) return false;
        if (tipo != hotel.tipo) return false;
        if (nome != null ? !nome.equals(hotel.nome) : hotel.nome != null) return false;
        if (rua != null ? !rua.equals(hotel.rua) : hotel.rua != null) return false;
        if (bairro != null ? !bairro.equals(hotel.bairro) : hotel.bairro != null) return false;
        if (numero != null ? !numero.equals(hotel.numero) : hotel.numero != null) return false;
        if (codigoRestaurante != null ? !codigoRestaurante.equals(hotel.codigoRestaurante) : hotel.codigoRestaurante != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = codigo;
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + (rua != null ? rua.hashCode() : 0);
        result = 31 * result + (bairro != null ? bairro.hashCode() : 0);
        result = 31 * result + (numero != null ? numero.hashCode() : 0);
        result = 31 * result + codigoCidade;
        result = 31 * result + (tipo ? 1 : 0);
        result = 31 * result + (codigoRestaurante != null ? codigoRestaurante.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "CODIGO_RESTAURANTE", referencedColumnName = "CODIGO")
    public Restaurante getRestauranteByCodigoRestaurante() {
        return restauranteByCodigoRestaurante;
    }

    public void setRestauranteByCodigoRestaurante(Restaurante restauranteByCodigoRestaurante) {
        this.restauranteByCodigoRestaurante = restauranteByCodigoRestaurante;
    }

    @OneToMany(mappedBy = "hotelByCodigoHotel")
    public Collection<Quarto> getQuartosByCodigo() {
        return quartosByCodigo;
    }

    public void setQuartosByCodigo(Collection<Quarto> quartosByCodigo) {
        this.quartosByCodigo = quartosByCodigo;
    }
}
