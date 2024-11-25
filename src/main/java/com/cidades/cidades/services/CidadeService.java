package com.cidades.cidades.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cidades.cidades.entities.Cidade;
import com.cidades.cidades.repositories.CidadeRepository;


@Service
public class CidadeService {
    
    @Autowired
    private CidadeRepository repository;

    public List<Cidade> getAllCidades(){

        return repository.findAll();
    }
    
}
