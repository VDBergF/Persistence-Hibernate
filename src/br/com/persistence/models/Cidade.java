package br.com.persistence.models;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by berg on 08/02/17.
 */
@Entity
public class Cidade {
    private int codigo;
    private String nome;
    private String estado;
    private Long populacao;
    private Collection<CasaShow> casaShowsByCodigo;
    private Collection<Igreja> igrejasByCodigo;
    private Collection<Museu> museusByCodigo;
    private Collection<Restaurante> restaurantesByCodigo;

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
    @Column(name = "ESTADO", nullable = false, length = 50)
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Basic
    @Column(name = "POPULACAO", nullable = true, precision = 0)
    public Long getPopulacao() {
        return populacao;
    }

    public void setPopulacao(Long populacao) {
        this.populacao = populacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cidade cidade = (Cidade) o;

        if (codigo != cidade.codigo) return false;
        if (nome != null ? !nome.equals(cidade.nome) : cidade.nome != null) return false;
        if (estado != null ? !estado.equals(cidade.estado) : cidade.estado != null) return false;
        if (populacao != null ? !populacao.equals(cidade.populacao) : cidade.populacao != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = codigo;
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + (estado != null ? estado.hashCode() : 0);
        result = 31 * result + (populacao != null ? populacao.hashCode() : 0);
        return result;
    }

//    @Override
//    public String toString() {
//        return "Cidade{" +
//                "codigo=" + codigo +
//                ", nome='" + nome + '\'' +
//                ", estado='" + estado + '\'' +
//                ", populacao=" + populacao +
//                ", casaShowsByCodigo=" + casaShowsByCodigo +
//                ", igrejasByCodigo=" + igrejasByCodigo +
//                ", museusByCodigo=" + museusByCodigo +
//                ", restaurantesByCodigo=" + restaurantesByCodigo +
//                '}';
//    }

    @OneToMany(mappedBy = "cidadeByCodigoCidade")
    public Collection<CasaShow> getCasaShowsByCodigo() {
        return casaShowsByCodigo;
    }

    public void setCasaShowsByCodigo(Collection<CasaShow> casaShowsByCodigo) {
        this.casaShowsByCodigo = casaShowsByCodigo;
    }

    @OneToMany(mappedBy = "cidadeByCodigoCidade")
    public Collection<Igreja> getIgrejasByCodigo() {
        return igrejasByCodigo;
    }

    public void setIgrejasByCodigo(Collection<Igreja> igrejasByCodigo) {
        this.igrejasByCodigo = igrejasByCodigo;
    }

    @OneToMany(mappedBy = "cidadeByCodigoCidade")
    public Collection<Museu> getMuseusByCodigo() {
        return museusByCodigo;
    }

    public void setMuseusByCodigo(Collection<Museu> museusByCodigo) {
        this.museusByCodigo = museusByCodigo;
    }

    @OneToMany(mappedBy = "cidadeByCodigoCidade")
    public Collection<Restaurante> getRestaurantesByCodigo() {
        return restaurantesByCodigo;
    }

    public void setRestaurantesByCodigo(Collection<Restaurante> restaurantesByCodigo) {
        this.restaurantesByCodigo = restaurantesByCodigo;
    }
}
