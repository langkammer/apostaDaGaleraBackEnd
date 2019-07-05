package br.com.robsonlangkammer.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * Created by robson on 12/06/19.
 */
@Entity
public class GruposModel {


    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private VinculosModel vinculosModel;

    private String nome;

    @OneToOne
    private LigasModel ligaModel;

    private String descritivo;

    @OneToOne
    private CriterioModel criterioPrincipal;

    @OneToOne
    private CriterioModel criterioSecundario;

    private boolean status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public VinculosModel getVinculosModel() {
        return vinculosModel;
    }

    public void setVinculosModel(VinculosModel vinculosModel) {
        this.vinculosModel = vinculosModel;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LigasModel getLigaModel() {
        return ligaModel;
    }

    public void setLigaModel(LigasModel ligaModel) {
        this.ligaModel = ligaModel;
    }

    public String getDescritivo() {
        return descritivo;
    }

    public void setDescritivo(String descritivo) {
        this.descritivo = descritivo;
    }

    public CriterioModel getCriterioPrincipal() {
        return criterioPrincipal;
    }

    public void setCriterioPrincipal(CriterioModel criterioPrincipal) {
        this.criterioPrincipal = criterioPrincipal;
    }

    public CriterioModel getCriterioSecundario() {
        return criterioSecundario;
    }

    public void setCriterioSecundario(CriterioModel criterioSecundario) {
        this.criterioSecundario = criterioSecundario;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
