package com.cidades.cidades.mappers;

import com.cidades.cidades.dtos.CidadeResponse;
import com.cidades.cidades.entities.Cidade;

public class CidadeMapper {
    
    public static Cidade toEntity(CidadeResponse cidadeRequest){
        Cidade cidade = new Cidade();
        cidade.setNome(cidadeRequest.nome());
        cidade.setEstado(cidadeRequest.estado());
        cidade.setPopulacao(cidadeRequest.populacao());
        cidade.setRegiao(cidadeRequest.regiao());

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
