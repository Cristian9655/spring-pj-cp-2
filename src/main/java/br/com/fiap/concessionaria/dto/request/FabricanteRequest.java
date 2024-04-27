package br.com.fiap.concessionaria.dto.request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record FabricanteRequest(

        @Size(min = 3, max = 100)
        @NotNull(message = "Nome é obrigatorio!")
        String nome,

        @Size(min = 3, max = 100)
        @NotNull(message = "Defina o nome da fantasia!")
        String nomeFantasia
) {
}
