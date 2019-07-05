package br.com.robsonlangkammer.model;

import br.com.robsonlangkammer.enums.TipoCriterioEnum;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by robson on 12/06/19.
 */
@Entity
public class CriterioModel {

    @Id
    @GeneratedValue
    private Long id;

    private TipoCriterioEnum tipoCriterioEnum;

    private Integer ponto;

    private boolean bonifica;

    private Integer pontoBonus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoCriterioEnum getTipoCriterioEnum() {
        return tipoCriterioEnum;
    }

    public void setTipoCriterioEnum(TipoCriterioEnum tipoCriterioEnum) {
        this.tipoCriterioEnum = tipoCriterioEnum;
    }

    public Integer getPonto() {
        return ponto;
    }

    public void setPonto(Integer ponto) {
        this.ponto = ponto;
    }

    public boolean isBonifica() {
        return bonifica;
    }

    public void setBonifica(boolean bonifica) {
        this.bonifica = bonifica;
    }

    public Integer getPontoBonus() {
        return pontoBonus;
    }

    public void setPontoBonus(Integer pontoBonus) {
        this.pontoBonus = pontoBonus;
    }
}
