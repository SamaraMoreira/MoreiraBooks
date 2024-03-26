package br.com.samara.moreirabooks.model.livro.dtos;

import br.com.samara.moreirabooks.model.livro.Genero;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;


public record LivroInputDTO(

        @NotBlank
        String nome,
        @NotBlank
        String descricao,
        @NotNull
        Long idAutor,
        @NotNull
        BigDecimal valor,
        @NotNull
        Genero genero
) {
}
