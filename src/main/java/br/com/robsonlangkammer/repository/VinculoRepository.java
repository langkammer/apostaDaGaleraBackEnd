package br.com.robsonlangkammer.repository;


import br.com.robsonlangkammer.model.VinculosModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface VinculoRepository extends JpaRepository<VinculosModel, Long> {

    Page<VinculosModel> findByNomeContaining(@Param("nome") String nome,   Pageable pageable);
    Page<VinculosModel> findByEmailContaining(@Param("email") String email,   Pageable pageable);

}
