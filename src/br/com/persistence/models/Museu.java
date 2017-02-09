package br.com.persistence.models;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by berg on 08/02/17.
 */
@Entity
public class Museu {
    private int codigo;
    private String nome;
    private String rua;
    private String bairro;
    private String numero;
    private String descricao;
    private byte numeroSalas;
    private int codigoCidade;
    private Collection<Funda> fundasByCodigo;
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
    @Column(name = "NUMERO_SALAS", nullable = false, precision = 0)
    public byte getNumeroSalas() {
        return numeroSalas;
    }

    public void setNumeroSalas(byte numeroSalas) {
        this.numeroSalas = numeroSalas;
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

        Museu museu = (Museu) o;

        if (codigo != museu.codigo) return false;
        if (numeroSalas != museu.numeroSalas) return false;
        if (codigoCidade != museu.codigoCidade) return false;
        if (nome != null ? !nome.equals(museu.nome) : museu.nome != null) return false;
        if (rua != null ? !rua.equals(museu.rua) : museu.rua != null) return false;
        if (bairro != null ? !bairro.equals(museu.bairro) : museu.bairro != null) return false;
        if (numero != null ? !numero.equals(museu.numero) : museu.numero != null) return false;
        if (descricao != null ? !descricao.equals(museu.descricao) : museu.descricao != null) return false;

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
        result = 31 * result + (int) numeroSalas;
        result = 31 * result + codigoCidade;
        return result;
    }

    @Override
    public String toString() {
        return "Museu{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", rua='" + rua + '\'' +
                ", bairro='" + bairro + '\'' +
                ", numero='" + numero + '\'' +
                ", descricao='" + descricao + '\'' +
                ", numeroSalas=" + numeroSalas +
                ", codigoCidade=" + codigoCidade +
                ", fundasByCodigo=" + fundasByCodigo +
                ", cidadeByCodigoCidade=" + cidadeByCodigoCidade +
                '}';
    }

    @OneToMany(mappedBy = "museuByCodigoMuseu")
    public Collection<Funda> getFundasByCodigo() {
        return fundasByCodigo;
    }

    public void setFundasByCodigo(Collection<Funda> fundasByCodigo) {
        this.fundasByCodigo = fundasByCodigo;
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
