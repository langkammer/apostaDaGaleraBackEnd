package br.com.robsonlangkammer.bean;

import br.com.robsonlangkammer.model.PartidaModel;
import br.com.robsonlangkammer.model.RodadaModel;
import br.com.robsonlangkammer.util.Utils;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by robson on 04/07/19.
 */
public class RodadaBean {

    private Long id;

    private Integer rodada;

    private Date dataAbertura;

    private String dataAberturaStr;

    private String horaAbertura;

    private List<PartidaBean> partidas;

    public Long getId() {
        return id;
    }

    public RodadaBean(){}

    public RodadaBean(RodadaModel r){
        this.id = r.getId();
        this.rodada = r.getRodada();
        this.dataAbertura = r.getDataAbertura();
        this.dataAberturaStr =  Utils.converteDateToBr(r.getDataAbertura());
        this.horaAbertura = r.getHoraAbertura();
        this.partidas = PartidaBean.converterList(r.getPartidas());
    }

    public static List<RodadaBean> converterList(List<RodadaModel> list){
        return list.stream().map(RodadaBean::new).collect(Collectors.toList());
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

    public String getDataAberturaStr() {
        return dataAberturaStr;
    }

    public void setDataAberturaStr(String dataAberturaStr) {
        this.dataAberturaStr = dataAberturaStr;
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
