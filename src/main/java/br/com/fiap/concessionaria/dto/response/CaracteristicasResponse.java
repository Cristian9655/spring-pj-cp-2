package br.com.fiap.concessionaria.dto.response;

import br.com.fiap.concessionaria.dto.request.AbstractRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;

@Builder
public record CaracteristicasResponse(

        Long id,
        String nome,


        String descricao,


        VeiculoResponse veiculo
) {
}
