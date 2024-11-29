package com.cidades.cidades.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CidadeRequest(

    @NotBlank(message = "nome não pode ser em branco")
    @Size(min = 3, message = "nome deve ter pelo menos 3 caracteres")
    String nome,

    @NotBlank(message = "estado não pode ser em branco")
    @Size(min = 2, message = "estado deve ter pelo menos 2 caracteres")
    String estado,

    @NotBlank(message = "população não pode ser em branco")
    @Size(min = 1, message = "população deve ter pelo menos 1 caracter")
    int populacao,

    @NotBlank(message = "região não pode ser em branco")
    @Size(min = 2, message = "região deve ter pelo menos 2 caracteres")
    String regiao
) {
}
