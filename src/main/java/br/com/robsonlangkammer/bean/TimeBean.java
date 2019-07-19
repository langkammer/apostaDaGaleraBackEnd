package br.com.robsonlangkammer.bean;

import br.com.robsonlangkammer.model.TimeFutebolModel;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by robson on 04/07/19.
 */
public class TimeBean {

    private Long id;
    private String nomeAbrev;
    private String nomeCompleto;
    private String escudoPathString;
    private String sigla;


    public TimeBean(){}

    public TimeBean(TimeFutebolModel time){
        this.id = time.getId();
        this.nomeAbrev = time.getNomeAbrev();
        this.nomeCompleto = time.getNomeCompleto();
        this.escudoPathString = time.getEscudoPathString();
        this.sigla = time.getSigla();
    }

    public static List<TimeBean> converterList(List<TimeFutebolModel> list){
        return list.stream().map(TimeBean::new).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeAbrev() {
        return nomeAbrev;
    }

    public void setNomeAbrev(String nomeAbrev) {
        this.nomeAbrev = nomeAbrev;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getEscudoPathString() {
        return escudoPathString;
    }

    public void setEscudoPathString(String escudoPathString) {
        this.escudoPathString = escudoPathString;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

}
