package br.com.robsonlangkammer.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * Created by robson on 12/06/19.
 */
@Entity
public class ApostasModel {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private MembroGruposModel membro;

    @OneToOne
    private PartidaModel partidaModel;

    private Integer apostaMandante;

    private Integer apostaVisitante;

    @OneToOne
    private TimeFutebolModel vencedor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MembroGruposModel getMembro() {
        return membro;
    }

    public void setMembro(MembroGruposModel membro) {
        this.membro = membro;
    }

    public PartidaModel getPartidaModel() {
        return partidaModel;
    }

    public void setPartidaModel(PartidaModel partidaModel) {
        this.partidaModel = partidaModel;
    }

    public Integer getApostaMandante() {
        return apostaMandante;
    }

    public void setApostaMandante(Integer apostaMandante) {
        this.apostaMandante = apostaMandante;
    }

    public Integer getApostaVisitante() {
        return apostaVisitante;
    }

    public void setApostaVisitante(Integer apostaVisitante) {
        this.apostaVisitante = apostaVisitante;
    }

    public TimeFutebolModel getVencedor() {
        return vencedor;
    }

    public void setVencedor(TimeFutebolModel vencedor) {
        this.vencedor = vencedor;
    }
}
