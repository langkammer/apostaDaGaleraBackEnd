package br.com.robsonlangkammer.model;

import br.com.robsonlangkammer.bean.LigaBean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.*;
import java.util.List;

/**
 * Created by robson on 12/06/19.
 */
@Entity
public class LigasModel {
    @Id
    @GeneratedValue
    private Long id;

    private String tipoLiga;

    private String logoLigatring;

    private Integer qtdRodadas;

    private String formatoLiga;

    private String edicao;

    private boolean status = true;

    public LigasModel(){

    }

    public LigasModel(LigaBean liga) {
        this.tipoLiga = liga.getTipoLiga();
        this.logoLigatring = liga.getLogoLigatring();
        this.edicao = liga.getEdicao();
    }

    @OneToMany(cascade = CascadeType.ALL,
        fetch = FetchType.LAZY)
    private List<TimeFutebolModel> times;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoLiga() {
        return tipoLiga;
    }

    public void setTipoLiga(String tipoLiga) {
        this.tipoLiga = tipoLiga;
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

    public String getFormatoLiga() {
        return formatoLiga;
    }

    public void setFormatoLiga(String formatoLiga) {
        this.formatoLiga = formatoLiga;
    }

    public String getEdicao() {
        return edicao;
    }

    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<TimeFutebolModel> getTimes() {
        return times;
    }

    public void setTimes(List<TimeFutebolModel> times) {
        this.times = times;
    }
}
