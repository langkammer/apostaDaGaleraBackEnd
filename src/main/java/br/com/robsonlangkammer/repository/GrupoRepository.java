package br.com.robsonlangkammer.repository;


import br.com.robsonlangkammer.model.GruposModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface GrupoRepository extends JpaRepository<GruposModel, Long> {

    Page<GruposModel> findByNomeContaining(@Param("nome") String nome,   Pageable pageable);



//    @Query(" select * from GruposModel p " +
//        "   join ligaModel. b " +
//        "   on p.id = b.person_id " +
//        "   join address c " +
//        "   on c.id = b.addresses_id " +
//        "   where c.zip = :zip", nativeQuery = true)
//    Page<GruposModel> get(@Param("zip") String zip);
//
    GruposModel findByIdAndLigaModelRodadasRodada(@Param("id") Long id,@Param("rodada") Integer rodada);



}
