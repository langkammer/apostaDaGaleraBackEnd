package br.com.robsonlangkammer.repository;


import br.com.robsonlangkammer.model.TimeFutebolModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;


public interface TimeFutebolRepository extends JpaRepository<TimeFutebolModel, Long> {

    Page<TimeFutebolModel> findBySiglaContaining(@Param("sigla") String sigla, Pageable pageable);
    Page<TimeFutebolModel> findByNomeCompletoContaining(@Param("nomeCompleto") String nomeCompleto, Pageable pageable);

    TimeFutebolModel findBySigla(@Param("sigla") String sigla);

}
