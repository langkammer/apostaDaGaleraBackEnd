package br.com.robsonlangkammer.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by robson on 12/06/19.
 */
@Entity
public class LigasModel {

    @Id
    @GeneratedValue
    private Long id;

    private String nome;

    private String logoLigatring;

    private Integer qtdRodadas;

    private String tipoLiga;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogoLigatring() {
        return logoLigatring;
    }

    public void setLogoLigatring(String logoLigatring) {
        this.logoLigatring = logoLigatring;
    }

    public Integer getQtdRodadas() {
        return qtdRodadas;
    }

    public void setQtdRodadas(Integer qtdRodadas) {
        this.qtdRodadas = qtdRodadas;
    }

    public String getTipoLiga() {
        return tipoLiga;
    }

    public void setTipoLiga(String tipoLiga) {
        this.tipoLiga = tipoLiga;
    }
}
