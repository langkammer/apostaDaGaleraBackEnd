package br.com.robsonlangkammer.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.Date;

/**
 * Created by robson on 12/06/19.
 */
@Entity
public class MembroGruposModel {


    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private VinculosModel vinculo;

    @OneToOne
    private GruposModel grupo;

    private Date dataEntrada;

    public MembroGruposModel(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public VinculosModel getVinculo() {
        return vinculo;
    }

    public void setVinculo(VinculosModel vinculo) {
        this.vinculo = vinculo;
    }

    public GruposModel getGrupo() {
        return grupo;
    }

    public void setGrupo(GruposModel grupo) {
        this.grupo = grupo;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }
}
