package br.com.fiap.concessionaria.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record TipoVeiculoRequest(
        @Size(min = 3, max = 50)
        @NotNull(message = "Nome é obrigatorio!")
        String nome
) {
}
