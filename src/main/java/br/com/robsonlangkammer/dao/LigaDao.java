package br.com.robsonlangkammer.dao;

import br.com.robsonlangkammer.model.VinculosModel;
import br.com.robsonlangkammer.repository.LigaRepository;
import br.com.robsonlangkammer.repository.VinculoRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Repository
@Transactional
public class LigaDao {

    @PersistenceContext
    private EntityManager manager;

    private final LigaRepository ligaRepository;

    LigaDao(LigaRepository ligaRepository) {
        this.ligaRepository = ligaRepository;
    }


    public List<VinculosModel> listar(int pagina) {


        List<VinculosModel> lista = new ArrayList<VinculosModel>();

        String stringScript = "";
//
//        if(campoPesquisado != null && pesquisa != null){
//
//            if(campoPesquisado.equals("p.id") || campoPesquisado.equals("p.vendedor.id")){
//                lista = manager.createQuery(
//                    "select distinct(p) from VinculoModel p join fetch p.vendedor where " + campoPesquisado + " = :pesquisa ", Cliente.class)
//                    .setParameter("pesquisa",Long.parseLong(pesquisa))
//                    .getResultList();
//            }
//            else {
//                lista = manager.createQuery(
//                    "select distinct(p) from Cliente p join fetch p.vendedor where  " + campoPesquisado + "  like '%"+pesquisa+"%'", Cliente.class)
//                    .getResultList();
//            }
//
//        }
//        else{
//            lista = manager.createQuery("select distinct(p) from Cliente p join fetch p.vendedor", Cliente.class)
//                .getResultList();
//        }
//

        return lista;
    }


}
