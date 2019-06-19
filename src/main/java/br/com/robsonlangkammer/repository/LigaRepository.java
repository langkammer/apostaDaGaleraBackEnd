package br.com.robsonlangkammer.repository;


import br.com.robsonlangkammer.model.LigasModel;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LigaRepository extends JpaRepository<LigasModel, Long> {


    @Query("FROM LigasModel c ")
    List<Object> search(Pageable pageable);
}
