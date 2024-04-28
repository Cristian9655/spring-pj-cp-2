package br.com.fiap.concessionaria.dto.request;

import br.com.fiap.concessionaria.entity.Veiculo;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CaracteristicaRequest(

        @Size(min = 3, max = 30)
        @NotNull(message = "Nome é obrigatorio!")
        String nome,


        @Size(min = 3, max = 20)
        @NotNull(message = "Um preço é obrigatorio.")
        String descricao,

        @Valid
        @NotNull(message = "Veiculo é obrigatorio.")
        AbstractRequest veiculo
) {
}
