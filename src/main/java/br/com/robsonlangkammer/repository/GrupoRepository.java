package br.com.robsonlangkammer.repository;


import br.com.robsonlangkammer.model.GruposModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface GrupoRepository extends JpaRepository<GruposModel, Long> {

    Page<GruposModel> findByNomeContaining(@Param("nome") String nome,   Pageable pageable);


}
