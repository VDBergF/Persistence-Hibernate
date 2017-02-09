package br.com.persistence.models;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by berg on 08/02/17.
 */
@Entity
public class Restaurante {
    private int codigo;
    private String nome;
    private String rua;
    private String bairro;
    private String numero;
    private String especialidade;
    private long precoMedio;
    private String tipo;
    private int codigoCidade;
    private Collection<CasaShow> casaShowsByCodigo;
    private Collection<Hotel> hotelsByCodigo;
    private Cidade cidadeByCodigoCidade;

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
    @Column(name = "ESPECIALIDADE", nullable = false, length = 30)
    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    @Basic
    @Column(name = "PRECO_MEDIO", nullable = false, precision = 2)
    public long getPrecoMedio() {
        return precoMedio;
    }

    public void setPrecoMedio(long precoMedio) {
        this.precoMedio = precoMedio;
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
    @Column(name = "CODIGO_CIDADE", nullable = false, precision = 0)
    public int getCodigoCidade() {
        return codigoCidade;
    }

    public void setCodigoCidade(int codigoCidade) {
        this.codigoCidade = codigoCidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Restaurante that = (Restaurante) o;

        if (codigo != that.codigo) return false;
        if (precoMedio != that.precoMedio) return false;
        if (codigoCidade != that.codigoCidade) return false;
        if (nome != null ? !nome.equals(that.nome) : that.nome != null) return false;
        if (rua != null ? !rua.equals(that.rua) : that.rua != null) return false;
        if (bairro != null ? !bairro.equals(that.bairro) : that.bairro != null) return false;
        if (numero != null ? !numero.equals(that.numero) : that.numero != null) return false;
        if (especialidade != null ? !especialidade.equals(that.especialidade) : that.especialidade != null)
            return false;
        if (tipo != null ? !tipo.equals(that.tipo) : that.tipo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = codigo;
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + (rua != null ? rua.hashCode() : 0);
        result = 31 * result + (bairro != null ? bairro.hashCode() : 0);
        result = 31 * result + (numero != null ? numero.hashCode() : 0);
        result = 31 * result + (especialidade != null ? especialidade.hashCode() : 0);
        result = 31 * result + (int) (precoMedio ^ (precoMedio >>> 32));
        result = 31 * result + (tipo != null ? tipo.hashCode() : 0);
        result = 31 * result + codigoCidade;
        return result;
    }

    @Override
    public String toString() {
        return "Restaurante{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", rua='" + rua + '\'' +
                ", bairro='" + bairro + '\'' +
                ", numero='" + numero + '\'' +
                ", especialidade='" + especialidade + '\'' +
                ", precoMedio=" + precoMedio +
                ", tipo='" + tipo + '\'' +
                ", codigoCidade=" + codigoCidade +
                ", casaShowsByCodigo=" + casaShowsByCodigo +
                ", hotelsByCodigo=" + hotelsByCodigo +
                ", cidadeByCodigoCidade=" + cidadeByCodigoCidade +
                '}';
    }

    @OneToMany(mappedBy = "restauranteByCodigoRestaurante")
    public Collection<CasaShow> getCasaShowsByCodigo() {
        return casaShowsByCodigo;
    }

    public void setCasaShowsByCodigo(Collection<CasaShow> casaShowsByCodigo) {
        this.casaShowsByCodigo = casaShowsByCodigo;
    }

    @OneToMany(mappedBy = "restauranteByCodigoRestaurante")
    public Collection<Hotel> getHotelsByCodigo() {
        return hotelsByCodigo;
    }

    public void setHotelsByCodigo(Collection<Hotel> hotelsByCodigo) {
        this.hotelsByCodigo = hotelsByCodigo;
    }

    @ManyToOne
    @JoinColumn(name = "CODIGO_CIDADE", referencedColumnName = "CODIGO", nullable = false)
    public Cidade getCidadeByCodigoCidade() {
        return cidadeByCodigoCidade;
    }

    public void setCidadeByCodigoCidade(Cidade cidadeByCodigoCidade) {
        this.cidadeByCodigoCidade = cidadeByCodigoCidade;
    }
}
