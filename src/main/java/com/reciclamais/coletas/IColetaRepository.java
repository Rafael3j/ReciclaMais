package com.reciclamais.coletas;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IColetaRepository extends JpaRepository<Coleta, Long> {

    @Query(value = "Select c From Coleta c Where Lower(c.nome) like %?1%")
    List<Coleta> BuscarPorNome(String nome);
}
