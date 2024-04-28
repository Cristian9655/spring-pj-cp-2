package br.com.fiap.concessionaria.dto.response;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jdk.jshell.Snippet;
import lombok.Builder;

@Builder
public record AcessorioResponse(
        Long id,
        String nome,
        Double preco
) {
}
