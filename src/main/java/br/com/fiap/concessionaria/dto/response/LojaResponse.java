package br.com.fiap.concessionaria.dto.response;

import br.com.fiap.concessionaria.dto.request.VeiculoRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;

@Builder
public record LojaResponse(

        Long id,
        String nome,

        VeiculoResponse veiculosComercializados
) {
}
