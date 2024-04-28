package br.com.fiap.concessionaria.dto.request;

import br.com.fiap.concessionaria.entity.Acessorio;
import br.com.fiap.concessionaria.entity.Fabricante;
import br.com.fiap.concessionaria.entity.TipoVeiculo;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.Year;
import java.util.LinkedHashSet;
import java.util.Set;

public record VeiculoRequest(

        @Size(min = 3, max = 100)
        @NotNull(message = "Nome é obrigatorio!")
        String nome,

        @NotNull(message = "Ano de fabricação é obrigatorio!")
        Year anoDeFabricacao,

        @NotNull(message = "Cor é obrigatorio!")
        String cor,

        @NotNull(message = "Preço é obrigatorio!")
        Double preco,

        @NotNull(message = "Cilindradas é obrigatorio!")
        Short cilindradas,

        @NotNull(message = "Modelo é obrigatorio!")
        String modelo,

        @Size(min = 3, max = 15) // 15 dígitos
        @NotNull(message = "Palavra de efeito é obrigatorio!")
        String palavraDeEfeito,

        @NotNull(message = "Fabricante é obrigatorio!")
        AbstractRequest fabricante,


        @NotNull(message = "Tipo é obrigatorio!")
        AbstractRequest tipo

) {
}
