package br.com.robsonlangkammer.bean;

import br.com.robsonlangkammer.model.CriterioModel;
import br.com.robsonlangkammer.model.LigasModel;
import br.com.robsonlangkammer.model.VinculosModel;

/**
 * Created by robson on 02/07/19.
 */
public class GrupoBean {

    private Long id;

    private VinculosModel vinculosModel;

    private String nome;

    private LigasModel ligaModel;

    private String descritivo;

    private CriterioModel criterioPrincipal;

    private boolean bonusPorTodosAcertosPrincipal;

    private CriterioModel criterioSecundario;

    private boolean criterioSecundarioAcumulaPrincipal;

    private boolean bonusPorTodosAcertosSecundario;

    private boolean status;
}
