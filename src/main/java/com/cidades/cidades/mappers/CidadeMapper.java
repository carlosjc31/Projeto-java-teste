package com.cidades.cidades.mappers;

import com.cidades.cidades.dtos.CidadeRequest;
import com.cidades.cidades.dtos.CidadeResponse;
import com.cidades.cidades.entities.Cidade;

public class CidadeMapper {
    
    public static Cidade toEntity(CidadeRequest cidade2){
        Cidade cidade = new Cidade();
        cidade.setNome(cidade2.nome());
        cidade.setEstado(cidade2.estado());
        cidade.setPopulacao(cidade2.populacao());
        cidade.setRegiao(cidade2.regiao());

        return cidade;
    }

    public static CidadeResponse toDTO(Cidade cidade){
        return new CidadeResponse(  cidade.getId(),
                                    cidade.getNome(), 
                                    cidade.getEstado(), 
                                    cidade.getPopulacao(), 
                                    cidade.getRegiao());
    }
}
