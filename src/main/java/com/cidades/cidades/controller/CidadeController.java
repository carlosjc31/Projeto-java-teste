package com.cidades.cidades.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cidades.cidades.entities.Cidade;
import com.cidades.cidades.services.CidadeService;

@RestController
@RequestMapping("cidades")
public class CidadeController {

    @Autowired
    private CidadeService service;

    @GetMapping
    public ResponseEntity <List<Cidade>> getCidades(){
        return ResponseEntity.ok( service.getAllCidades());
    }

    @GetMapping("{id}")
    public ResponseEntity<Cidade> getCidade(@PathVariable long id){
        return ResponseEntity.ok(service.getCidadeById(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteCidade(@PathVariable long id){
        service.delete(id);
        return  ResponseEntity.noContent().build(); 
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> updateCidade(@PathVariable long id, 
                                             @RequestBody Cidade cidade){

        service.update(cidade, id);
        return ResponseEntity.ok().build();  
    }

    @PostMapping
    public ResponseEntity<Cidade> saveCidade(@RequestBody Cidade cidade){
        Cidade newCidade =service.save(cidade);
        return ResponseEntity.created(null).body(newCidade);
    }
    
}