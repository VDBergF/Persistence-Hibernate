package br.com.persistence.models;

import javax.persistence.*;
import java.sql.Time;
import java.util.Collection;

/**
 * Created by berg on 08/02/17.
 */
@Entity
public class Fundador {
    private int codigo;
    private Time dataNascimento;
    private Time dataMorte;
    private String nacionalidade;
    private String profissao;
    private String nome;
    private Collection<Funda> fundasByCodigo;

    @Id
    @Column(name = "CODIGO", nullable = false, precision = 0)
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Basic
    @Column(name = "DATA_NASCIMENTO", nullable = false)
    public Time getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Time dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Basic
    @Column(name = "DATA_MORTE", nullable = true)
    public Time getDataMorte() {
        return dataMorte;
    }

    public void setDataMorte(Time dataMorte) {
        this.dataMorte = dataMorte;
    }

    @Basic
    @Column(name = "NACIONALIDADE", nullable = false, length = 50)
    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    @Basic
    @Column(name = "PROFISSAO", nullable = true, length = 50)
    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    @Basic
    @Column(name = "NOME", nullable = false, length = 100)
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Fundador fundador = (Fundador) o;

        if (codigo != fundador.codigo) return false;
        if (dataNascimento != null ? !dataNascimento.equals(fundador.dataNascimento) : fundador.dataNascimento != null)
            return false;
        if (dataMorte != null ? !dataMorte.equals(fundador.dataMorte) : fundador.dataMorte != null) return false;
        if (nacionalidade != null ? !nacionalidade.equals(fundador.nacionalidade) : fundador.nacionalidade != null)
            return false;
        if (profissao != null ? !profissao.equals(fundador.profissao) : fundador.profissao != null) return false;
        if (nome != null ? !nome.equals(fundador.nome) : fundador.nome != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = codigo;
        result = 31 * result + (dataNascimento != null ? dataNascimento.hashCode() : 0);
        result = 31 * result + (dataMorte != null ? dataMorte.hashCode() : 0);
        result = 31 * result + (nacionalidade != null ? nacionalidade.hashCode() : 0);
        result = 31 * result + (profissao != null ? profissao.hashCode() : 0);
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Fundador{" +
                "codigo=" + codigo +
                ", dataNascimento=" + dataNascimento +
                ", dataMorte=" + dataMorte +
                ", nacionalidade='" + nacionalidade + '\'' +
                ", profissao='" + profissao + '\'' +
                ", nome='" + nome + '\'' +
                ", fundasByCodigo=" + fundasByCodigo +
                '}';
    }

    @OneToMany(mappedBy = "fundadorByCodigoFundador")
    public Collection<Funda> getFundasByCodigo() {
        return fundasByCodigo;
    }

    public void setFundasByCodigo(Collection<Funda> fundasByCodigo) {
        this.fundasByCodigo = fundasByCodigo;
    }
}
