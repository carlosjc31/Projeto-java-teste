package com.cidades.cidades.mappers;

import com.cidades.cidades.dtos.CidadeResponse;
import com.cidades.cidades.entities.Cidade;

public class CidadeMapper {
    
    public static CidadeResponse toDTO(Cidade cidade){
        return new CidadeResponse(  cidade.getId(),
                                    cidade.getNome(), 
                                    cidade.getEstado(), 
                                    cidade.getPopulacao(), 
                                    cidade.getRegiao());
    }
}
