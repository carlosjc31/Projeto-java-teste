package com.cidades.cidades.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cidades.cidades.entities.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {
    
}
