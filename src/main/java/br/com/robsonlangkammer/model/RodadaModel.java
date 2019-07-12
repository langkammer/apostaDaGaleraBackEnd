package br.com.robsonlangkammer.model;


import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by robson on 12/06/19.
 */
@Entity
public class RodadaModel {

    @Id
    @GeneratedValue
    private Long id;

    private Integer rodada;

    private Date dataAbertura;

    private String horaAbertura;

    @OneToMany(cascade = CascadeType.ALL,
        fetch = FetchType.LAZY)
    private List<PartidaModel> partidas;


    public RodadaModel(){

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

    public List<PartidaModel> getPartidas() {
        return partidas;
    }

    public void setPartidas(List<PartidaModel> partidas) {
        this.partidas = partidas;
    }
}
