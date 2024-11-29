package com.cidades.cidades.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cidades.cidades.dtos.CidadeResponse;
import com.cidades.cidades.entities.Cidade;
import com.cidades.cidades.mappers.CidadeMapper;
import com.cidades.cidades.repositories.CidadeRepository;

import jakarta.persistence.EntityNotFoundException;


@Service
public class CidadeService {
    
    @Autowired
    private CidadeRepository repository;

    public List<CidadeResponse> getAllCidades(){
        return repository.findAll()
                         .stream()
                         .map(c -> CidadeMapper.toDTO(c))
                         .collect(Collectors.toList()); // recupera os dados da cidade
    }

    public CidadeResponse getCidadeById(long id){
        Cidade cidade = repository.findById(id).orElseThrow(
            () -> new EntityNotFoundException("Cidade não cadastrada!")             
        );
        return CidadeMapper.toDTO(cidade);
    }

    public void delete(long id){
        if (repository.existsById(id)){
            repository.deleteById(id);
        }
        else{
        throw new EntityNotFoundException("Cidade nao cadastrada!");
        }
    }

    public CidadeResponse save(Cidade cidade){
        Cidade newCidade = repository.save(cidade);
        return CidadeMapper.toDTO(newCidade);
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

