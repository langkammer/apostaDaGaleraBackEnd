package br.com.robsonlangkammer.bean;


import br.com.robsonlangkammer.model.PartidaModel;
import br.com.robsonlangkammer.model.TimeFutebolModel;
import br.com.robsonlangkammer.util.Utils;

import javax.rmi.CORBA.Util;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by robson on 04/07/19.
 */
public class PartidaBean {

    private Integer rodada;
    private TimeBean time1;
    private TimeBean time2;
    private Date data;
    private String dataStr;
    private String horario;
    private String estadio;
    private String local;
    private Integer placar1;
    private Integer placar2;


    public PartidaBean(){

    }


    public PartidaBean(PartidaModel p){
        this.rodada = p.getRodada();
        this.time1 = new TimeBean(p.getTime1());
        this.time2 = new TimeBean(p.getTime2());
        this.data = p.getData();
        this.dataStr =  Utils.converteDateToBr(p.getData());
        this.horario = p.getHorario();
        this.estadio = p.getEstadio();
        this.local = p.getLocal();
        this.placar1 = p.getPlacar1();
        this.placar2 = p.getPlacar2();

    }

    public static List<PartidaBean> converterList(List<PartidaModel> list){
        return list.stream().map(PartidaBean::new).collect(Collectors.toList());
    }

    public Integer getRodada() {
        return rodada;
    }

    public void setRodada(Integer rodada) {
        this.rodada = rodada;
    }

    public TimeBean getTime1() {
        return time1;
    }

    public void setTime1(TimeBean time1) {
        this.time1 = time1;
    }

    public TimeBean getTime2() {
        return time2;
    }

    public void setTime2(TimeBean time2) {
        this.time2 = time2;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getDataStr() {
        return dataStr;
    }

    public void setDataStr(String dataStr) {
        this.dataStr = dataStr;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getEstadio() {
        return estadio;
    }

    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public Integer getPlacar1() {
        return placar1;
    }

    public void setPlacar1(Integer placar1) {
        this.placar1 = placar1;
    }

    public Integer getPlacar2() {
        return placar2;
    }

    public void setPlacar2(Integer placar2) {
        this.placar2 = placar2;
    }
}
