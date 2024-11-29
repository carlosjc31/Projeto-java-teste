package com.cidades.cidades.dtos;

public record CidadeResponse(
    long id,
    String nome,
    String estado,
    int populacao,
    String regiao
) {
    
}
