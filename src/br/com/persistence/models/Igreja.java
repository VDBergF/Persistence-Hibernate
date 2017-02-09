package br.com.persistence.models;

import javax.persistence.*;
import java.sql.Time;

/**
 * Created by berg on 08/02/17.
 */
@Entity
public class Igreja {
    private int codigo;
    private String nome;
    private String rua;
    private String bairro;
    private String numero;
    private String descricao;
    private String estilo;
    private Time dataConstrucao;
    private int codigoCidade;
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
    @Column(name = "DESCRICAO", nullable = true, length = 200)
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Basic
    @Column(name = "ESTILO", nullable = false, length = 50)
    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    @Basic
    @Column(name = "DATA_CONSTRUCAO", nullable = true)
    public Time getDataConstrucao() {
        return dataConstrucao;
    }

    public void setDataConstrucao(Time dataConstrucao) {
        this.dataConstrucao = dataConstrucao;
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

        Igreja igreja = (Igreja) o;

        if (codigo != igreja.codigo) return false;
        if (codigoCidade != igreja.codigoCidade) return false;
        if (nome != null ? !nome.equals(igreja.nome) : igreja.nome != null) return false;
        if (rua != null ? !rua.equals(igreja.rua) : igreja.rua != null) return false;
        if (bairro != null ? !bairro.equals(igreja.bairro) : igreja.bairro != null) return false;
        if (numero != null ? !numero.equals(igreja.numero) : igreja.numero != null) return false;
        if (descricao != null ? !descricao.equals(igreja.descricao) : igreja.descricao != null) return false;
        if (estilo != null ? !estilo.equals(igreja.estilo) : igreja.estilo != null) return false;
        if (dataConstrucao != null ? !dataConstrucao.equals(igreja.dataConstrucao) : igreja.dataConstrucao != null)
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
        result = 31 * result + (estilo != null ? estilo.hashCode() : 0);
        result = 31 * result + (dataConstrucao != null ? dataConstrucao.hashCode() : 0);
        result = 31 * result + codigoCidade;
        return result;
    }

    @Override
    public String toString() {
        return "Igreja{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", rua='" + rua + '\'' +
                ", bairro='" + bairro + '\'' +
                ", numero='" + numero + '\'' +
                ", descricao='" + descricao + '\'' +
                ", estilo='" + estilo + '\'' +
                ", dataConstrucao=" + dataConstrucao +
                ", codigoCidade=" + codigoCidade +
                ", cidadeByCodigoCidade=" + cidadeByCodigoCidade +
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
}
