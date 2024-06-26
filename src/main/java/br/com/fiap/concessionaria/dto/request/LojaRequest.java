package br.com.fiap.concessionaria.dto.request;

import br.com.fiap.concessionaria.entity.Veiculo;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.LinkedHashSet;
import java.util.Set;

public record LojaRequest(

        @Size(min = 3,max = 50, message = "Nome inválido")
        @NotNull(message = "Nome é obrigátorio")
        String nome

) {
}
