package br.com.persistence.models;

import javax.persistence.*;

/**
 * Created by berg on 08/02/17.
 */
@Entity
@Table(name = "CASA_SHOW", schema = "TURISMO_DB", catalog = "")
public class CasaShow {
    private int codigo;
    private String nome;
    private String rua;
    private String bairro;
    private String numero;
    private String descricao;
    private long horaInicio;
    private String diaFecha;
    private int codigoCidade;
    private Integer codigoRestaurante;
    private Cidade cidadeByCodigoCidade;
    private Restaurante restauranteByCodigoRestaurante;

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
    @Column(name = "DESCRICAO", nullable = true, length = 200)
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Basic
    @Column(name = "HORA_INICIO", nullable = false, precision = 0)
    public long getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(long horaInicio) {
        this.horaInicio = horaInicio;
    }

    @Basic
    @Column(name = "DIA_FECHA", nullable = false, length = 30)
    public String getDiaFecha() {
        return diaFecha;
    }

    public void setDiaFecha(String diaFecha) {
        this.diaFecha = diaFecha;
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

        CasaShow casaShow = (CasaShow) o;

        if (codigo != casaShow.codigo) return false;
        if (horaInicio != casaShow.horaInicio) return false;
        if (codigoCidade != casaShow.codigoCidade) return false;
        if (nome != null ? !nome.equals(casaShow.nome) : casaShow.nome != null) return false;
        if (rua != null ? !rua.equals(casaShow.rua) : casaShow.rua != null) return false;
        if (bairro != null ? !bairro.equals(casaShow.bairro) : casaShow.bairro != null) return false;
        if (numero != null ? !numero.equals(casaShow.numero) : casaShow.numero != null) return false;
        if (descricao != null ? !descricao.equals(casaShow.descricao) : casaShow.descricao != null) return false;
        if (diaFecha != null ? !diaFecha.equals(casaShow.diaFecha) : casaShow.diaFecha != null) return false;
        if (codigoRestaurante != null ? !codigoRestaurante.equals(casaShow.codigoRestaurante) : casaShow.codigoRestaurante != null)
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
        result = 31 * result + (descricao != null ? descricao.hashCode() : 0);
        result = 31 * result + (int) (horaInicio ^ (horaInicio >>> 32));
        result = 31 * result + (diaFecha != null ? diaFecha.hashCode() : 0);
        result = 31 * result + codigoCidade;
        result = 31 * result + (codigoRestaurante != null ? codigoRestaurante.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CasaShow{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", rua='" + rua + '\'' +
                ", bairro='" + bairro + '\'' +
                ", numero='" + numero + '\'' +
                ", descricao='" + descricao + '\'' +
                ", horaInicio=" + horaInicio +
                ", diaFecha='" + diaFecha + '\'' +
                ", codigoCidade=" + codigoCidade +
                ", codigoRestaurante=" + codigoRestaurante +
                ", cidadeByCodigoCidade=" + cidadeByCodigoCidade +
                ", restauranteByCodigoRestaurante=" + restauranteByCodigoRestaurante +
                '}';
    }

    @ManyToOne
    @JoinColumn(name = "CODIGO_CIDADE", referencedColumnName = "CODIGO", nullable = false)
    public Cidade getCidadeByCodigoCidade() {
        return cidadeByCodigoCidade;
    }

    public void setCidadeByCodigoCidade(Cidade cidadeByCodigoCidade) {
        this.cidadeByCodigoCidade = cidadeByCodigoCidade;
    }

    @ManyToOne
    @JoinColumn(name = "CODIGO_RESTAURANTE", referencedColumnName = "CODIGO")
    public Restaurante getRestauranteByCodigoRestaurante() {
        return restauranteByCodigoRestaurante;
    }

    public void setRestauranteByCodigoRestaurante(Restaurante restauranteByCodigoRestaurante) {
        this.restauranteByCodigoRestaurante = restauranteByCodigoRestaurante;
    }
}
