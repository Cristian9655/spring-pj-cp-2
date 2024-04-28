package br.com.fiap.concessionaria.dto.response;

import lombok.Builder;

@Builder
public record CaracteristicasResponse(
        Long id,
        String nome,
        String descricao,
        VeiculoResponse veiculo
) {
}
