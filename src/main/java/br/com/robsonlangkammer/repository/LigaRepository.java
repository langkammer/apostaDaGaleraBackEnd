package br.com.robsonlangkammer.repository;


import br.com.robsonlangkammer.model.LigasModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LigaRepository extends JpaRepository<LigasModel, Long> {


    @Query("FROM LigasModel c " +
           "WHERE LOWER(c.nome) like %:searchTerm% ")
    Page<LigasModel> search(@Param("campo") String searchTerm,   Pageable pageable);



}
