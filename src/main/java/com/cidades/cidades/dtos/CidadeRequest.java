package com.cidades.cidades.dtos;

public record CidadeRequest(
    String nome,
    String estado,
    int populacao,
    String regiao
) {
}
