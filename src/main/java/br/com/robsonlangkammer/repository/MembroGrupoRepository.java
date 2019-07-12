package br.com.robsonlangkammer.repository;


import br.com.robsonlangkammer.model.MembroGruposModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



public interface MembroGrupoRepository extends JpaRepository<MembroGruposModel, Long> {

    @Query("SELECT i FROM MembroGruposModel i where i.grupo.id =:key and i.vinculo.email =:email")
    MembroGruposModel findByGrupoIdAndVinculoEmail(@Param("key") Long id,@Param("email") String email);

    Page<MembroGruposModel> findByGrupoId(@Param("id") Long id,   Pageable pageable);

}
