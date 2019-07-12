package br.com.robsonlangkammer.repository;


import br.com.robsonlangkammer.model.LigasModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LigaRepository extends JpaRepository<LigasModel, Long> {

    Page<LigasModel> findByTipoLigaContaining(@Param("tipoLiga") String tipoLiga,   Pageable pageable);

    List<LigasModel> findByStatus(@Param("status") boolean status);


    @Query(" select distinct(p) from LigasModel p " +
           " join fetch p.rodadas r where p.id =:id and r.rodada =:rodada")
    LigasModel getLigaByRodada(@Param("id") Long id,
                               @Param("rodada") Integer rodada);

}
