package br.com.robsonlangkammer.bean;

import br.com.robsonlangkammer.model.LigasModel;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by robson on 05/07/19.
 */
public class LigaBean {
    private Long id;
    private String logoLigatring;
    private Integer qtdRodadas;
    private Integer rodadaAtual;
    private String tipoLiga;
    private String formatoLiga;
    private boolean status;
    private String edicao;
    private List<TimeBean> times;
    private List<RodadaBean> rodadas;

    public LigaBean(){

    }

    public LigaBean(LigasModel l){
        this.id = l.getId();
        this.logoLigatring = l.getLogoLigatring();
        this.qtdRodadas = l.getQtdRodadas();
        this.rodadaAtual = l.getRodadaAtual();
        this.tipoLiga = l.getTipoLiga();
        this.formatoLiga = l.getFormatoLiga();
        this.status = l.isStatus();
        this.edicao = l.getEdicao();
        this.times = TimeBean.converterList(l.getTimes());
        this.rodadas = RodadaBean.converterList(l.getRodadas());
    }

    public static List<LigaBean> converterList(List<LigasModel> list){
        return list.stream().map(LigaBean::new).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Integer getRodadaAtual() {
        return rodadaAtual;
    }

    public void setRodadaAtual(Integer rodadaAtual) {
        this.rodadaAtual = rodadaAtual;
    }

    public String getTipoLiga() {
        return tipoLiga;
    }

    public void setTipoLiga(String tipoLiga) {
        this.tipoLiga = tipoLiga;
    }

    public String getFormatoLiga() {
        return formatoLiga;
    }

    public void setFormatoLiga(String formatoLiga) {
        this.formatoLiga = formatoLiga;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getEdicao() {
        return edicao;
    }

    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }

    public List<TimeBean> getTimes() {
        return times;
    }

    public void setTimes(List<TimeBean> times) {
        this.times = times;
    }

    public List<RodadaBean> getRodadas() {
        return rodadas;
    }

    public void setRodadas(List<RodadaBean> rodadas) {
        this.rodadas = rodadas;
    }
}
