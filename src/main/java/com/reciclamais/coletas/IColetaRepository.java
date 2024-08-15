package com.reciclamais.coletas;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IColetaRepository extends JpaRepository<Coleta, Long> {

}
