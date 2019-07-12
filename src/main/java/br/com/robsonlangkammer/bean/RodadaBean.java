package br.com.robsonlangkammer.bean;

import java.util.Date;
import java.util.List;

/**
 * Created by robson on 04/07/19.
 */
public class RodadaBean {

    private Long id;

    private Integer rodada;

    private Date dataAbertura;

    private String horaAbertura;

    private List<PartidaBean> partidas;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getRodada() {
        return rodada;
    }

    public void setRodada(Integer rodada) {
        this.rodada = rodada;
    }

    public Date getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Date dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public String getHoraAbertura() {
        return horaAbertura;
    }

    public void setHoraAbertura(String horaAbertura) {
        this.horaAbertura = horaAbertura;
    }

    public List<PartidaBean> getPartidas() {
        return partidas;
    }

    public void setPartidas(List<PartidaBean> partidas) {
        this.partidas = partidas;
    }
}
