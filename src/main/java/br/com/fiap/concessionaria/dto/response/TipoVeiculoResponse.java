package br.com.fiap.concessionaria.dto.response;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;

@Builder
public record TipoVeiculoResponse(

        Long id,

        String nome
) {
}
