package br.com.robsonlangkammer.model;

import br.com.robsonlangkammer.bean.PartidaBean;
import javax.persistence.*;
import java.util.Date;

/**
 * Created by robson on 12/06/19.
 */
@Entity
public class PartidaModel {

    @Id
    @GeneratedValue
    private Long id;

    private Integer rodada;

    @OneToOne
    private TimeFutebolModel time1;

    @OneToOne
    private TimeFutebolModel time2;

    private Date data;

    private String horario;

    private String estadio;

    private String local;

    private Integer placar1;

    private Integer placar2;


    public PartidaModel(){

    }

    public PartidaModel(PartidaModel partida) {
        this.rodada = partida.getRodada();
        this.time1 = partida.getTime1();
        this.time2 = partida.getTime2();
        this.data = partida.getData();
        this.horario = partida.getHorario();
        this.estadio = partida.getHorario();
        this.local = partida.getLocal();
        this.placar1 = partida.getPlacar1();
        this.placar2 = partida.getPlacar2();

    }

    public PartidaModel(PartidaBean partidaBean,TimeFutebolModel time1,TimeFutebolModel time2) {
        this.rodada = partidaBean.getRodada();
        this.time1 = time1;
        this.time2 = time2;
        this.data = partidaBean.getData();
        this.horario = partidaBean.getHorario();
        this.estadio = partidaBean.getHorario();
        this.local = partidaBean.getLocal();
        this.placar1 = partidaBean.getPlacar1();
        this.placar2 = partidaBean.getPlacar2();

    }


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

    public TimeFutebolModel getTime1() {
        return time1;
    }

    public void setTime1(TimeFutebolModel time1) {
        this.time1 = time1;
    }

    public TimeFutebolModel getTime2() {
        return time2;
    }

    public void setTime2(TimeFutebolModel time2) {
        this.time2 = time2;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
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
