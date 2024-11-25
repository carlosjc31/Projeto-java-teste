package com.cidades.cidades.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
    public List<Cidade> getCidades(){
        return service.getAllCidades();
    }
    
}