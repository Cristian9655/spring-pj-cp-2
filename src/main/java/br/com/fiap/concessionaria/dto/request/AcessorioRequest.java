package br.com.fiap.concessionaria.dto.request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record AcessorioRequest(

        @Size(min = 3, max = 50)
        @NotNull(message = "Nome é obrigatorio!")
        String nome,

        @NotNull(message = "Um preço é obrigatorio!")
        Double preco

) {
}
