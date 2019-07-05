package br.com.robsonlangkammer.model;

import br.com.robsonlangkammer.bean.TimeBean;

import javax.persistence.*;

/**
 * Created by robson on 12/06/19.
 */
@Entity
public class TimeFutebolModel {

    @Id
    @GeneratedValue
    private Long id;

    private String nomeAbrev;

    private String nomeCompleto;

    private String escudoPathString;

    private String sigla;

    public TimeFutebolModel(){

    }

    public TimeFutebolModel(TimeFutebolModel timeFutebolModel) {
        this.nomeAbrev = timeFutebolModel.getNomeAbrev();
        this.nomeCompleto = timeFutebolModel.getNomeCompleto();
        this.escudoPathString = timeFutebolModel.getEscudoPathString();
        this.sigla = timeFutebolModel.getSigla();
    }


    public TimeFutebolModel(TimeBean bean) {
        this.nomeAbrev = bean.getNomeAbrev();
        this.nomeCompleto = bean.getNomeCompleto();
        this.escudoPathString = bean.getEscudoPathString();
        this.sigla = bean.getSigla();
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
