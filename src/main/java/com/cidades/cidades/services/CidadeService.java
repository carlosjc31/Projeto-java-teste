package com.cidades.cidades.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cidades.cidades.entities.Cidade;
import com.cidades.cidades.repositories.CidadeRepository;

import jakarta.persistence.EntityNotFoundException;


@Service
public class CidadeService {
    
    @Autowired
    private CidadeRepository repository;

    public List<Cidade> getAllCidades(){

        return repository.findAll(); // recupera os dados da cidade
    }

    public Cidade getCidadeById(long id){
        return this.repository.findById(id).orElseThrow(
            () -> new EntityNotFoundException("Cidade não cadastrada!")             
        );
    }

    public void delete(long id){
        if (repository.existsById(id)){
            repository.deleteById(id);
        }
        else{
        throw new EntityNotFoundException("Cidade nao cadastrada!");
        }
    }

    public Cidade save(Cidade cidade){
        return repository.save(cidade);
    }

    public void update(Cidade  cidade, long id){
        Cidade aux = repository.getReferenceById(id);

        aux.setNome(cidade.getNome());
        aux.setEstado(cidade.getEstado());
        aux.setPopulacao(cidade.getPopulacao());
        aux.setRegiao(cidade.getRegiao());

        repository.save(aux);
    }

    }

